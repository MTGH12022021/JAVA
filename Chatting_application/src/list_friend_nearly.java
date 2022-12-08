import javax.swing.*;

public class list_friend_nearly extends JDialog {
    private JPanel contentPane;
    private JButton button1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton addFriendButton;
    private JButton buttonOK;

    public list_friend_nearly() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        list_friend_nearly dialog = new list_friend_nearly();
        dialog.pack();
        dialog.setSize(300, 400);
        dialog.setVisible(true);
        System.exit(0);
    }
}
