import javax.swing.*;

public class list_member_in_group extends JDialog {
    private JPanel contentPane;
    private JTable table1;
    private JButton buttonOK;

    public list_member_in_group() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        list_member_in_group dialog = new list_member_in_group();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
