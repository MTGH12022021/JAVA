package loginAdmin;

import HomeAdmin.home_admin;
import controllers.admin.adminController;
import homeAdminUser.Home_admin_user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class login_admin extends JFrame implements ActionListener {
    private JPanel panel1;
    private JLabel username, password;
    private JTextField user_text;
    private JButton login, forget_pw, back;
    private JPasswordField pw_text;
    private JLabel title;
    private adminController AdminController = new adminController();
    public login_admin() {
        add(CreateUI());
        setTitle("Login admin");
        setSize(720, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel CreateUI() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // title
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(3, 2, 20, 20));
        username = new JLabel("Email");
        user_text = new JTextField();
        password = new JLabel("Password");
        pw_text = new JPasswordField();

        login = new JButton("Login");
        login.addActionListener(this);
        forget_pw = new JButton("Forgot password?");
        forget_pw.addActionListener(this);

        header.add(username);
        header.add(user_text);
        header.add(password);
        header.add(pw_text);
        header.add(login);
        header.add(forget_pw);

        panel1.add(header, BorderLayout.NORTH);

        // back
        back = new JButton("Back");
        back.addActionListener(this);

        panel1.add(back, BorderLayout.SOUTH);


        return panel1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            boolean check= AdminController.loginAdmin(user_text.getText(),pw_text.getText());
            System.out.println(check);
            if (check) {
                new home_admin();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Đăng nhập sai");
            }

        }
        if (e.getSource() == forget_pw) {

        }
        if (e.getSource() == back) {
            this.dispose();
            new Home_admin_user();
        }

    }



    public static void main(String[] args) {
        new login_admin();

        //jdbc


    }
}
