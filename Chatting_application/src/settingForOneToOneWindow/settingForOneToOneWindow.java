package settingForOneToOneWindow;

import addANewPersonWindow.addANewPersonWindow;

import javax.swing.*;
import java.awt.*;

public class settingForOneToOneWindow extends JFrame{
    private JPanel settingOtoO;
    private JButton createAChatRoomButton;
    private JButton deleteThisConversationButton;
    private JLabel userAvatar;

//    public settingForOneToOneWindow(JFrame parent){
//        super(parent);
//        setTitle("Setting for this conversation");
//        setContentPane(settingOtoO);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    settingForOneToOneWindow(){
        this.setContentPane(this.settingOtoO);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Setting for chat");
        this.setVisible(true);
    }
    public static void main(String[] args){
        settingForOneToOneWindow settingForOneToOneWindow = new settingForOneToOneWindow();
        //JFrame frame = new JFrame("Setting for chat");

    }
}
