package gui.design;

import javax.swing.*;
import java.awt.*;

public class MEditorPane {
	Container c;
	
	public static void main(String[] a) {
		(new MEditorPane()).test();
	}
	
	private void test() {
		JFrame myFrame = new JFrame("JEditorPane Test");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(400, 400);
		final JEditorPane myPane = new JEditorPane();
		myPane.setContentType("text/html");
		myPane.setText("<html><h1>Sleeping</h1><p>Sleeping is necessary for a healthy body."
		+ " But sleeping in unnecessary times may spoil our health, wealth and studies."
		+ " Doctors advise that the sleeping at improper timings may lead for obesity during the students days.</p><html>");
		myPane.setSelectedTextColor(Color.YELLOW);
		myPane.setSize(300, 100);
		myFrame.setContentPane(myPane);
		myFrame.setLayout(new BoxLayout(myFrame.getContentPane(), BoxLayout.Y_AXIS));
//		myFrame.add(new JSeparator());
		
		myFrame.setVisible(true);
	}
}
