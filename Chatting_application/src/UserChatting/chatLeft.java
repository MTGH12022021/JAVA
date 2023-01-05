package UserChatting;

import javax.swing.*;
import java.awt.*;

public class chatLeft {
    private JTextArea textArea = new JTextArea();
    private JTextField textChat;
    private JPanel chatleft;
    private JLabel HoTen;
    private JLabel Time;
    private JButton button1;
    private JPanel tempPanel;

    public chatLeft (){
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        tempPanel.
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new chatLeft().chatleft;
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        System.out.println(panel.getPreferredSize().width);
        frame.setSize(288,79);
        frame.setResizable(false);
        frame.setVisible(true);


    }
}
