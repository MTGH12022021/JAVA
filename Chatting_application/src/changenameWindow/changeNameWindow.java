package changenameWindow;

import javax.swing.*;
import java.awt.*;

public class changeNameWindow extends JFrame {
    private JTextField newName;
    private JPanel changeNamePanel;

    //    public changeNameWindow(JFrame parent){
//        super(parent);
//        setTitle("Change name");
//        setContentPane(changeNamePanel);
//        setMinimumSize(new Dimension(450, 100));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    changeNameWindow(){
        this.setContentPane(this.changeNamePanel);
        this.setSize(450, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Change name");
        this.setVisible(true);
    }
    public static void main(String[] args) {
        changeNameWindow changeNameWindow = new changeNameWindow();
        //JFrame frame = new JFrame("Change name");

    }

}
