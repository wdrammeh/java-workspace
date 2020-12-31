package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MScrollPane extends JScrollPane {

	public static void main(String[] args) {
		final JTextArea textArea = new JTextArea("Write here...");

		final JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(300, 200));
		panel.add(new MScrollPane(textArea), BorderLayout.CENTER);

		MFrame.display("ScrollPane", panel);
	}
	
	public MScrollPane(Component c) {
		super(c);
	}

}
