package loginHistoryWindow;

import HomeAdmin.home_admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginHistoryWindow extends JFrame {
    private JPanel historyTablePanel;
    private JButton backButton;
    private JTable loginHistory;

    public loginHistoryWindow() {
//        super(parent);
        createTable();
        this.setContentPane(this.historyTablePanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Login history of the app");
        this.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new home_admin();
            }
        });
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
