package controllers.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //todo các khai biến quan trọng
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void StartServer(){
        try {
            while(!serverSocket.isClosed()){
                System.out.println("Waiting for connect request...");
                Socket socket = serverSocket.accept();
                System.out.println("Connect request is accepted...");

                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void closeServerSocket(){
        try {
            if(serverSocket != null){
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.StartServer();

    }
}