package settingForAppWindow;

import changenameWindow.changeNameWindow;
import friendListWindow.friendListWindow;

import listFriendNearly.list_friend_nearly;
import loginWindow.loginWindow;
import uploadImageWindow.uploadImageWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingForAppWindow extends JFrame implements ActionListener {
    private JButton friendListButton;
    private JButton friendInvitationsButton;
    private JButton changeNameButton;
    private JButton changeAvatarButton;
    private JButton logoutButton;
    private JPanel settingForAppPanel;
    private String Email;
    public settingForAppWindow(String Email){
        this.setContentPane(this.settingForAppPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Setting for the app");
        this.setVisible(true);
        this.Email = Email;
        logoutButton.addActionListener(this);
        friendListButton.addActionListener(this);
        friendInvitationsButton.addActionListener(this);
        changeNameButton.addActionListener(this);
        changeAvatarButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logoutButton){
            this.dispose();
            loginWindow home = new loginWindow();
        }
        if(e.getSource() == friendListButton){

            friendListWindow fr = new friendListWindow();
        }
        if(e.getSource() == friendInvitationsButton){

            list_friend_nearly fr_nearly = new list_friend_nearly(Email);

        }
        if(e.getSource() == changeNameButton){

            changeNameWindow change_name = new changeNameWindow();
        }
        if(e.getSource() == changeAvatarButton){

            uploadImageWindow change_avata = new uploadImageWindow();
        }
    }
    public static void main(String[] args) {
        //settingForAppWindow settingForAppWindow = new settingForAppWindow();
        //JFrame frame = new JFrame("Setting for account");

    }

}
