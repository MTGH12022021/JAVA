package settingForAppWindow;

import addANewPersonWindow.addANewPersonWindow;
import settingForChatRoomWindow.settingForChatRoomWindow;
import friendListWindow.friendListWindow;
import uploadImageWindow.uploadImageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingForAppWindow extends JFrame {
    private JButton friendListButton;
    private JButton friendInvitationsButton;
    private JButton changeNameButton;
    private JButton changeAvatarButton;
    private JButton logoutButton;
    private JPanel settingForAppPanel;

    //    public settingForAppWindow(JFrame parent){
//        super(parent);
//        setTitle("Setting for this account");
//        setContentPane(settingForAppPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    settingForAppWindow(){
        this.setContentPane(this.settingForAppPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Setting for the app");
        this.setVisible(true);
        friendListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new friendListWindow();
            }
        });
        changeAvatarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new uploadImageWindow();
            }
        });
    }
    public static void main(String[] args) {
        settingForAppWindow settingForAppWindow = new settingForAppWindow();
        //JFrame frame = new JFrame("Setting for account");

    }

}
