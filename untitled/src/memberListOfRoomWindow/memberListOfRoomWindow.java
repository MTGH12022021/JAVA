package memberListOfRoomWindow;

import addANewPersonWindow.addANewPersonWindow;
import registerWindow.registerWindow;

import javax.swing.*;
import java.awt.*;

public class memberListOfRoomWindow extends JFrame{
    private JButton menuButton;
    private JCheckBox adminCheckBox;
    private JButton deleteFromRoomButton;
    private JButton addANewMemberButton;
    private JPanel memberListOfRoom;
//    public memberListOfRoomWindow(JFrame parent){
//        super(parent);
//        setTitle("Member list of the room");
//        setContentPane(memberListOfRoom);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    memberListOfRoomWindow(){
        this.setContentPane(this.memberListOfRoom);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Member list of the room");
        this.setVisible(true);
    }
    public static void main(String[] args){
        //memberListOfRoomWindow memberListOfRoomWindow = new memberListOfRoomWindow(null);
        memberListOfRoomWindow memberListOfRoomWindow = new memberListOfRoomWindow();

    }

}
