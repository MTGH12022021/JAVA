package registerWindow;

import addANewPersonWindow.addANewPersonWindow;
import loginWindow.loginWindow;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class registerWindow extends JFrame {
    private JTextField nickname;
    private JTextField Username;
    private JTextField password;
    private JTextField Email;
    private JRadioButton male;
    private JRadioButton female;
    private JTextField textField1;
    private JButton signUpButton;
    private JButton loginButton;
    private JPanel registerPanel;

    //    public registerWindow(JFrame parent){
//        super(parent);
//        setTitle("Register");
//        setContentPane(registerPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    public registerWindow(){
        this.setContentPane(this.registerPanel);
        this.setTitle("Register");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        //registerWindow registerWindow = new registerWindow(null);
        registerWindow windowL = new registerWindow();

    }

}
