import javax.swing.*;

public class list_group extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton list_userButton;
    private JButton listt_groupButton;
    private JButton historyLoginButton;
    private JButton group1Button;
    private JButton moreButton;

    public list_group() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        list_group dialog = new list_group();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
