package addFriendWithGroup;



import javax.swing.*;
import java.awt.*;

public class showFriend {
    private JPanel panel1;
    private JCheckBox checkBox1;
    private JButton button1;

    private String user_id;
    public showFriend(String userid){
        this.user_id = userid;
        button1.setPreferredSize(new Dimension(200,20));
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setButton1(String name) {
        this.button1.setText(name);
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        /*
        JFrame frame = new JFrame();
        JPanel panel = new showFriend().panel1;
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        System.out.println(panel.getPreferredSize().width);
        frame.setSize(panel.getPreferredSize().width,79);
        frame.setResizable(false);
        frame.setVisible(true);
        */
    }
}
