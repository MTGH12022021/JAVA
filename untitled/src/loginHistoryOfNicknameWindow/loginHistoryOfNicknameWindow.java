package loginHistoryOfNicknameWindow;

import loginHistoryWindow.loginHistoryWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class loginHistoryOfNicknameWindow extends JDialog{
    private JButton menuButton;
    private JTable loginHistoryOfNickname;
    private JPanel loginHistoryOfNicknamePanel;
    public loginHistoryOfNicknameWindow(JFrame parent){
        super(parent);
        createTable();
        setTitle("Login");
        setContentPane(loginHistoryOfNicknamePanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getRootPanel(){
        return loginHistoryOfNicknamePanel;
    }

    private void createTable() {
        loginHistoryOfNickname.setModel(new DefaultTableModel(null, new String[]{"Time"}));
    }
    public static void main(String[] args){
        loginHistoryOfNicknameWindow loginHistoryOfNicknameWindow = new loginHistoryOfNicknameWindow(null);
    }
}
