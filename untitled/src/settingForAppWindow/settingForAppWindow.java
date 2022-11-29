package settingForAppWindow;

import settingForChatRoomWindow.settingForChatRoomWindow;

import javax.swing.*;
import java.awt.*;

public class settingForAppWindow extends JDialog{
    private JButton friendListButton;
    private JButton friendInvitationsButton;
    private JButton changeNameButton;
    private JButton changeAvatarButton;
    private JButton logoutButton;
    private JPanel settingForAppPanel;
    public settingForAppWindow(JFrame parent){
        super(parent);
        setTitle("Setting for this account");
        setContentPane(settingForAppPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        settingForAppWindow settingForAppWindow = new settingForAppWindow(null);
    }
}
