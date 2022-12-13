package listUser;

import HomeAdmin.home_admin;
import moreUser.more_user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @version 1.0 11/09/98
 */
public class list_user extends JFrame implements ActionListener {
    static JButton back;
    static JPanel panel;
    public list_user() {

        add(createGUI());
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public JPanel createGUI(){
        panel = new JPanel(new BorderLayout());
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] { { "foo","123","dung" ,"","","","More"},
                { "123","dung","More" ,"","","" ,"More"} }, new Object[] { "ID","Nickname","Username","Password",
                "Email", "Date created" ,"More"});

        JTable table = new JTable(dm);
        table.getColumn("More").setCellRenderer(new ButtonRenderer());
        table.getColumn("More").setCellEditor(
                new ButtonEditor(new JCheckBox()));
        JScrollPane scroll = new JScrollPane(table);
        panel.add(scroll,BorderLayout.CENTER);
        back = new JButton("Back");
        back.addActionListener(this);
        panel.add(back,BorderLayout.SOUTH);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back ) {
            this.dispose();
            new home_admin();
        }

    }

    public static void main(String[] args) {


        list_user frame = new list_user();

    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
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

            more_user add = new more_user();

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
