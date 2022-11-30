package addANewPersonWindow;

import memberListOfRoomWindow.memberListOfRoomWindow;

import javax.swing.*;
import java.awt.*;

public class addANewPersonWindow extends JDialog{
    private JTextField textField1;
    private JButton findButton;
    private JPanel addANewPersonPanel;
    public addANewPersonWindow(JFrame parent){
        super(parent);
        setTitle("Add a person");
        setContentPane(addANewPersonPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        addANewPersonWindow addANewPersonWindow = new addANewPersonWindow(null);}
}
