package listFriendNearly;

import Chatting.chatting;
import settingForAppWindow.settingForAppWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class list_friend_nearly extends JFrame  implements ActionListener {
    private JPanel contentPane;
    private JButton button1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton addFriendButton;
    private JButton backButton;
    private JButton buttonOK;

    public list_friend_nearly()  {
        setContentPane(contentPane);
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
            new chatting();

        }
    }
    public static void main(String[] args) {
        list_friend_nearly dialog = new list_friend_nearly();


    }
}
