package Chatting;

import settingForAppWindow.settingForAppWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chatting extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JButton peopleButton;
    private JButton moreButton;
    private JButton send;
    private JButton nameButton;
    private JPanel Chatting;
    private JScrollPane scrollChat;
    private JButton revokeButton;
    private JButton user;
    private JLabel staticOnl;
    private JButton iconButton;
    private JButton fileButton;
    private JTextField textField2;
    private JButton buttonOK;

    public chatting() {
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,600);
        setVisible(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.getMinimumSize();

        Chatting.setPreferredSize(new Dimension(640, 480));
        scrollChat.setMinimumSize(new Dimension(100, 0));

        user.addActionListener(this);
        moreButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == user){
            settingForAppWindow set_user = new settingForAppWindow();
        }
        if(e.getSource() == moreButton){
            settingForOneToOneWindow more_chat = new settingForOneToOneWindow();
        }
    }
    public static void main(String[] args) {
        chatting dialog = new chatting();


    }
}
