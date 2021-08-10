package gui.design;

import gui.MFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MTable {

	public static void main(String[] args) {
		String[] COLUMNS = {"ID", "NAME", "ADDRESS", "AGE"};

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(COLUMNS);
		model.addRow(new Object[]{12,"Muhammed","Sukuta",22});
		model.addRow(new Object[]{12,"Ibrahim","Mecca",32});
		model.addRow(new Object[]{12,"Yusuf","Yemen",26});
		model.addRow(new Object[]{12,"Essa","Israel",18});
		model.addRow(new Object[]{12,"Maryam","Nazareth",24});

		final JTable table = new JTable(model);
		table.setRowHeight(25);
		table.setFont(new Font("Monospace", Font.PLAIN, 15));
		table.getTableHeader().setFont(new Font("Monospace", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(true);
//		set column widths
		table.getColumn("ID").setPreferredWidth(50);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(450, 250));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 300));
		panel.add(scrollPane);

		MFrame.display("Table", panel);
	}

}
