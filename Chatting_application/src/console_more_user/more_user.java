package console_more_user;

import javax.swing.*;

public class more_user extends JDialog {
    private JPanel contentPane;
    private JButton groupButton;
    private JButton button1;
    private JButton buttonOK;

    public more_user() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        more_user dialog = new more_user();
        dialog.pack();
        dialog.setSize(300,400);
        dialog.setVisible(true);
        System.exit(0);
    }
}
