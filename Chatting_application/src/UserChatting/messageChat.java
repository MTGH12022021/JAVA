package UserChatting;

import javax.swing.*;

public class messageChat {
    private JTextArea textArea = new JTextArea();
    private JTextField textChat;
    private JPanel chatleft;
    private JLabel HoTen;
    private JLabel Time;
    private JTextArea displayMessage;

    public messageChat(){
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

    }

    public void setHoTen(String hoTen) {
        HoTen.setText(hoTen);
    }

    public JPanel getChatleft() {
        return chatleft;
    }

    public JTextArea getDisplayMessage() {
        return displayMessage;
    }

    public void setTime(String time) {
        Time.setText(time);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new messageChat().chatleft;
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        System.out.println(panel.getPreferredSize().width);
        frame.setSize(288,79);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
