package uploadImageWindow;

import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;

public class uploadImageWindow extends JDialog{
    private JButton selectAPictureButton;
    private JPanel uploadImagePanel;
    public uploadImageWindow(JFrame parent){
        super(parent);
        setTitle("Upload new image");
        setContentPane(uploadImagePanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        uploadImageWindow uploadImageWindow = new uploadImageWindow(null);
    }
}
