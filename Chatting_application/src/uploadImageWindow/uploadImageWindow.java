package uploadImageWindow;

import addANewPersonWindow.addANewPersonWindow;
import settingForOneToOneWindow.settingForOneToOneWindow;

import javax.swing.*;
import java.awt.*;

public class uploadImageWindow extends JFrame {
    private JButton selectAPictureButton;
    private JPanel uploadImagePanel;

    //    public uploadImageWindow(JFrame parent){
//        super(parent);
//        setTitle("Upload new image");
//        setContentPane(uploadImagePanel);
//        setMinimumSize(new Dimension(450, 474));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);
//    }
    public uploadImageWindow(){
        this.setContentPane(this.uploadImagePanel);
        this.setSize(450, 474);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Upload image");
        this.setVisible(true);
    }
    public static void main(String[] args) {
        uploadImageWindow uploadImageWindow = new uploadImageWindow();
        //JFrame frame = new JFrame("Upload image");

    }

}
