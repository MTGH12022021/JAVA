package Chatting;


import controllers.Message.messageGroup;
import controllers.Message.messageFriend;
import controllers.users.chatApplicationUserController;
import controllers.Friend.friendController;
import UserChatting.messageChat;

import settingForAppWindow.settingForAppWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import javax.swing.border.Border;
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
import java.sql.ResultSet;

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
    private JButton iconButton;
    private JButton fileButton;
    private JTextField sendText;
    private JPanel bodyPanel;
    private JPanel wrap_user;
    private JPanel listUserOnl;
    private JPanel Header;
    private JScrollPane listOnl;
    private JPanel leftHeader;
    private JPanel accountUser;
    private JPanel listGroup;
    private JScrollPane scrollGroup;
    private JButton buttonOK;
    private GridBagConstraints gbc = new GridBagConstraints();
    private int count = 0;
    private String Email;
    private chatApplicationUserController UserController = new chatApplicationUserController();
    private friendController friendController = new friendController();
    private messageGroup messGroup = new messageGroup();
    private messageFriend messFriend = new messageFriend();
    private final Client__ client__;

    public chatting(String Email) throws SQLException {
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,600);
        setVisible(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.getMinimumSize();

        Chatting.setPreferredSize(new Dimension(640, 480));
        scrollChat.setMinimumSize(new Dimension(100, 0));

        listUserOnl.setLayout(new GridLayout(1,-1,5,5));
        listOnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listOnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.Email = Email;
        ResultSet User;
        try {
            User = UserController.searchUser(Email);
            ResultSet friendList = friendController.searchFriend(User.getString(1));
            if(friendList != null){
                 do {
                ResultSet userAsFriend = UserController.searchUserById(friendList.getString(2));
                listUserOnl.add(new panelWrapUser(friendList.getString(2),userAsFriend.getString(2)).wrap_group());
            }while (friendList.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        listGroup.setLayout(new GridLayout(-1,1,5,5));
        scrollGroup.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollGroup.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        try {
            ResultSet groupList = messGroup.listGroup(User.getString(1));
            if(groupList != null) {
                do {
                    listGroup.add(new panelWrapGroup(groupList.getString(2), groupList.getString(3)).wrap_group());
                } while (groupList.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        user.setText(User.getString(2));
        user.addActionListener(this);
        moreButton.addActionListener(this);
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
            client__ = new Client__(socket, User.getString(1), User.getString(2));


            client__.sendMessage();
            client__.listenforMessage();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private class panelWrapUser{
        private final String idUser;
        private final String name;

        public panelWrapUser(String idUser, String name){
            this.idUser = idUser;
            this.name =name;
        }

        public String getName(){return name;}
        public String getIdUser(){return idUser;}

        public JPanel wrap_group() {
            Border blackline = BorderFactory.createLineBorder(Color.black);
            JPanel panel = new JPanel(new GridLayout(1, 2));

            JButton user = new JButton("icon");
            user.setSize(100, 50);
            JLabel userName = new JLabel(name);

            panel.add(user);
            panel.add(userName);
            panel.setSize(150, 50);
            panel.setBorder(blackline);
            user.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bodyPanel.removeAll();
                    bodyPanel.validate();
                    bodyPanel.repaint();
                    peopleButton.setText(name);
                    client__.setType("user");
                    client__.setIdReceive(idUser);

                    //load lai tin nhan cu
                    ResultSet oldMessage = messFriend.loadMessage(client__.idUser, idUser);


                    if(oldMessage != null) {
                        try {
                            do {
                                String msg = oldMessage.getString("message_content");
                                if (oldMessage.getInt("validate") == 1) {
                                    int specialCharacter = msg.indexOf(":");
                                    messageChat textRight = new messageChat();
                                    messageChat Left = new messageChat();
                                    Left.getDisplayMessage().setText(msg.substring(specialCharacter + 2, msg.length()));
                                    Left.setTime(oldMessage.getString("times"));
                                    Left.setHoTen(msg.substring(0, specialCharacter));
                                    gbc.gridx = 0;
                                    gbc.gridy = count;
                                    gbc.weightx = 0.1;
                                    gbc.anchor = GridBagConstraints.WEST;
                                    bodyPanel.add(Left.getChatleft(), gbc);
                                    bodyPanel.revalidate();
                                    bodyPanel.repaint();
                                    count++;
                                }
                                else {
                                    int specialCharacter = msg.indexOf(":");
                                    messageChat textRight = new messageChat();
                                    messageChat Right = new messageChat();
                                    Right.getDisplayMessage().setText(msg.substring(specialCharacter + 2, msg.length()));
                                    Right.setTime(oldMessage.getString("times"));
                                    Right.setHoTen(msg.substring(0, specialCharacter));
                                    gbc.gridx = 0;
                                    gbc.gridy = count;
                                    gbc.weightx = 0.1;
                                    gbc.anchor = GridBagConstraints.EAST;
                                    bodyPanel.add(Right.getChatleft(), gbc);
                                    bodyPanel.revalidate();
                                    bodyPanel.repaint();
                                    count++;
                                }

                            } while (oldMessage.next());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    // chuyen thong tin di
                    try {
                        client__.bufferedWriter.write("**"+ idUser + "/" + client__.getUsername()  +"/ " + client__.getType());
                        client__.bufferedWriter.newLine();
                        client__.bufferedWriter.flush();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            return panel;
        }
    }

    private class panelWrapGroup{
        private String idGroup;
        private String name;

        public panelWrapGroup(String idGroup, String name){
            this.idGroup = idGroup;
            this.name = name;
        }

        public String getName(){return name;}
        public String getIdGroup(){return idGroup;}

        public JPanel wrap_group() {
            Border blackline = BorderFactory.createLineBorder(Color.black);
            JPanel panel = new JPanel(new GridLayout(1, 2));

            JButton group = new JButton("icon");
            group.setSize(100, 50);
            JLabel userName = new JLabel(name);

            panel.add(group);
            panel.add(userName);
            panel.setSize(150, 50);
            panel.setBorder(blackline);

           group.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    bodyPanel.removeAll();
                    bodyPanel.validate();
                    bodyPanel.repaint();
                    peopleButton.setText(name);
                    client__.setType("group");
                    client__.setIdReceive(idGroup);
                    //load lai tin nhan cu
                    ResultSet oldMessage = messGroup.loadMessage(client__.idUser, idGroup);


                    if(oldMessage != null) {
                        try {
                            do {
                                String msg = oldMessage.getString("message_content");
                                if (oldMessage.getInt("validate") == 0) {
                                    int specialCharacter = msg.indexOf(":");
                                    messageChat textRight = new messageChat();
                                    messageChat Left = new messageChat();
                                    Left.getDisplayMessage().setText(msg.substring(specialCharacter + 2, msg.length()));
                                    Left.setTime(oldMessage.getString("times"));
                                    Left.setHoTen(msg.substring(0, specialCharacter));
                                    gbc.gridx = 0;
                                    gbc.gridy = count;
                                    gbc.weightx = 0.1;
                                    gbc.anchor = GridBagConstraints.WEST;
                                    bodyPanel.add(Left.getChatleft(), gbc);
                                    bodyPanel.revalidate();
                                    bodyPanel.repaint();
                                    count++;
                                }
                                else {
                                    int specialCharacter = msg.indexOf(":");
                                    messageChat textRight = new messageChat();
                                    messageChat Right = new messageChat();
                                    Right.getDisplayMessage().setText(msg.substring(specialCharacter + 2, msg.length()));
                                    Right.setTime(oldMessage.getString("times"));
                                    Right.setHoTen(msg.substring(0, specialCharacter));
                                    gbc.gridx = 0;
                                    gbc.gridy = count;
                                    gbc.weightx = 0.1;
                                    gbc.anchor = GridBagConstraints.EAST;
                                    bodyPanel.add(Right.getChatleft(), gbc);
                                    bodyPanel.revalidate();
                                    bodyPanel.repaint();
                                    count++;
                                }

                            } while (oldMessage.next());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    // chuyen thong tin di
                    try {
                        client__.bufferedWriter.write("**"+ idGroup + "/" + client__.getUsername()  +"/ " + client__.getType());
                        client__.bufferedWriter.newLine();
                        client__.bufferedWriter.flush();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
               }
           });
            return panel;
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
        public BufferedWriter bufferedWriter;
        private String username ="";
        private String type = "";
        private String idReceive = "";
        private String idUser = "";

        //todo Khởi tạo client socket
        public Client__(Socket socket, String idUser, String username){

            try{
                this.socket = socket;
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

                this.username = username;
                this.idUser = idUser;

            }catch(IOException e){
                closeEverything(this.socket, bufferedReader, bufferedWriter);
            }
        }

        public void send (String message){

        }
        public String getType(){return type;}
        public String getUsername(){return username;}
        public void setType(String type){this.type = type;}
        public void setIdReceive(String idReceive){this.idReceive = idReceive;}

        //todo hàm gửi tin nhắn
        public void sendMessage(){
            try {
                bufferedWriter.write("**"+idUser + "/" + username  +"/ " + type);
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
                            String message  = type + "/"+ idReceive +"/ " + username + ": " + sendText.getText();
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
                                //phan tich de tranh nhan cung luc nhieu tin nhan tu nguoi gui
                                System.out.println(msgFromCharGroup);
                                int indexIdSenderAndMess = msgFromCharGroup.indexOf("/");
                                String idSender = msgFromCharGroup.substring(0, indexIdSenderAndMess);

                                if (idSender.equals(idReceive)) {
                                    String mess = msgFromCharGroup.substring(indexIdSenderAndMess+1, msgFromCharGroup.length());
                                    System.out.println(mess);
                                    int specialCharacter = mess.indexOf(":");
                                    messageChat textRight = new messageChat();
                                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                                    Date now = new Date();
                                    String date = formatter.format(now);
                                    messageChat Left = new messageChat();
                                    Left.getDisplayMessage().setText(mess.substring(specialCharacter + 2, mess.length()));
                                    Left.setTime(date);
                                    Left.setHoTen(mess.substring(0, specialCharacter));
                                    gbc.gridx = 0;
                                    gbc.gridy = count;
                                    gbc.weightx = 0.1;
                                    gbc.anchor = GridBagConstraints.WEST;
                                    bodyPanel.add(Left.getChatleft(), gbc);
                                    bodyPanel.revalidate();
                                    bodyPanel.repaint();
                                    count++;
                                }
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


    public static void main(String[] args) {
        //chatting dialog = new chatting();
    }
}
