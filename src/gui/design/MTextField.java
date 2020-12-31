package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MTextField {

	public static void main(String[] args) {
		final JTextField tf = new JTextField("Enter name");
		tf.setPreferredSize(new Dimension(200, 30));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setAutoscrolls(true);
		tf.setMargin(new Insets(0,5,0,5));

		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 200));
		panel.add(tf);

		MFrame.display("TextField", panel);
	}

}
