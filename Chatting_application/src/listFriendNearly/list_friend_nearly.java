package listFriendNearly;

import Chatting.chatting;
import addFriendWithGroup.showFriend;
import controllers.Friend.friendController;
import controllers.users.chatApplicationUserController;
import settingForAppWindow.settingForAppWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class list_friend_nearly extends JFrame  implements ActionListener {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton searchButton;
    private JButton backButton;
    private JPanel bodyPanel;
    private JButton buttonOK;
    private  String Email;

    private chatApplicationUserController userController = new chatApplicationUserController();
    private ArrayList<showAddFriendList> Friends = new ArrayList<showAddFriendList>();

    public list_friend_nearly(String Email)  {
        setContentPane(contentPane);
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.Email = Email;
        backButton.addActionListener(this);
        ResultSet rs = userController.showAllUser();

        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        try {
            String user_id = userController.searchUser(Email).getString(1);
            showAddFriendList friend = null;
            System.out.println(rs.getString(1));
            String checkEmail = rs.getString(3);
            if (!checkEmail.equals(this.Email)) {
                friend = new showAddFriendList(user_id,rs.getString(1));
                friend.setButton1(rs.getString(2));
                Friends.add(friend);
            }
            while (rs.next()) {
                System.out.println(rs.getString(1));
                checkEmail = rs.getString(3);
                if (!checkEmail.equals(this.Email)) {
                    friend = new showAddFriendList(user_id,rs.getString(1));
                    friend.setButton1(rs.getString(2));
                    Friends.add(friend);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        for (showAddFriendList friend :Friends){
            bodyPanel.add(friend.getMainPanel());
        }
        bodyPanel.repaint();
        bodyPanel.validate();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
        }
    }
    public static void main(String[] args) {
        //list_friend_nearly dialog = new list_friend_nearly();


    }
}
