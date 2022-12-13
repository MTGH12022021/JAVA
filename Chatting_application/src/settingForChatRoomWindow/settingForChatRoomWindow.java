package settingForChatRoomWindow;

import changenameWindow.changeNameWindow;
import memberListOfRoomWindow.memberListOfRoomWindow;
import uploadImageWindow.uploadImageWindow;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingForChatRoomWindow extends JFrame implements ActionListener{
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
    public settingForChatRoomWindow(){
        this.setContentPane(this.settingForChatRoomPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Setting for chat room");
        this.setVisible(true);
        memberOfTheRoomButton.addActionListener(this);
        changeAvatarButton.addActionListener(this);
        changeAvatarButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == memberOfTheRoomButton){
            dispose();
            memberListOfRoomWindow nw = new memberListOfRoomWindow();
        }
        if(e.getSource() == changeAvatarButton){
            changeNameWindow nw = new changeNameWindow();
        }
        if(e.getSource() == changeAvatarButton){
            uploadImageWindow nw1 = new uploadImageWindow();
        }
    }
    public static void main(String[] args){
        settingForChatRoomWindow settingForChatRoomWindow = new settingForChatRoomWindow();
        //JFrame frame = new JFrame("Setting for chat room");

    }
}
