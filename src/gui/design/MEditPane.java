package gui.design;
	
import javax.swing.*;
import java.awt.*;

public class MEditPane {
	JFrame myFrame = null;


	public static void main(String[] a) {
		new MEditPane().test();
	}

	private void test() {
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		editorPane.setFont(new Font("",Font.PLAIN,15));
		editorPane.setEditable(false);
		editorPane.setText("Sleeping is necessary for a <b>health</b> body."
				+ " But <i>sleeping in unnecessary times</i> may spoil our health, wealth and studies."
				+ " Doctors advise that the sleeping at improper timings may lead for obesity during the students days.");

		final JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setFont(new Font("",Font.PLAIN,15));
		textPane.setEditable(false);
		textPane.setText("Sleeping is necessary for a <b>health</b> body."
				+ " But <i>sleeping in unnecessary times</i> may spoil our health, wealth and studies."
				+ " Doctors advise that the sleeping at improper timings may lead for obesity during the students days.");


		myFrame = new JFrame("JEditorPane & TextPane Demo");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(500, 300);
		myFrame.getContentPane().setLayout(new BoxLayout(myFrame.getContentPane(), BoxLayout.Y_AXIS));
		myFrame.getContentPane().add(editorPane);
		myFrame.getContentPane().add(Box.createRigidArea(new Dimension(100,25)));
		myFrame.getContentPane().add(textPane);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

}