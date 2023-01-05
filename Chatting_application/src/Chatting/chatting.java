package Chatting;

import UserChatting.messageChat;
import settingForAppWindow.settingForAppWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
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
        try {
            StartClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        private String type = "group";
        private String IdReceive = "a";

        //todo Khởi tạo client socket
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
        //todo hàm gửi tin nhắn
        public void sendMessage(){
            try {
                bufferedWriter.write(username);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //todo gửi tin nhắn đến cho serer xử lý 
            sendText.addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e) {
                }

                //todo khi mà khung sendText nhận phím enter thì send tin nhắn đc gửi đi có thể coi nó là một vòng lặp while
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        messageChat messageRight= new messageChat();
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        Date now = new Date();
                        String date = formatter.format(now);
                        try{
                            //sử dụng mã để phân biệt đang nhăn tin với user hay group truoc dau / la loai tin nhan (gui cho user hay group)
                            // sau / la id nguoi nhan (hoac la ten nguoi nhan)
                            String message  = type + "/"+ IdReceive +"/ " + username + ": " + sendText.getText();
                            bufferedWriter.write(message);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            System.out.println("send message successful");
                            messageRight.getDisplayMessage().setText(sendText.getText());
                            messageRight.setTime(date);
                            messageRight.setHoTen(username);
                            gbc.gridx = 0;
                            gbc.gridy = count;
                            gbc.weightx = 0.1;
                            gbc.anchor = GridBagConstraints.EAST;
                            bodyPanel.add(messageRight.getChatleft(), gbc);
                            bodyPanel.revalidate();
                            bodyPanel.repaint();
                            count++;
                            sendText.setText("");
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
                                messageChat textRight= new messageChat();
                                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                                Date now = new Date();
                                String date = formatter.format(now);
                                messageChat Left = new messageChat();
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
        System.out.println("Enter your name: ");
        String username = scanner.nextLine();
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        Client__ client__ = new Client__(socket, username);
        client__.sendMessage();
        client__.listenforMessage();
    }

    public static void main(String[] args) {
        chatting dialog = new chatting();
    }
}
