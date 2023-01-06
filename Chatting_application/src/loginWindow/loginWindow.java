package loginWindow;


import Chatting.chatting;
import controllers.users.chatApplicationUserController;
import homeAdminUser.Home_admin_user;
import registerWindow.registerWindow;
import forgetPasswordWindow.forgetPasswordWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginWindow extends JFrame implements ActionListener {
    private JTextField username;
    private JTextField password;
    private JButton Login;
    private JButton signup;
    private JPanel loginPanel;
    private JButton backButton;
    private JButton forgetPasswordButton;
    private chatApplicationUserController UserController = new chatApplicationUserController();
    public loginWindow() {
        this.setContentPane(this.loginPanel);
        this.setTitle("Login");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Login.addActionListener(this);
        signup.addActionListener(this);
        backButton.addActionListener(this);
        forgetPasswordButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
            Home_admin_user h = new Home_admin_user();
        }
        if(e.getSource() == signup){
            dispose();
            registerWindow r = new registerWindow();
        }
        if(e.getSource() == Login){
            boolean check = UserController.Login(username.getText(),password.getText());

            System.out.println(check);
            if (check) 
            {
                dispose();
                chatting chat = new chatting(username.getText());
            }
        }
        if(e.getSource() == forgetPasswordButton){
            dispose();
            forgetPasswordWindow forgetPasswordWindow = new forgetPasswordWindow();
        }
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