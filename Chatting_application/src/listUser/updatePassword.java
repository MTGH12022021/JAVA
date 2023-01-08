package listUser;

import controllers.users.chatApplicationUserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updatePassword extends  JFrame{
    private JPanel updatePanel;
    private JTextField password;
    private JButton UPDATEButton;
    private JPanel contentPanel;

    private String user_id;

    private chatApplicationUserController userController = new chatApplicationUserController();
    public updatePassword(String userID){
        updatePanel.setLayout(new BoxLayout(updatePanel,BoxLayout.Y_AXIS));
        this.setContentPane(this.contentPanel);
        this.setTitle("Update Password");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.user_id = userID;

        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userController.updatePassword(user_id,password.getText());
            }
        });
    }


}
