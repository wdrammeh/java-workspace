package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the border layout on a panel.
 * Adds a component at any of the borders (top, bottom, left, right, or center)
 * as specified by the add argument, otherwise in the center, by default.
 */
public class Border {

	public static void main(String[] args) {
		final JButton btn1 = new JButton("Button 1 (PAGE_START)");
		final JButton btn2 = new JButton("Button 2 (PAGE_END)");
		final JButton btn3 = new JButton("Button 3 (LINE_START)");
		final JButton btn4 = new JButton("Button 4 (LINE_END)");
		final JButton btn5 = new JButton("Button 5 (CENTER)");

		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 300));
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(btn1, BorderLayout.PAGE_START);  //simply north, under top-bottom orientation
		panel.add(btn2, BorderLayout.PAGE_END);  // south, under top-bottom orientation
		panel.add(btn3, BorderLayout.LINE_START);  // west, under top-bottom orientation
		panel.add(btn4, BorderLayout.LINE_END);  // east, under top-bottom orientation
		panel.add(btn5, BorderLayout.CENTER);

		MFrame.display("Border Layout", panel);
	}

}
