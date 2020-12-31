package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MColorChooser {

	public static void main(String[] args) {
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 250));

		final JButton button = new JButton("Select Color");
		button.addActionListener(e-> {
			final Color color = JColorChooser.showDialog(null, "Choose", null);
			panel.setBackground(color);
		});

		panel.add(button);

		MFrame.display("Color Chooser", panel);
	}
	
}
