package newPacket;

import javax.swing.*;

public class create_group extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JTable table1;
    private JButton createButton;
    private JButton buttonOK;

    public create_group() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        create_group dialog = new create_group();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
