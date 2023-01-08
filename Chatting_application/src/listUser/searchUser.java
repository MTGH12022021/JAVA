package listUser;

import controllers.users.chatApplicationUserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchUser extends JFrame{
    private JTextField usernameTextfield;
    private JButton searchButton;

    private JPanel contentPanel;
    private JScrollPane pane;
    private JButton AscButton;
    private JButton DescButton;
    private JPanel buttonPanel;

    private String user_id;
    private JTable table = new JTable();
    private String[] Users_table= {"user_id","username","email","password","state","lockout", "establish", "ngaysinh", "gioitinh" };

    private chatApplicationUserController UserController = new chatApplicationUserController();

    public searchUser() {
        this.setContentPane(this.contentPanel);

        this.setTitle("Update User");
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultTableModel dm = new DefaultTableModel();
        table.setModel(dm);

        for (int i = 0; i < Users_table.length;i++){
            dm.addColumn(Users_table[i]);
        }


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.getDataVector().removeAllElements();
                revalidate();
                ResultSet rs = UserController.searchUserByUsername(usernameTextfield.getText());

                if (rs!=null){
                    System.out.println("hello");
                    try {
                        do {
                            dm.addRow(new Object[]{rs.getString(1), rs.getString(2)
                                    , rs.getString(3), rs.getString(4),
                                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9)});
                            System.out.println(rs.getString(3));
                        } while (rs.next());
                    }catch(SQLException E){
                        E.printStackTrace();
                    }
                }
            }
        });

        AscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.getDataVector().removeAllElements();
                revalidate();
                ResultSet rs = UserController.filterUserByEstablishAsc();

                if (rs!=null){
                    try {
                        do {
                            dm.addRow(new Object[]{rs.getString(1), rs.getString(2)
                                    , rs.getString(3), rs.getString(4),
                                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9)});
                        } while (rs.next());
                    }catch(SQLException E){
                        E.printStackTrace();
                    }
                }
            }
        });
            DescButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dm.getDataVector().removeAllElements();
                    revalidate();
                    ResultSet rs = UserController.filterUserByEstablishDesc();

                    if (rs!=null){
                        try {
                            do {
                                dm.addRow(new Object[]{rs.getString(1), rs.getString(2)
                                        , rs.getString(3), rs.getString(4),
                                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9)});
                            } while (rs.next());
                        }catch(SQLException E){
                            E.printStackTrace();
                        }
                    }
                }
            });


        pane.getViewport().add(table);

    }
}
