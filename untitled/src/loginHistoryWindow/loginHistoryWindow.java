package loginHistoryWindow;

import loginWindow.loginWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class loginHistoryWindow extends JDialog{
    private JPanel historyTablePanel;
    private JButton menuButton;
    private JTable loginHistory;
    public loginHistoryWindow(JFrame parent){
        super(parent);
        createTable();
        setTitle("Login history of the app");
        setContentPane(historyTablePanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getRootPanel(){
        return historyTablePanel;
    }

    private void createTable() {
        loginHistory.setModel(new DefaultTableModel(null, new String[]{"Time", "Username", "Nickname"}));
    }
    public static void main(String[] args){
        loginHistoryWindow loginHistoryWindow = new loginHistoryWindow(null);
    }
}
