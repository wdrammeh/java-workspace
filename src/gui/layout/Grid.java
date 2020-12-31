package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the grid layout on a panel.
 * A layout manager that lays out a container's components
 * in a rectangular grid. The container is divided into equal-sized rectangles,
 * and one component is placed in each rectangle.
 */
public class Grid {

	public static void main(String[] args) {
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");

		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		panel.setPreferredSize(new Dimension(300, 300));
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);

		MFrame.display("Grid Layout", panel);
	}
		
}
