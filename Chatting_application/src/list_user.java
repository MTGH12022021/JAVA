import javax.swing.*;

public class list_user extends JDialog {
    private JPanel contentPane;
    private JButton list_userButton;
    private JButton listt_groupButton;
    private JButton historyLoginButton;
    private JTable table1;
    private JButton buttonOK;

    public list_user() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        list_user dialog = new list_user();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
