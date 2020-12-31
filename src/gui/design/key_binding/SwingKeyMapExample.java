package gui.design_plus.key_binding;

import javax.swing.*;

public class SwingKeyMapExample {

	public static void main(String[] args) {
		final JFrame frame = new SwingKeyMapExampleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 450);
		frame.setLocationRelativeTo(null);
		SwingUtilities.invokeLater(() -> {
			frame.setVisible(true);
		});
	}

}
