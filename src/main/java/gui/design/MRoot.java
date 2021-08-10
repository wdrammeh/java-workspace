package gui.design;

import javax.swing.*;

public class MRoot {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRootPane root = f.getRootPane();
		
		// Create a menu bar
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.add("Open");
		menu.add("Close");
		
		bar.add(menu);
		
		root.setJMenuBar(bar);
		
		// Add a button to the content pane
		root.getContentPane().add(new JButton("Press Me"));
		
		// Display the UI
		f.pack();
		f.setVisible(true);
	}
}