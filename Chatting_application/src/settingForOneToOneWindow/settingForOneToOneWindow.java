package settingForOneToOneWindow;

import addFriendWithGroup.addFriendWithGroup;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingForOneToOneWindow extends JFrame implements ActionListener {
    private JPanel settingOtoO;
    private JButton createAChatRoomButton;
    private JButton deleteThisConversationButton;
    private JButton backButton;
    private JLabel userAvatar;

    public settingForOneToOneWindow(){
        setContentPane(settingOtoO);
        setSize(450, 474);
        setTitle("Setting for chat");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        backButton.addActionListener(this);
        createAChatRoomButton.addActionListener(this);
        deleteThisConversationButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == backButton){
            dispose();
        }
        if(e.getSource() == createAChatRoomButton){
           addFriendWithGroup addFr = new addFriendWithGroup();

        }
        if(e.getSource() == deleteThisConversationButton){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete message?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,"Delete successfully");
            }
        }
    }
    public static void main(String[] args){
        settingForOneToOneWindow settingForOneToOneWindow = new settingForOneToOneWindow();
        //JFrame frame = new JFrame("Setting for chat");

    }
}
