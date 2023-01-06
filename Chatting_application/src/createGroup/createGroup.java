package createGroup;

import addFriendWithGroup.addFriendWithGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createGroup extends JFrame implements ActionListener {
    JPanel panel;
    JButton back, create, add;
    JLabel name_group, addFr;

    public createGroup(){
        add(CreateUI());
        setTitle("Login admin");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel CreateUI() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel p1 = new JPanel(new GridLayout(2,2));
        name_group = new JLabel("Name group");
        JTextField nameText = new JTextField(20);
        p1.add(name_group);
        p1.add(nameText);


        addFr = new JLabel("Add friend");
        add = new JButton("Add Friend");
        p1.add(name_group);
        p1.add(nameText);
        p1.add(addFr);
        p1.add(add);

        JPanel p2 = new JPanel(new GridLayout(1,2));

        back = new JButton("Back");
        create = new JButton("Create");
        p2.add(back);
        p2.add(create);

        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.SOUTH);


        back.addActionListener(this);
        create.addActionListener(this);
        add.addActionListener(this);
        return panel;

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            dispose();

        }
        if(e.getSource() == create){

            JOptionPane.showMessageDialog(null,"Create group successfully");
            dispose();

        }
        if(e.getSource() == add){
            //addFriendWithGroup add = new addFriendWithGroup();
        }
    }
    public static void main (String[] args){
        new createGroup();
    }
}
