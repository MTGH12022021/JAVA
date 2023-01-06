package listFriendNearly;

import controllers.Friend.friendController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showAddFriendList {
    private JButton button1;
    private JButton addFriendButton;
    private JPanel mainPanel;

    private String user_id;
    private String friend_id;

    private controllers.Friend.friendController friendController = new friendController();
    public showAddFriendList (String userID,String friendID){
        this.user_id = userID;
        this.friend_id = friendID;
        addFriendButton.addActionListener(new ButtonEvent());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(String name) {
        this.button1.setText(name);
    }

    public JButton getAddFriendButton() {
        return addFriendButton;
    }

    public void setAddFriendButton(JButton addFriendButton) {
        this.addFriendButton = addFriendButton;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }

    private class ButtonEvent implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            friendController.addFriend(user_id,friend_id);
        }
    }
}
