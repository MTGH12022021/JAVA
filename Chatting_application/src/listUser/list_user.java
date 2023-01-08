package listUser;

import HomeAdmin.home_admin;
import controllers.users.chatApplicationUserController;

import moreGroup.more_group;
import moreUser.more_user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @version 1.0 11/09/98
 */
public class list_user extends JFrame implements ActionListener {
    static JButton back;
    static JPanel panel;
    private chatApplicationUserController userController = new chatApplicationUserController();
    private String[] Users_table= {"user_id","username","email","password","state","lockout", "establish","ngaysinh","gioitinh" ,"More"};

    private JTable table = new JTable();
    private JPanel footerPanel = new JPanel();
    private JButton addUser = new JButton("ADD");
    private JButton searchUser = new JButton("SEARCH");
    public list_user() {

        add(createGUI());
        setSize(960, 360);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public JPanel createGUI(){

        panel = new JPanel(new BorderLayout());
        DefaultTableModel dm = new DefaultTableModel();
        ResultSet rs = userController.showAllUser();

        table.setModel(dm);

        for (int i = 0; i < Users_table.length;i++){
            dm.addColumn(Users_table[i]);
        }
        int count = 0;

        try{
            do{
                dm.addRow(new Object[]{rs.getString(1),rs.getString(2)
                        ,rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9), "More"});
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        table.getColumn("More").setCellRenderer(new ButtonRenderer());
                        table.getColumn("More").setCellEditor(
                        new ButtonEditor(new JCheckBox()));
//        dm.setDataVector(new Object[] { "ID","Nickname","Username","Password",
//                "Email", "Date created" ,"More"});



        JScrollPane scroll = new JScrollPane(table);

        panel.add(scroll,BorderLayout.CENTER);
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel footer = new JPanel(new GridLayout(2,2));
        footer.add(back);
        footer.add(addUser);
        footer.add(searchUser);
        addUser.addActionListener(this);
        searchUser.addActionListener(this);
        panel.add(footer,BorderLayout.SOUTH);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back ) {
            this.dispose();
            new home_admin();
        }
        if (e.getSource() == addUser){
            new addUserByAdmin();
        }
        if(e.getSource() == searchUser){
            searchUser s = new searchUser();
        }
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            this.addActionListener(new ButtonEvent());
            setOpaque(true);
        }
        class ButtonEvent implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                int colIndex = table.getSelectedColumn();
                System.out.println(rowIndex + colIndex);
            }
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    /**
     * @version 1.0 11/09/98
     */

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        private String label;

        private boolean isPushed;
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int rowIndex = table.getSelectedRow();
                int colIndex = table.getSelectedColumn();
                String Email = (String)table.getValueAt(rowIndex,2);
                String user_id = (String)table.getValueAt(rowIndex,0);
                System.out.println(Email);
                more_user gr = new more_user(Email,user_id);
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
    public static void main(String[] args) {
        list_user frame = new list_user();

    }
}


