import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_admin extends JFrame implements ActionListener {
    private JPanel panel1;
    private JLabel title;
    private JButton user,group,history_login_app, setting,logout;


    public home_admin() {
        add(CreateUI());
        setTitle("Home");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JPanel CreateUI() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        // title
        title = new JLabel();
        title.setText("Home admin");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // button
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(5, 1, 20, 20));
        body.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        user = new JButton("List User");
        user.addActionListener(this);

        group = new JButton("Group");
        group.addActionListener(this);
        history_login_app = new JButton("History login app");
        history_login_app.addActionListener(this);

        logout = new JButton("Logout");
        logout.addActionListener(this);

        body.add(user);
        body.add(group);
        body.add(history_login_app);


        body.add(logout);

        panel1.add(title, BorderLayout.NORTH);
        panel1.add(body, BorderLayout.CENTER);
        return panel1;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == user){
            this.dispose();
            new list_user();
        }
        if(e.getSource() == group){
            this.dispose();
            new list_group();
        }
        if(e.getSource() == history_login_app){
            this.dispose();
//            new list_user();
        }

        if(e.getSource() == logout){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
              // login
            }
        }

    }

    public static void main(String[] args) {
        home_admin home = new home_admin();

    }
}
