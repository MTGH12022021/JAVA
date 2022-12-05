package addANewPersonWindow;

import changenameWindow.changeNameWindow;
import memberListOfRoomWindow.memberListOfRoomWindow;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class addANewPersonWindow extends JDialog {
    private JTextField textField1;
    private JButton findButton;
    private JPanel addANewPersonPanel;

    //    public addANewPersonWindow(JFrame parent){
//        super(parent);
//        setTitle("Add a person");
//        setContentPane(addANewPersonPanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Add a new person");
        frame.setContentPane(new addANewPersonWindow().addANewPersonPanel);
        frame.setSize(450, 474);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
