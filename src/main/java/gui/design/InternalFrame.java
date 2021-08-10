package gui.design;

import javax.swing.*;
import java.awt.*;

public class InternalFrame {
	
	public static void main(String[] args) {
		final JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true,
				true, true, true);
		internalFrame.setPreferredSize(new Dimension(300, 200));
		internalFrame.setVisible(true);

		JFrame frame = new JFrame("Main frame");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLayout(new FlowLayout());
		frame.add(internalFrame);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
