package settingForChatRoomWindow;

import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;

public class settingForChatRoomWindow extends JDialog{
    private JButton memberOfTheRoomButton;
    private JButton changeNameButton;
    private JButton changeAvatarButton;
    private JButton deleteThisRoomButton;
    private JPanel settingForChatRoomPanel;
    public settingForChatRoomWindow(JFrame parent){
        super(parent);
        setTitle("Setting for this conversation");
        setContentPane(settingForChatRoomPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        settingForChatRoomWindow settingForChatRoomWindow = new settingForChatRoomWindow(null);
    }
}
