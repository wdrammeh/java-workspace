package gui.practice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RowPractice {

    private static Object[] rows = new Object[4];

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTable table = new JTable();
//        table.setEnabled(false);

        Object[] column = {"ID", "First Name", "Last Name", "Age"};
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
//                return super.isCellEditable(row, column);
                return false;
            }
        };
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(new Font("", Font.PLAIN, 14));
        table.setRowHeight(24);

        JTextField idField = new JTextField();
        JTextField fnameField = new JTextField();
        JTextField lnameField = new JTextField();
        JTextField ageField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        idField.setBounds(20,220,100,25);
        fnameField.setBounds(20,250,100,25);
        lnameField.setBounds(20,280,100,25);
        ageField.setBounds(20,310,100,25);

        addButton.setBounds(150,220,100,25);
        updateButton.setBounds(150,265,100,25);
        deleteButton.setBounds(150,310,100,25);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0,0,880,200);

        frame.setLayout(null);

        frame.add(tableScrollPane);
        frame.add(idField);
        frame.add(fnameField);
        frame.add(lnameField);
        frame.add(ageField);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(updateButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rows[0] = idField.getText();
                rows[1] = fnameField.getText();
                rows[2] = lnameField.getText();
                rows[3] = ageField.getText();

                model.addRow(rows);
                table.repaint();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    int sure = JOptionPane.showConfirmDialog(null,"Are you sure to remove "+table.getValueAt(i,1),"Comfirm Deletion",JOptionPane.YES_NO_OPTION);
                    if (sure == JOptionPane.YES_OPTION) {
                        model.removeRow(i);
                        table.repaint();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Deletion Error!");
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                idField.setText(String.valueOf(model.getValueAt(i,0)));
                fnameField.setText(String.valueOf(model.getValueAt(i,1)));
                lnameField.setText(String.valueOf(model.getValueAt(i,2)));
                ageField.setText(String.valueOf(model.getValueAt(i,3)));
            }
        });


        updateButton.addActionListener(actionEvent -> {
            int i = table.getSelectedRow();

            if (i >= 0) {
                model.setValueAt(idField.getText(), i, 0);
                model.setValueAt(fnameField.getText(), i, 1);
                model.setValueAt(lnameField.getText(), i, 2);
                model.setValueAt(ageField.getText(), i, 3);
            } else {
                JOptionPane.showMessageDialog(null, "Update Error!");
            }
        });

        frame.setSize(new Dimension(900,400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
