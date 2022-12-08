import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class login_admin extends JFrame implements ActionListener {
    private JPanel panel1;
    private JLabel username, password;
    private JTextField user_text, pw_text;
    private JButton login, forget_pw, back;

    private JLabel title;

    public login_admin() {
        add(CreateUI());
        setTitle("Login admin");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel CreateUI() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // title
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(3, 2, 20, 20));
        username = new JLabel("Username");
        user_text = new JTextField();
        password = new JLabel("Password");
        pw_text = new JTextField();

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
            this.dispose();
            new home_admin();
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
