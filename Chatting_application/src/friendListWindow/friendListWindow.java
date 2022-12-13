package friendListWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class friendListWindow extends JFrame implements ActionListener {
    private JButton menuButton;
    private JButton friendListButton;
    private JButton deleteThisFriendButton;
    private JPanel fiendListPanel;
    private JButton backButton;

    public friendListWindow(){
        this.setContentPane(this.fiendListPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Friend list");
        this.setVisible(true);

        backButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            this.dispose();
        }
    }
    public static void main(String[] args) {
        //JFrame frame = new JFrame("Friend list");
        friendListWindow friendListWindow = new friendListWindow();

    }

}
