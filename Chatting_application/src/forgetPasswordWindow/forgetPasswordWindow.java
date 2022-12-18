package forgetPasswordWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import loginWindow.loginWindow;
public class forgetPasswordWindow extends JFrame{
    private JTextField textField1;
    private JButton sendButton;
    private JPanel forgetPanel;
    private JButton backButton;

    public forgetPasswordWindow(){
        this.setTitle("Forget password");
        this.setContentPane(forgetPanel);
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginWindow loginWindow = new loginWindow();
            }
        });
    }

    public static void main(String[] args) {
        forgetPasswordWindow forgetPasswordWindow = new forgetPasswordWindow();
    }
}
