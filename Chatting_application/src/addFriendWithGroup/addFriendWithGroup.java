package addFriendWithGroup;

import controllers.Friend.friendController;
import controllers.users.chatApplicationUserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class addFriendWithGroup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton backButton;
    private JPanel bodyPanel;
    private JButton buttonOK;
    private chatApplicationUserController userController = new chatApplicationUserController();
    private String Email;
    private friendController friendController = new friendController();
    private ArrayList<showFriend> Friends = new ArrayList<showFriend>();
    public addFriendWithGroup(String Email) {
        setContentPane(contentPane);
        setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.Email = Email;
        ResultSet rs = userController.showAllUser();
        backButton.addActionListener(this);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        try {
            showFriend friend = null;
            System.out.println(rs.getString(1));
            String checkEmail = rs.getString(3);
            if (!checkEmail.equals(this.Email)) {
                friend = new showFriend(rs.getString(1));
                friend.setButton1(rs.getString(2));
                Friends.add(friend);
            }
            while (rs.next()) {
                System.out.println(rs.getString(1));
                checkEmail = rs.getString(3);
                if (!checkEmail.equals(this.Email)) {
                    friend = new showFriend(rs.getString(1));
                    friend.setButton1(rs.getString(2));
                    Friends.add(friend);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        for (showFriend friend :Friends){
            bodyPanel.add(friend.getPanel1());
        }
        bodyPanel.repaint();
        bodyPanel.validate();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            for (showFriend friend :Friends){
                if(friend.getCheckBox1().isSelected()){
                    String user_id = null;
                    try {
                        user_id = userController.searchUser(Email).getString(1);
                        friendController.addFriend(user_id,friend.getUser_id() );
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
            dispose();
        }
    }
    public static void main(String[] args) {
        //addFriendWithGroup dialog = new addFriendWithGroup();
    }
}
