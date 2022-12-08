import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class more_group extends JFrame  implements ActionListener {
    static JPanel panel;
    static JButton delete,list_friends,back;
    public more_group(){
        add(CreateUI());
        setTitle("More");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JPanel CreateUI(){
        panel = new JPanel(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        list_friends = new JButton("List friend");
        delete = new JButton("Delete");
        back = new JButton("Back");
        back.addActionListener(this);
        panel.add(list_friends);
        panel.add(delete);
        panel.add(back);


        return panel;

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
        }

    }
    public static void main(String[] agrs){
        new more_group();
    }

}
