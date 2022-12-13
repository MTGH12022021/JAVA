package memberListOfRoomWindow;

import settingForChatRoomWindow.settingForChatRoomWindow;
import addANewPersonWindow.addANewPersonWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class memberListOfRoomWindow extends JFrame{
    private JButton backButton;
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
public memberListOfRoomWindow(){
        this.setContentPane(this.memberListOfRoom);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Member list of the room");
        this.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new settingForChatRoomWindow();
            }
        });
        addANewMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new addANewPersonWindow();
            }
        });
    }
    public static void main(String[] args){
        //memberListOfRoomWindow memberListOfRoomWindow = new memberListOfRoomWindow(null);
        memberListOfRoomWindow memberListOfRoomWindow = new memberListOfRoomWindow();

    }

}
