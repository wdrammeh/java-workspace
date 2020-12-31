package gui.design;

import javax.swing.*;
import java.awt.*;


public class Table {
	
	public static void main(String[] args) {
		final JTable t = new JTable(6, 5);
//		t.setIntercellSpacing(new Dimension(10, 10));
		t.setAutoscrolls(true);
		t.setRowHeight(25);
		t.getTableHeader().setFont(new Font("Monospace", Font.BOLD, 12));
//		t.getTableHeader().setOpaque(false);
		t.getTableHeader().setBackground(new Color(32, 136, 203));
		t.getTableHeader().setForeground(new Color(255, 255, 255));

//		JFrame.setDefaultLookAndFeelDecorated(true);
		final JFrame fr = new JFrame();
		fr.setBounds(275, 100, 700, 400);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.add(new JScrollPane(t));
		fr.setVisible(true);
	}

}
