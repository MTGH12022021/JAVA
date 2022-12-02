package console_more_group;

import javax.swing.*;

public class more_list_user_in_group extends JDialog {
    private JPanel contentPane;
    private JButton DELETEButton;
    private JButton button3;
    private JButton memberListButton;
    private JButton buttonOK;

    public more_list_user_in_group() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        more_list_user_in_group dialog = new more_list_user_in_group();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
