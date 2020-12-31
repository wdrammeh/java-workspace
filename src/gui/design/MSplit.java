package gui.design;

import javax.swing.*;
import java.awt.*;

public class MSplit {
	
	private static void createAndShow() {
		final JFrame frame = new JFrame("JSplitPane Example");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());

		final String[] option1 = { "A","B","C","D","E" };

		final JComboBox<Object> box1 = new JComboBox<>(option1);

		final String[] option2 = {"1","2","3","4","5"};

		final JComboBox<Object> box2 = new JComboBox<>(option2);

		final Panel panel1 = new Panel();
		panel1.add(box1);

		final Panel panel2 = new Panel();
		panel2.add(box2);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		frame.getContentPane().add(splitPane);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShow();
			}
		});
	}
}
