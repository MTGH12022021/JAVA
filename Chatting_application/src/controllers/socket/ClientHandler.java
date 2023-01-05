package controllers.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientHandler implements Runnable {
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientname;


    public ClientHandler(Socket socket) {

        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            this.clientname = bufferedReader.readLine();
            JTextField message = new JTextField();
            clientHandlers.add(this);
            message.setText("Server: " + clientname + " has entered the chat!\n");
            message_transfer(message);
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
        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.clientname.equals(this.clientname)) {
                try {
                    clientHandler.bufferedWriter.write(message.getText());
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEverything(this.socket, bufferedReader, bufferedWriter);
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

