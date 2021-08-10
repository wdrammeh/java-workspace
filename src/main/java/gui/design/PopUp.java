package gui.design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class PopUp {

	public static void main(String args[]) {
		new PopUp();
	}

	public PopUp() {
		final JFrame f = new JFrame("PopupMenu Example");

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);

		final JPopupMenu popupmenu = new JPopupMenu("Edit");

		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("cut MenuItem clicked.");
			}
		});

		JMenuItem copy = new JMenuItem("Copy");
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("copy MenuItem clicked.");
			}
		});

		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("paste MenuItem clicked.");
			}
		});

		popupmenu.add(cut);
		popupmenu.add(copy);
		popupmenu.add(paste);

		f.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				popupmenu.show(f, e.getX(), e.getY());
			}
		});
		f.add(label);
		f.add(popupmenu);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}