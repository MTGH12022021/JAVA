package Chatting;

import UserChatting.chatLeft;
import controllers.users.chatApplicationUserController;
import settingForAppWindow.settingForAppWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;
import java.net.UnknownHostException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class chatting extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JButton peopleButton;
    private JButton moreButton;
    private JButton send;
    private JPanel Chatting;
    private JScrollPane scrollChat;
    private JButton user;
    private JLabel staticOnl;
    private JButton iconButton;
    private JButton fileButton;
    private JTextField sendText;
    private JPanel bodyPanel;
    private JButton buttonOK;
    private GridBagConstraints gbc = new GridBagConstraints();
    private int count = 0;
    String Email;
    private chatApplicationUserController UserController = new chatApplicationUserController();
    public chatting(String Email) {
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,600);
        setVisible(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.getMinimumSize();

        Chatting.setPreferredSize(new Dimension(640, 480));
        scrollChat.setMinimumSize(new Dimension(100, 0));
        this.Email = Email;
        user.addActionListener(this);
        moreButton.addActionListener(this);
        try {
            StartClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == user){
            settingForAppWindow set_user = new settingForAppWindow(Email);
        }
        if(e.getSource() == moreButton){
            settingForOneToOneWindow more_chat = new settingForOneToOneWindow(Email);
        }
    }
    public class Client__ {
        private Socket socket;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private String username;

        public Client__(Socket socket){
            try{
                this.socket = socket;
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                this.username = UserController.searchUser(Email).getString(2);
            }catch(IOException e){
                closeEverything(this.socket, bufferedReader, bufferedWriter);
            }catch (SQLException e){
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

            sendText.addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent e) {


                }

                @Override
                public void keyPressed(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        chatLeft textRight= new chatLeft();
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        Date now = new Date();
                        String date = formatter.format(now);
                        try{
                            bufferedWriter.write(username + ": "+ sendText.getText());
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            System.out.println("hello");
                            textRight.getDisplayMessage().setText(sendText.getText());
                            textRight.setTime(date);
                            textRight.setHoTen(username);
                            gbc.gridx = 0;
                            gbc.gridy = count;
                            gbc.weightx = 0.1;
                            gbc.anchor = GridBagConstraints.EAST;
                            bodyPanel.add(textRight.getChatleft(), gbc);
                            bodyPanel.revalidate();
                            bodyPanel.repaint();
                            count++;

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
                            if (msgFromCharGroup != null) {
                                int specialCharacter = msgFromCharGroup.indexOf(":");
                                chatLeft textRight= new chatLeft();
                                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                                Date now = new Date();
                                String date = formatter.format(now);
                                chatLeft Left = new chatLeft();
                                Left.getDisplayMessage().setText(msgFromCharGroup.substring(specialCharacter+2, msgFromCharGroup.length()));
                                Left.setTime(date);
                                Left.setHoTen(msgFromCharGroup.substring(0,specialCharacter));
                                gbc.gridx = 0;
                                gbc.gridy = count;
                                gbc.weightx = 0.1;
                                gbc.anchor = GridBagConstraints.WEST;

                                bodyPanel.add(Left.getChatleft(), gbc);
                                bodyPanel.revalidate();
                                bodyPanel.repaint();
                                count++;
                            }
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
    public void StartClient() throws IOException{
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your name: ");
        //String username = scanner.nextLine();
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        Client__ client__ = new Client__(socket);
        client__.sendMessage();
        client__.listenforMessage();
    }
    /*
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

            sendText.addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent e) {


                }

                @Override
                public void keyPressed(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        chatLeft textLeft = new chatLeft();
                        try{
                            bufferedWriter.write(username + ": "+ sendText.getText());
                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                            display_message.append("\n"+sendText.getText());
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
                            display_message.append("\n"+ msgFromCharGroup);
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
    */
    public static void main(String[] args) {
        //chatting dialog = new chatting();
    }
}
