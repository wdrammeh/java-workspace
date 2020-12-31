package network.other;

import javax.swing.*;

public class WebPageTester {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "This program reads data from a website and writes it to a file.", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		String urlPath = JOptionPane.showInputDialog(null, "Enter the URL: ", "URL", JOptionPane.QUESTION_MESSAGE);
		if (!urlPath.startsWith("https://")) {
			urlPath = "https://"+urlPath;
		}
		String fileName = JOptionPane.showInputDialog(null, "Enter the file name: ", "File Name", JOptionPane.QUESTION_MESSAGE);
		if (!fileName.endsWith(".txt")) {
			fileName = fileName+".txt";
		}
		WebPageReader reader = new WebPageReader();
		try {
			reader.readPage(urlPath, fileName);
			JOptionPane.showMessageDialog(null, "Data from '"+urlPath+"' is successfully written to the file '"+fileName+"'");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
