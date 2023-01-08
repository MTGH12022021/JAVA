package controllers.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import controllers.Message.messageFriend;
import controllers.Message.messageGroup;

 public class ClientHandler implements Runnable {
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientname;
    private String typeClient;
    private String idClient;
    private messageFriend messFriend;
    private messageGroup messGroup;

    public ClientHandler(Socket socket) throws SQLException {
        try {

            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            String informationClient = bufferedReader.readLine();
            int indexIdAndUserName = informationClient.indexOf("/");
            int indexUserNameAndType = informationClient.indexOf("/ ");
            this.idClient = informationClient.substring(2, indexIdAndUserName);
            this.clientname = informationClient.substring(indexIdAndUserName+ 1, indexUserNameAndType);
            this.typeClient = informationClient.substring(indexUserNameAndType + 2, informationClient.length());
            this.messFriend = new messageFriend();
            this.messGroup = new messageGroup();
            JTextField message = new JTextField();
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(this.socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        JTextField receiveMessage = new JTextField();
        while (socket.isConnected()) {
            try {
                receiveMessage.setText(bufferedReader.readLine());
                if(receiveMessage.getText().startsWith("**")) {
                    String informationClient = receiveMessage.getText();
                    int indexIdAndUserName = informationClient.indexOf("/");
                    int indexUserNameAndType = informationClient.indexOf("/ ");
//                    this.idClient = informationClient.substring(2, indexIdAndUserName);
//                    this.clientname = informationClient.substring(indexIdAndUserName + 1, indexUserNameAndType);
                    this.typeClient = informationClient.substring(indexUserNameAndType + 2, informationClient.length());
                    System.out.println(this.idClient + " " + this.clientname + " " + this.typeClient);
                }else{
                    System.out.println("hello");
                    try {
                        message_transfer(receiveMessage);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (IOException e) {
                try {
                    closeEverything(this.socket, bufferedReader, bufferedWriter);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
        }
    }

    private void message_transfer(JTextField message) throws SQLException {
        String mess = message.getText();
        System.out.println(mess);
        int indexTypeAndIdReceive = mess.indexOf("/");
        int indexIdReceiveAndMess = mess.indexOf("/ ");
        String type = mess.substring(0, indexTypeAndIdReceive);
        String IdReceive = mess.substring(indexTypeAndIdReceive + 1, indexIdReceiveAndMess);
        mess = mess.substring(indexIdReceiveAndMess + 2, mess.length());

        ResultSet memberGroup = null;

        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.idClient.equals(this.idClient)) {
                if (type.equals("user")) {
                    if (clientHandler.idClient.equals(IdReceive) && clientHandler.typeClient.equals("user")) {
                        try {
                            String temp = this.idClient + "/" + mess;
                            clientHandler.bufferedWriter.write(temp);
                            clientHandler.bufferedWriter.newLine();
                            clientHandler.bufferedWriter.flush();
                        } catch (IOException e) {
                            closeEverything(this.socket, bufferedReader, bufferedWriter);
                        }
                    }
                } else if (type.equals("group") && clientHandler.typeClient.equals("group") && messGroup.checkInGroup(clientHandler.idClient, IdReceive)) {
                    try {
                        String temp = IdReceive + "/" + mess;
                        clientHandler.bufferedWriter.write(temp);
                        clientHandler.bufferedWriter.newLine();
                        clientHandler.bufferedWriter.flush();
                    } catch (IOException e) {
                        closeEverything(this.socket, bufferedReader, bufferedWriter);
                    }
                }
            } else {
                if (type.equals("user")) {
                    System.out.println("store message user");
                    messFriend.addMessage(this.idClient, IdReceive, mess);
                } else {
                    System.out.println("store message group");
                    messGroup.addMessage(this.idClient, IdReceive, mess);
                }
            }

        }
    }

    public void removeHandlers() throws SQLException {
        clientHandlers.remove(this);
        JTextField message = new JTextField();
        message.setText("Server: " + clientname + " has left the chat!");
        message_transfer(message);
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws SQLException {
        removeHandlers();
        try {
            if (socket != null) {
                socket.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

