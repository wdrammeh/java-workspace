package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the vertical box layout on a panel.
 * Note that "invisible components" can be used to control
 * sizing within a box layout.
 * @see XBox
 */
public class YBox {

	public static void main(String[] args) {
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 300));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (int i = 1; i <= 5;) {
			panel.add(new JButton(String.format("Button %d", i++)));
		}

		MFrame.display("YBox Layout", panel);
	}

}
