package friendListWindow;

import addFriendWithGroup.showFriend;
import controllers.Friend.friendController;
import controllers.users.chatApplicationUserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class friendListWindow extends JFrame implements ActionListener {
    private JButton menuButton;
    private JPanel fiendListPanel;
    private JButton backButton;
    private JPanel mainPanel;
    private JScrollPane scrollpanel;
    private String Email;
    private ArrayList<friendListGUI> friendListGUIS = new ArrayList<friendListGUI>();
    private controllers.Friend.friendController friendController = new friendController();
    private chatApplicationUserController userController = new chatApplicationUserController();
    public friendListWindow(String email){
        this.setContentPane(this.fiendListPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Friend list");
        this.setVisible(true);
        this.Email = email;
        backButton.addActionListener(this);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        try {
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
        }catch (SQLException e) {
            e.printStackTrace();
        }

        for (friendListGUI friend :friendListGUIS){
            mainPanel.add(friend.getBodyPanel());
        }
        mainPanel.repaint();
        mainPanel.validate();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            this.dispose();
        }
    }

    public static void main(String[] args) {
        //JFrame frame = new JFrame("Friend list");
        //friendListWindow friendListWindow = new friendListWindow();

    }

}
