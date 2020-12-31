package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MCheckBox {

	public static void main(String[] args) {
		final JTextField field = new JTextField("This is a sentence");
		field.setPreferredSize(new Dimension(150, 30));
		field.setFont(new Font("Arial", Font.PLAIN, 15));

		final JCheckBox bold = new JCheckBox("Bold");
		bold.addActionListener(e-> {
			if (bold.isSelected()) {
				field.setFont(new Font("Arial", Font.BOLD, 15));
			} else {
				field.setFont(new Font("Arial", Font.PLAIN, 15));
			}
		});

		final JCheckBox italic = new JCheckBox("Italic");
		italic.addActionListener(e-> {
			if (italic.isSelected()) {
				field.setFont(new Font("Arial", Font.ITALIC, 15));
			} else {
				field.setFont(new Font("Arial", Font.PLAIN, 15));
			}
		});

		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 150));
		panel.add(field);
		panel.add(bold);
		panel.add(italic);

		MFrame.display("CheckBox", panel);
	}

}
