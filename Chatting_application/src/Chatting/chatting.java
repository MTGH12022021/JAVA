package Chatting;

import settingForAppWindow.settingForAppWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;

public class chatting extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JButton peopleButton;
    private JButton moreButton;
    private JButton send;
    private JButton nameButton;
    private JPanel Chatting;
    private JScrollPane scrollChat;
    private JButton revokeButton;
    private JButton user;
    private JLabel staticOnl;
    private JButton iconButton;
    private JButton fileButton;
    private JTextField sendText;
    private JButton buttonOK;

    public chatting() {
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,600);
        setVisible(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.getMinimumSize();

        Chatting.setPreferredSize(new Dimension(640, 480));
        scrollChat.setMinimumSize(new Dimension(100, 0));

        user.addActionListener(this);
        moreButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == user){
            settingForAppWindow set_user = new settingForAppWindow();
        }
        if(e.getSource() == moreButton){
            settingForOneToOneWindow more_chat = new settingForOneToOneWindow();
        }
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
                            bufferedWriter.write(username + ": "+ sendText.getText());
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
    public static void main(String[] args) {
        chatting dialog = new chatting();
    }
}
