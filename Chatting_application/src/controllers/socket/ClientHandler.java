package controllers.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

public class ClientHandler implements Runnable {
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientname;
    private String typeClient;
    private String idClient;


    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            String informationClient = bufferedReader.readLine();
            int indexIdAndUserName = informationClient.indexOf("/");
            int indexUserNameAndType = informationClient.indexOf("/ ");
            this.idClient = informationClient.substring(0, indexIdAndUserName);
            this.clientname = informationClient.substring(indexIdAndUserName+ 1, indexUserNameAndType);
            this.typeClient = informationClient.substring(indexUserNameAndType + 2, informationClient.length());
            System.out.println(this.idClient + " " + this.clientname + " " + this.typeClient);
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
                message_transfer(receiveMessage);
            } catch (IOException e) {
                closeEverything(this.socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void message_transfer(JTextField message) {
        String mess = message.getText();
        int indexTypeAndIdReceive = mess.indexOf("/");
        int indexIdReceiveAndMess = mess.indexOf("/ ");
        String type = mess.substring(0,indexTypeAndIdReceive);
        String IdReceive = mess.substring(indexTypeAndIdReceive+1, indexIdReceiveAndMess);
        mess  = mess.substring(indexIdReceiveAndMess+2, mess.length());
        System.out.println(type+"/"+IdReceive);
        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.idClient.equals(this.idClient)) {
                if(type.equals("user")){
                    if(clientHandler.idClient.equals(IdReceive) && clientHandler.typeClient.equals("user")) {
                        System.out.println(clientHandler.typeClient);
                        try {
                            clientHandler.bufferedWriter.write(mess);
                            clientHandler.bufferedWriter.newLine();
                            clientHandler.bufferedWriter.flush();
                        } catch (IOException e) {
                            closeEverything(this.socket, bufferedReader, bufferedWriter);
                        }
                    }
                }else if(type.equals("group") && clientHandler.typeClient.equals("group")){

                    try {
                        clientHandler.bufferedWriter.write(mess);
                        clientHandler.bufferedWriter.newLine();
                        clientHandler.bufferedWriter.flush();
                    } catch (IOException e) {
                        closeEverything(this.socket, bufferedReader, bufferedWriter);
                    }
                }

            }
        }
    }

    public void removeHandlers() {
        clientHandlers.remove(this);
        JTextField message = new JTextField();
        message.setText("Server: " + clientname + " has left the chat!");
        message_transfer(message);
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
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

