package friendListWindow;

import changenameWindow.changeNameWindow;
import settingForAppWindow.settingForAppWindow;

import javax.swing.*;
import java.awt.*;

public class friendListWindow extends JFrame {
    private JButton menuButton;
    private JButton friendListButton;
    private JButton deleteThisFriendButton;
    private JPanel fiendListPanel;

    //    public friendListWindow(JFrame parent){
//        super(parent);
//        setTitle("Friend list");
//        setContentPane(fiendListPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    friendListWindow(){
        this.setContentPane(this.fiendListPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Friend list");
        this.setVisible(true);
    }
    public static void main(String[] args) {
        //JFrame frame = new JFrame("Friend list");
        friendListWindow friendListWindow = new friendListWindow();

    }

}
