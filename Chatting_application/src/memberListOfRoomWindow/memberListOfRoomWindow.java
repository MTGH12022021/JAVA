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
    public static String[] isAd = {"1", "0", "1", "0"};
    public JPanel newPersonPanel(String url, String name, String isAd) throws IOException {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridLayout(1, 4));
        BufferedImage myPicture = ImageIO.read(new File(url));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JLabel nameLabel = new JLabel(name);
        JLabel adminLabel = new JLabel("");
        if(isAd.equals("1")){
            adminLabel.setText("Admin");
        }
        JButton deleteButton = new JButton("Delete from this room");
        newPanel.add(picLabel);
        newPanel.add(nameLabel);
        newPanel.add(adminLabel);
        newPanel.add(deleteButton);

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
                showUserField.add(newPersonPanel(urls[i], name[i], isAd[i]));
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
