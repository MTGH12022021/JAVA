package settingForOneToOneWindow;

import addANewPersonWindow.addANewPersonWindow;

import javax.swing.*;
import java.awt.*;

public class settingForOneToOneWindow extends JDialog{
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
    public static void main(String[] args){
        //settingForOneToOneWindow settingForOneToOneWindow = new settingForOneToOneWindow(null);
        JFrame frame = new JFrame("Change name");
        frame.setContentPane(new settingForOneToOneWindow().settingOtoO);
        frame.setSize(450, 474);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
