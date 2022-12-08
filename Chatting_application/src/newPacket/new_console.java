package newPacket;

import javax.swing.*;

public class new_console extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton send;
    private JButton iconButton;
    private JButton file;
    private JButton link;
    private JTextArea textArea1;
    private JButton moreButton;
    private JButton buttonOK;

    public new_console() {
        setContentPane(contentPane);
        setModal(true);


    }

    public static void main(String[] args) {
        new_console dialog = new new_console();
        dialog.pack();
        dialog.setSize(800,700);
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
