package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the group layout.
 */
public class Group {

	public static void main(String[] args) {
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 100));
		final GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);

		// Turn on automatically creating gaps between components that touch
		// the edge of the container and the container.
		layout.setAutoCreateContainerGaps(true);

		final JLabel label1 = new JLabel("Email");
		label1.setFont(new Font("Serif", Font.BOLD, 15));
		final JLabel label2 = new JLabel("Password");
		label2.setFont(new Font("Serif", Font.BOLD, 15));
		final JTextField tf1 = new JTextField("Email", 10);
		final JTextField tf2 = new JTextField();

		// Create a sequential group for the horizontal axis.
		final GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		// The sequential group in turn contains two parallel groups.
		// One parallel group contains the labels, the other the text fields.
		// Putting the labels in a parallel group along the horizontal axis
		// positions them at the same x location.
		//
		// Variable indentation is used to reinforce the level of grouping.
		hGroup.addGroup(layout.createParallelGroup().addComponent(label1).addComponent(label2));
		hGroup.addGroup(layout.createParallelGroup().addComponent(tf1).addComponent(tf2));
		layout.setHorizontalGroup(hGroup);

		// Create a sequential group for the vertical axis.
		final GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		// The sequential group contains two parallel groups that align
		// the contents along the baseline. The first parallel group contains
		// the first label and text field, and the second parallel group contains
		// the second label and text field. By using a sequential group
		// the labels and text fields are positioned vertically after one another.
		vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(label1).addComponent(tf1));
		vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(label2).addComponent(tf2));
		layout.setVerticalGroup(vGroup);

		MFrame.display("Group Layout", panel);
	}

}