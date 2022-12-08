package newPacket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_admin_user extends JFrame  implements ActionListener {
    static JPanel panel;
    static JButton admin, user, exit;
    public Home_admin_user(){
        add(CreateUI());
        setTitle("Home");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JPanel CreateUI(){
        panel = new JPanel(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel title = new JLabel("You are: ");
        panel.add(title);
        admin = new JButton("Admin");
        user = new JButton("User");
        exit = new JButton("Exit");
        admin.addActionListener(this);
        user.addActionListener(this);
        exit.addActionListener(this);

        panel.add(admin);
        panel.add(user);
        panel.add(exit);

        return panel;

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == admin) {
            this.dispose();
            new login_admin();
        }
        if(e.getSource() == user) {
//            this.dispose();

        }
        if(e.getSource() == exit) {
            this.dispose();
        }

    }
    public static void main(String[] agrs){
        new Home_admin_user();
    }

}
