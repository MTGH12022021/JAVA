package loginHistoryWindow;

import friendListWindow.friendListWindow;
import loginWindow.loginWindow;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class loginHistoryWindow extends JDialog {
    private JPanel historyTablePanel;
    private JButton menuButton;
    private JTable loginHistory;

    public loginHistoryWindow() {
//        super(parent);
        createTable();
//        setTitle("Login history of the app");
//        setContentPane(historyTablePanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
    }

    public JPanel getRootPanel() {
        return historyTablePanel;
    }

    private void createTable() {
        loginHistory.setModel(new DefaultTableModel(null, new String[]{"Time", "Username", "Nickname"}));
    }

    public static void main(String[] args) {
        //loginHistoryWindow loginHistoryWindow = new loginHistoryWindow(null);
        JFrame frame = new JFrame("Login history of the app");
        frame.setContentPane(new loginHistoryWindow().historyTablePanel);
        frame.setSize(450, 474);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
