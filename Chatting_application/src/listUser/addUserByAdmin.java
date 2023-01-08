package listUser;

import controllers.users.chatApplicationUserController;
import listFriendNearly.list_friend_nearly;
import loginWindow.loginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addUserByAdmin extends JFrame{
    private chatApplicationUserController UserController ;
    private JPanel registerPanel;
    private JTextField nickname;
    private JTextField Username;
    private JTextField password;
    private JTextField Email;
    private JTextField textField1;
    private JRadioButton male;
    private JRadioButton female;
    private JButton ADDButton;

    public addUserByAdmin(){
        UserController = new chatApplicationUserController();

        this.setContentPane(this.registerPanel);
        this.setTitle("Add User");
        this.setSize(450, 474);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ADDButton.addActionListener(new ActionListener() {
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
                int check = UserController.Register(Username.getText(), Email.getText(), password.getText(), 0, 1,date, textField1.getText(),gioitinh );
                if (check == 1) {
                    dispose();
                    new loginWindow();
                    list_friend_nearly loginWindow = new list_friend_nearly(Email.getText());
                }
            }
        });
    }
}
