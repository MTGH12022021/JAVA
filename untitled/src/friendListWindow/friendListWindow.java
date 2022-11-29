package friendListWindow;

import settingForAppWindow.settingForAppWindow;

import javax.swing.*;
import java.awt.*;

public class friendListWindow extends JDialog{
    private JButton menuButton;
    private JButton friendListButton;
    private JButton deleteThisFriendButton;
    private JPanel fiendListPanel;
    public friendListWindow(JFrame parent){
        super(parent);
        setTitle("Friend list");
        setContentPane(fiendListPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        friendListWindow friendListWindow = new friendListWindow(null);
    }
}
