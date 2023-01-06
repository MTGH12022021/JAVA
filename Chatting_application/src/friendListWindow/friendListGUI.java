package friendListWindow;

import controllers.Friend.friendController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class friendListGUI {
    private JButton friendListButton;
    private JButton deleteThisFriendButton;
    private JLabel HoTen;
    private JPanel bodyPanel;
    private  String user_id;

    private controllers.Friend.friendController friendController = new friendController();
    public friendListGUI (String user_id){
        this.user_id = user_id;

        HoTen.setPreferredSize(new Dimension(100,50));
        deleteThisFriendButton.addActionListener(new ButtonEvent());
    }
    public void setHoTen(JLabel hoTen) {
        HoTen = hoTen;
    }

    public JPanel getBodyPanel() {
        return bodyPanel;
    }

    public void setBodyPanel(JPanel bodyPanel) {
        this.bodyPanel = bodyPanel;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public JButton getFriendListButton() {
        return friendListButton;
    }

    public void setFriendListButton(JButton friendListButton) {
        this.friendListButton = friendListButton;
    }

    public JButton getDeleteThisFriendButton() {
        return deleteThisFriendButton;
    }

    public void setDeleteThisFriendButton(JButton deleteThisFriendButton) {
        this.deleteThisFriendButton = deleteThisFriendButton;
    }

    public JLabel getHoTen() {
        return HoTen;
    }

    public void setHoTen(String name) {
        HoTen.setText(name);
    }
    private class ButtonEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            friendController.deleteFriend(user_id);
        }
    }
}
