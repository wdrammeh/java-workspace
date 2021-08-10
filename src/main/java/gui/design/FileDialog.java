package gui.design;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialog {
	
	public static void main(String[] args) {
		final JFileChooser chooser = new JFileChooser();
//		use a filter
		final FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int option = chooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile());
		}
	}
	
}
