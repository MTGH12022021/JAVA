package moreUser;

import controllers.Friend.friendController;
import controllers.Group.groupController;
import controllers.users.chatApplicationUserController;
import friendListWindow.friendListWindow;
import listUser.updatePassword;
import listUser.updateUser;
import loginHistoryOfNicknameWindow.loginHistoryOfNicknameWindow;
import moreGroup.more_group;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class more_user extends JFrame  implements ActionListener {
    static JPanel panel;
    static JButton group,friends,history_login,delete,back,lockout,openAccount,UpdatePass,updateUser;
    private  String Email;
    private  String user_id;
    private chatApplicationUserController userController = new chatApplicationUserController();
    private friendController friendController = new friendController();

    private groupController groupController = new groupController();
    public more_user(String Email, String userID){
        add(CreateUI());
        setTitle("More");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        this.Email = Email;
        this.user_id = userID;
    }
    public JPanel CreateUI(){
        panel = new JPanel(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        group = new JButton("Group");
        friends = new JButton("Friends");
        history_login = new JButton("History login");
        lockout = new JButton("Lock account");
        UpdatePass = new JButton("Update Password");
        openAccount = new JButton("Open Account");
        updateUser = new JButton("Update");
        delete = new JButton("Delete");
        back = new JButton("Back");
        back.addActionListener(this);
        panel.add(friends);
        panel.add(group);
        panel.add(history_login);
        panel.add(lockout);
        panel.add(openAccount);
        panel.add(updateUser);
        panel.add(UpdatePass);
        panel.add(delete);
        panel.add(back);

        group.addActionListener(this);
        friends.addActionListener(this);
        history_login.addActionListener(this);
        lockout.addActionListener(this);
        openAccount.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);
        UpdatePass.addActionListener(this);
        updateUser.addActionListener(this);
        return panel;

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == group) {
            dispose();
        }
        if(e.getSource() == friends) {
            System.out.println(Email);
            new friendListWindow(Email);
        }
        if(e.getSource() == history_login) {
            loginHistoryOfNicknameWindow htr = new loginHistoryOfNicknameWindow();

        }
        if(e.getSource() == openAccount){
            try {
                int checkLock = userController.searchUserById(user_id).getInt(6);
                if(checkLock == 1){
                    JOptionPane.showMessageDialog(null, "Tài Khoản đang hoạt động bình thường");
                }
                else{
                    userController.openAccount(user_id);
                    JOptionPane.showMessageDialog(null, "Tài khoản đã được mở");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == lockout){
            try {
                int checkLock = userController.searchUserById(user_id).getInt(6);
                if(checkLock == 1){
                    userController.lockAccount(user_id);
                    JOptionPane.showMessageDialog(null, "Tài khoản đã được khóa");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tài khoản đang khóa");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == delete) {
            System.out.println(Email + user_id);
            friendController.deleteMessagesFriend(user_id);
            groupController.deleteMemberGroup(user_id);
            groupController.deleteMessageGroup(user_id);
            friendController.deleteFriend(user_id);
            userController.deleteUser(Email);
            dispose();
        }
        if(e.getSource() == back) {
            dispose();
        }
        if(e.getSource() == UpdatePass) {
            new updatePassword(user_id);
        }
        if(e.getSource() == updateUser){
            new updateUser(user_id);
        }
        if(e.getSource() == back) {
            dispose();
        }

    }
    public static void main(String[] agrs){
        //new more_user();
    }

}
