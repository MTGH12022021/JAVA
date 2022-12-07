package settingForChatRoomWindow;

import addANewPersonWindow.addANewPersonWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;

public class settingForChatRoomWindow extends JFrame{
    private JButton memberOfTheRoomButton;
    private JButton changeNameButton;
    private JButton changeAvatarButton;
    private JButton deleteThisRoomButton;
    private JPanel settingForChatRoomPanel;
//    public settingForChatRoomWindow(JFrame parent){
//        super(parent);
//        setTitle("Setting for this conversation");
//        setContentPane(settingForChatRoomPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    settingForChatRoomWindow(){
        this.setContentPane(this.settingForChatRoomPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Setting for chat room");
        this.setVisible(true);
    }
    public static void main(String[] args){
        settingForChatRoomWindow settingForChatRoomWindow = new settingForChatRoomWindow();
        //JFrame frame = new JFrame("Setting for chat room");

    }
}
