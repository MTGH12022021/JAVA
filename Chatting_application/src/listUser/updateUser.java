package listUser;

import controllers.users.chatApplicationUserController;
import listFriendNearly.list_friend_nearly;
import loginWindow.loginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class updateUser extends JFrame{
    private JPanel updatePanel;
    private JTextField Username;
    private JTextField password;
    private JTextField Email;
    private JTextField textField1;
    private JRadioButton male;
    private JRadioButton female;
    private JButton UPDATEButton;
    private chatApplicationUserController UserController = new chatApplicationUserController();
    private String user_id;
    public updateUser(String userID){
        this.setContentPane(this.updatePanel);
        this.setTitle("Update User");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.user_id = userID;
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date now = new Date();
                String date = formatter.format(now);
                String gioitinh;
                if (male.isSelected()){
                    gioitinh = "Nam";
                }else {
                    gioitinh = "Nữ";
                }
                UserController.updateUser(user_id,Username.getText(), Email.getText(), textField1.getText(),gioitinh);

            }
        });
    }
}
