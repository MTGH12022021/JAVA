import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class console_chat extends JFrame{
    private JTextField textField1;
    private JButton searchButton;
    private JTextField messTextField;


    public console_chat(){
        this.setSize(300, 400);
        this.setTitle("chatting");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    public void chatting_console(){
        JPanel wrap = new JPanel();
//        trong wrap co2 JPanel
        // searh
        JPanel search_people = new JPanel();
//        search_people.setSize(50,400);
        search_people.setBackground(new Color(123,23,234));
        search_people.setOpaque(true);
        search_people.setBorder(null);
        JPanel wrap_seacrch = new JPanel();

        JTextField search = new JTextField();
//        JPanel icon_seach = new JPanel();
        JButton icon_seach = new JButton();
        icon_seach.setLayout(new GridLayout());
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("send1.png"));
//        icon_seach.();

        wrap_seacrch.setLayout(new GridLayout());

        wrap_seacrch.add(search);
        wrap_seacrch.add(icon_seach);

        //chat
        JPanel chat_friend = new JPanel();
//        chat_friend.setSize(200,400);
        chat_friend.setBackground(new Color(163,233,234));
        chat_friend.setOpaque(true);
        chat_friend.setBorder(null);
        wrap.setLayout(new GridLayout());
        wrap.add(search_people);
        wrap.add(chat_friend);

        this.setLayout(new GridLayout());
        this.add(wrap);

    }
    public void user_online(String name, ImageIcon avatar){
        JPanel jPanel = new JPanel();
        JLabel name_friend= new JLabel(name);


    }
    public static void main(String[] args) {
        try {
            console_chat cs = new console_chat();
            cs.chatting_console();
//            JPanel jPanel = new JPanel();
//            JLabel name_friend= new JLabel("test color");
//            jPanel.setLayout(new GridLayout());
//            jPanel.setSize(200,200);
//            jPanel.add(name_friend);
//            jPanel.setBackground(new Color(123,232,34));
//            jPanel.setOpaque(true);
//            jPanel.setBorder(null);
//            cs.add(jPanel);
//            String path_file = System.getProperty("user.dir") + "\\chattinng\\src\\image\\send.png";
////            System.out.println(path_file);
//            URL img_link = console_chat.class.getResource(  "send1.png");
//            Image img = Toolkit.getDefaultToolkit().createImage(img_link);
//            cs.setIconImage(img);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
