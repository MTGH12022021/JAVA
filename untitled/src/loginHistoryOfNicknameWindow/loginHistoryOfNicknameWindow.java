package loginHistoryOfNicknameWindow;

import friendListWindow.friendListWindow;
import loginHistoryWindow.loginHistoryWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class loginHistoryOfNicknameWindow extends JDialog{
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
    }

    public JPanel getRootPanel(){
        return loginHistoryOfNicknamePanel;
    }

    private void createTable() {
        loginHistoryOfNickname.setModel(new DefaultTableModel(null, new String[]{"Time"}));
    }
    public static void main(String[] args){
        //loginHistoryOfNicknameWindow loginHistoryOfNicknameWindow = new loginHistoryOfNicknameWindow(null);
        JFrame frame = new JFrame("Change name");
        frame.setContentPane(new loginHistoryOfNicknameWindow().loginHistoryOfNicknamePanel);
        frame.setSize(450, 474);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
