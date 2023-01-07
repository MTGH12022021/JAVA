package registerWindow;

import controllers.users.chatApplicationUserController;
import listFriendNearly.list_friend_nearly;
import loginWindow.loginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
public class registerWindow extends JFrame {
    private chatApplicationUserController UserController ;
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
        UserController = new chatApplicationUserController();

        this.setContentPane(this.registerPanel);
        this.setTitle("Register");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //todo button login process
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginWindow loginWindow = new loginWindow();
            }
        });
        //todo button register process
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date now = new Date();
                String date = formatter.format(now);

                int check = UserController.Register(Username.getText(), Email.getText(), password.getText(), 0, date);
                if (check == 1) {
                    dispose();
                    new loginWindow();
                    //list_friend_nearly loginWindow = new list_friend_nearly(Email.getText());
                }
            }
        });
    }
    public static void main(String[] args) {
        //registerWindow registerWindow = new registerWindow(null);
        registerWindow windowL = new registerWindow();

    }

}
