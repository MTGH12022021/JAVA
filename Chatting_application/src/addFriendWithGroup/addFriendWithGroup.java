package addFriendWithGroup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addFriendWithGroup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton backButton;
    private JButton friend1Button;
    private JCheckBox addCheckBox;
    private JButton buttonOK;

    public addFriendWithGroup() {
        setContentPane(contentPane);
        setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
        }
    }
    public static void main(String[] args) {
        addFriendWithGroup dialog = new addFriendWithGroup();

    }
}
