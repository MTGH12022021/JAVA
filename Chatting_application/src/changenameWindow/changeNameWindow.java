package changenameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeNameWindow extends JFrame implements ActionListener {
    private JPanel changeNamePanel;
    private JButton backButton;
    private JButton saveButton;
    private JTextField textField1;


    public changeNameWindow(){
        this.setContentPane(this.changeNamePanel);
        this.setSize(450, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Change name");
        this.setVisible(true);

        saveButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            dispose();
        }
        if (e.getSource()==saveButton){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to change name?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,"Change successfully");
            }
        }
    }
    public static void main(String[] args) {
        changeNameWindow changeNameWindow = new changeNameWindow();
        //JFrame frame = new JFrame("Change name");

    }

}
