package Chatting;

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
    String Email;
    private chatApplicationUserController UserController = new chatApplicationUserController();
    private friendController friendController = new friendController();
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
        String idUser = UserController.searchUser(Email).getString(1);
        ResultSet friendList = friendController.searchFriend(idUser);

        listUserOnl.setLayout(new GridLayout(1,-1,5,5));
        listOnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listOnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        String user_id = userController.searchUser(Email).getString(1);
        ResultSet rs = friendController.searchFriend(user_id);
        String checkEmail= null;
        friendListGUI friend = null;
        do{
            ResultSet userAsFriend = userController.searchUserById(rs.getString(2));
            friend = new friendListGUI(userAsFriend.getString(1));
            friend.setHoTen(userAsFriend.getString(2));
            friendListGUIS.add(friend);
        }while (rs.next());
        

        for(int i = 0; i < 5; i++){
            listUserOnl.add(new panelWrapUser("","hihi").wrap_group());
        }

        listGroup.setLayout(new GridLayout(-1,1,5,5));
        scrollGroup.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollGroup.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for(int i = 0; i < 5; i++){
            listGroup.add(new panelWrapGroup("","hihi").wrap_group());
        }

        user.addActionListener(this);
        moreButton.addActionListener(this);
        try {
            StartClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class panelWrapUser{
        private  String idUser;
        private String name;

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

            JButton user = new JButton("icon");
            user.setSize(100, 50);
            JLabel userName = new JLabel(name);

            panel.add(user);
            panel.add(userName);
            panel.setSize(150, 50);
            panel.setBorder(blackline);
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
        private BufferedWriter bufferedWriter;
        private String username;
        private String type = "group";
        private String idReceive = "a";
        private String idUser = "";

        //todo Khởi tạo client socket
        public Client__(Socket socket){

            try{
                this.socket = socket;
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

                this.username = UserController.searchUser(Email).getString(2);

//                this.idUser = idUser;
//
//                this.type = type;
//                this.idReceive = idReceive;

            }catch(IOException e){
                closeEverything(this.socket, bufferedReader, bufferedWriter);
            }catch (SQLException e){
                closeEverything(this.socket, bufferedReader, bufferedWriter);
            }
        }

        public void send (String message){

        }
        //todo hàm gửi tin nhắn
        public void sendMessage(){
            try {
                bufferedWriter.write(idUser + "/" + username  +"/ " + type);
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

        //System.out.println("Enter your name: ");
        //String username = scanner.nextLine();
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        Client__ client__ = new Client__(socket);

//        System.out.println("Nhap id: ");
//        String idUser = scanner.nextLine();
//        System.out.println("Nhap name: ");
//        String username = scanner.nextLine();
//        System.out.println("Nhap loai nhan tin: ");
//        String type = scanner.nextLine();
//        System.out.println("Nhap nguoi nhan: ");
//        String idReceive = scanner.nextLine();
        //Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        //Client__ client__ = new Client__(socket,idUser, username, type, idReceive);

        client__.sendMessage();
        client__.listenforMessage();
    }

    public static void main(String[] args) {
        //chatting dialog = new chatting();
    }
}
