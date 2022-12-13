package moreUser;

import loginHistoryOfNicknameWindow.loginHistoryOfNicknameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class more_user extends JFrame  implements ActionListener {
    static JPanel panel;
    static JButton group,friends,history_login,delete,back;
    public more_user(){
        add(CreateUI());
        setTitle("More");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JPanel CreateUI(){
        panel = new JPanel(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        group = new JButton("Group");
        group = new JButton("Friends");
        history_login = new JButton("History login");
        delete = new JButton("Delete");
        back = new JButton("Back");
        back.addActionListener(this);
        panel.add(group);
        panel.add(friends);
        panel.add(history_login);
        panel.add(delete);
        panel.add(back);

        group.addActionListener(this);
        group.addActionListener(this);
        history_login.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);

        return panel;

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == group) {
            this.dispose();
        }
        if(e.getSource() == friends) {

        }
        if(e.getSource() == history_login) {
            loginHistoryOfNicknameWindow htr = new loginHistoryOfNicknameWindow();

        }
        if(e.getSource() == back) {
            this.dispose();
        }
        if(e.getSource() == back) {
            this.dispose();
        }
        if(e.getSource() == back) {
            this.dispose();
        }

    }
    public static void main(String[] agrs){
        new more_user();
    }

}
