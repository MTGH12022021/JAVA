package loginHistoryOfNicknameWindow;

import friendListWindow.friendListWindow;
import loginHistoryWindow.loginHistoryWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class loginHistoryOfNicknameWindow extends JFrame{
    private JButton menuButton;
    private JTable loginHistoryOfNickname;
    private JPanel loginHistoryOfNicknamePanel;
    public loginHistoryOfNicknameWindow(){
//        super(parent);
          createTable();
//        setTitle("Login history of individual");
//        setContentPane(loginHistoryOfNicknamePanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
        this.setContentPane(this.loginHistoryOfNicknamePanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Login history of individual");
        this.setVisible(true);
    }

    public JPanel getRootPanel(){
        return loginHistoryOfNicknamePanel;
    }

    private void createTable() {
        loginHistoryOfNickname.setModel(new DefaultTableModel(null, new String[]{"Time"}));
    }
    public static void main(String[] args){
        loginHistoryOfNicknameWindow loginHistoryOfNicknameWindow = new loginHistoryOfNicknameWindow();
        //JFrame frame = new JFrame("Login history of individual");

    }
}
