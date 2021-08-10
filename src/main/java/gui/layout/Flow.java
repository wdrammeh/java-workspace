package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the flow layout.
 * It's the default layout of swing containers like the JPanel.
 * It has a default x and y-gap of 5, and alignment of center.
 */
public class Flow {

	public static void main(String[] args) {
		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("Button3");
		JButton b4 = new JButton("Button4");

		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setPreferredSize(new Dimension(400,300));
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);

		MFrame.display("Flow Layout", panel);
	}

}
