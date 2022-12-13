package uploadImageWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class uploadImageWindow extends JFrame implements ActionListener {
    private JButton selectAPictureButton;
    private JPanel uploadImagePanel;
    private JButton backButton;
    private JButton changeButton;


    public uploadImageWindow(){
        this.setContentPane(this.uploadImagePanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Upload image");
        this.setVisible(true);

        backButton.addActionListener(this);
        changeButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
        }
        if(e.getSource() == changeButton){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to change avatar?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,"Change successfully");
            }
            dispose();
        }
    }
    public static void main(String[] args) {
        uploadImageWindow uploadImageWindow = new uploadImageWindow();
        //JFrame frame = new JFrame("Upload image");

    }

}
