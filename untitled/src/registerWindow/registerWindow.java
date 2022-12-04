package registerWindow;

import addANewPersonWindow.addANewPersonWindow;
import loginWindow.loginWindow;

import javax.swing.*;
import java.awt.*;

public class registerWindow extends JDialog{
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
    public static void main(String[] args){
        //registerWindow registerWindow = new registerWindow(null);
        JFrame frame = new JFrame("Register");
        frame.setContentPane(new registerWindow().registerPanel);
        frame.setSize(450, 474);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
