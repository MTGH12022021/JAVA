package loginHistoryWindow;

import friendListWindow.friendListWindow;
import loginWindow.loginWindow;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class loginHistoryWindow extends JFrame {
    private JPanel historyTablePanel;
    private JButton menuButton;
    private JTable loginHistory;

    public loginHistoryWindow() {
//        super(parent);
        createTable();
        this.setContentPane(this.historyTablePanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Login history of the app");
        this.setVisible(true);
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
        loginHistoryWindow loginHistoryWindow = new loginHistoryWindow();
        //JFrame frame = new JFrame("Login history of the app");

    }

}
