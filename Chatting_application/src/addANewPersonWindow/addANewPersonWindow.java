package addANewPersonWindow;

import memberListOfRoomWindow.memberListOfRoomWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addANewPersonWindow extends JFrame {
    private JTextField textField1;
    private JButton findButton;
    private JPanel addANewPersonPanel;
    private JButton backButton;

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
    public addANewPersonWindow(){
        this.setContentPane(this.addANewPersonPanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Add a new person");
        this.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new memberListOfRoomWindow();
            }
        });
    }
    public static void main(String[] args) {
        addANewPersonWindow addANewPersonWindow = new addANewPersonWindow();
    }

}
