package memberListOfRoomWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class memberListOfRoomWindow {
    public static String[] name = {"Volvo", "BMW", "Ford", "Mazda"};
    static String url = System.getProperty("user.dir")+"/src/memberListOfRoomWindow/temp_avatar.jpg";
    public static String[] urls = {url, url, url, url};
    public JPanel newPersonPanel(String url, String name) throws IOException {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());
        BufferedImage myPicture = ImageIO.read(new File(url));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JLabel nameLabel = new JLabel(name);
        newPanel.add(picLabel, BorderLayout.WEST);
        newPanel.add(nameLabel, BorderLayout.CENTER);
        return newPanel;
    }
    public memberListOfRoomWindow(){
        JFrame newFrame = new JFrame("Member list");
        newFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newFrame.setSize(300, 400);
        JPanel toolBar = new JPanel();
        JButton backButton = new JButton("Back");
        JButton addNewButton = new JButton("Add a person");
        toolBar.add(backButton);
        toolBar.add(addNewButton);
//        JLabel titleLabel = new JLabel("Member list of room");
        JPanel showUserField = new JPanel();
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());
        //System.out.println(System.getProperty("user.dir")+"/src/memberListOfRoomWindow/temp_avatar.jpg");
        JScrollPane scrollableTextArea = new JScrollPane(showUserField);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        showUserField.setLayout(new GridLayout(4, 1));
        try {
            for(int i=0; i<4; i++){
                showUserField.add(newPersonPanel(urls[i], name[i]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newPanel.add(toolBar, BorderLayout.NORTH);
        //newPanel.add(titleLabel);
        newPanel.add(scrollableTextArea, BorderLayout.CENTER);
        newFrame.add(newPanel);
        newFrame.setVisible(true);
    }
    public static void main(String args[]){
        memberListOfRoomWindow memberListOfRoomWindow = new memberListOfRoomWindow();
    }
}
