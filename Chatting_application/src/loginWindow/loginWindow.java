package loginWindow;

import addANewPersonWindow.addANewPersonWindow;
import registerWindow.registerWindow;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import newPacket.Home_admin_user;
public class loginWindow extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton Login;
    private JButton signup;
    private JPanel loginPanel;

    //    public loginWindow(JFrame parent){
//        super(parent);
//        setTitle("Login");
//        setContentPane(loginPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    public loginWindow() {
        this.setContentPane(this.loginPanel);
        this.setTitle("Login");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                registerWindow r = new registerWindow();
            }
        });
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home_admin_user();
            }
        });
    }

    public static void main(String[] args) {
        //loginWindow loginWindow = new loginWindow(null);
        //new registerWindow();
//        JFrame frame = new JFrame("Login");
//        frame.setContentPane(new loginWindow().loginPanel);
//        frame.setSize(450, 474);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.setVisible(true);
        loginWindow windowL = new loginWindow();

    }
}