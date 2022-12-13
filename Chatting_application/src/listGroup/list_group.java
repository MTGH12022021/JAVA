package listGroup;


import HomeAdmin.home_admin;
import moreGroup.more_group;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @version 1.0 11/09/98
 */
public class list_group extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton back;
    public list_group() {
        super("Group list");


        add(createGUI());
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JPanel createGUI(){

        panel = new JPanel(new BorderLayout());
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] { { "foo","123","More"},
                { "123","dung","More"} }, new Object[] { "Group name","Admin","More"});

        JTable table = new JTable(dm);
        table.getColumn("More").setCellRenderer(new ButtonRenderer_list_group());
        table.getColumn("More").setCellEditor(
                new ButtonEditor_list_group(new JCheckBox()));
        JScrollPane scroll = new JScrollPane(table);

        panel.add(scroll,BorderLayout.CENTER);
        back = new JButton("Back");
        back.addActionListener(this);
        panel.add(back, BorderLayout.SOUTH);
        return panel;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
            new home_admin();

        }

    }

    public static void main(String[] args) {

        new list_group();

    }
}

class ButtonRenderer_list_group extends JButton implements TableCellRenderer {

    public ButtonRenderer_list_group() {
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

class ButtonEditor_list_group extends DefaultCellEditor {
    protected JButton button;

    private String label;

    private boolean isPushed;

    public ButtonEditor_list_group(JCheckBox checkBox) {
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

            more_group a = new more_group();

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

