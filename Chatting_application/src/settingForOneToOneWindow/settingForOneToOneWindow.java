package settingForOneToOneWindow;

import addFriendWithGroup.addFriendWithGroup;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.Message.messageFriend;
import controllers.Message.messageGroup;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.users.chatApplicationUserController;

public class settingForOneToOneWindow extends JFrame implements ActionListener {
    private JPanel settingOtoO;
    private JButton createAChatRoomButton;
    private JButton deleteThisConversationButton;
    private JButton backButton;
    private JLabel userAvatar;
    private String Email;
    private String idReceive;
    private String type;
    private chatApplicationUserController UserController = new chatApplicationUserController();

    public settingForOneToOneWindow(String Email, String idReceive, String type){
        setContentPane(settingOtoO);
        setSize(450, 474);
        setTitle("Setting for chat");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.Email = Email;
        this.idReceive = idReceive;
        this.type = type;
        backButton.addActionListener(this);
        createAChatRoomButton.addActionListener(this);
        deleteThisConversationButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
        }
        if(e.getSource() == createAChatRoomButton){
           addFriendWithGroup addFr = new addFriendWithGroup(Email);
        }
        if(e.getSource() == deleteThisConversationButton){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete message?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                if(idReceive.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select the person and then proceed to delete the message");
                }
                ResultSet User;
                User = UserController.searchUser(Email);
                boolean check = false;
                 try {
                     System.out.println(User.getString("user_id") + "//"+ this.idReceive);
                     if (type.equals("group")) {
                         check = new messageGroup().deleteMessage(User.getString("user_id"), this.idReceive);
                     } else {
                         check = new messageFriend().deleteMessage(User.getString("user_id"), this.idReceive);
                     }

                 }catch(SQLException ex) {
                     throw new RuntimeException(ex);
                 }
                 if(check == true) {
                     JOptionPane.showMessageDialog(null, "Delete successfully");
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Delete failure");
                 }
            }
        }
    }

    public static void main(String[] args){
        //settingForOneToOneWindow settingForOneToOneWindow = new settingForOneToOneWindow();
        //JFrame frame = new JFrame("Setting for chat");

    }
}
