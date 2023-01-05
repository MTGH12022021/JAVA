package controllers.socket;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class UI_Client extends JFrame {
    private JPanel display_panel = new JPanel();
    private JPanel main_panel = new JPanel();
    private JTextArea display_message = new JTextArea();
    private JTextField messField = new JTextField();
    private JPanel message_panel = new JPanel();
    private JScrollPane mScrollPane = new JScrollPane(display_message);
    private JButton send_message = new JButton("Send");

    public UI_Client() {
        this.setSize(720, 360);

        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        display_message.setLineWrap(true);
        display_message.setWrapStyleWord(true);
        display_message.setEditable(false);
        messField.setColumns(20);
        messField.setPreferredSize(
                new Dimension(messField.getPreferredSize().width, send_message.getPreferredSize().height));

        message_panel.add(messField);
        message_panel.add(send_message);
        main_panel.add(mScrollPane);
        mScrollPane.setPreferredSize(new Dimension(720, 360));
        main_panel.add(message_panel);

        this.add(main_panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        try {
            StartClient();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public JTextField getMessField() {
        return messField;
    }

    public JTextArea getDisplay_message() {
        return display_message;
    }

    public class Client__ {
        private Socket socket;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private String username;

        public Client__(Socket socket,String username){
            try{
                this.socket = socket;
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                this.username = username;
            }catch(IOException e){
                closeEverything(this.socket, bufferedReader, bufferedWriter);
            }
        }

        public void send (String message){

        }

        public void sendMessage(){
            try {
                bufferedWriter.write(username);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e1) {

                e1.printStackTrace();
            }

            messField.addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent e) {


                }

                @Override
                public void keyPressed(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        try{
                            bufferedWriter.write(username + ": "+ messField.getText());
                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                            display_message.append("\n"+messField.getText());
                        }catch(IOException E){
                            closeEverything(socket, bufferedReader, bufferedWriter);
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {


                }

            });
        }

        public void listenforMessage(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    String msgFromCharGroup;
                    while(socket.isConnected()){
                        try{
                            msgFromCharGroup = bufferedReader.readLine();
                            display_message.append("\n"+msgFromCharGroup);
                        }catch(IOException e){
                            closeEverything(socket, bufferedReader, bufferedWriter);
                        }
                    }
                }
            }).start();
        }
        public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {

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

    public void StartClient() throws UnknownHostException, IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String username = scanner.nextLine();
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        Client__ client__ = new Client__(socket, username);
        client__.sendMessage();
        client__.listenforMessage();
    }
    public static void main(String[] args) {
        new UI_Client();
    }
}
