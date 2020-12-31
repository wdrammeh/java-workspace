package gui.anim;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class InfiniteProgress extends JProgressBar {

	public static void main(String[] args) {
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 100));
		panel.add(new InfiniteProgress());
		MFrame.display("Progress Bar", panel);
	}

	public InfiniteProgress(){
		super(0, 100);
		setStringPainted(true);
		setPreferredSize(new Dimension(150, 30));
		new Timer(100, e-> {
			if (getValue() < getMaximum()) {
				setValue(getValue() + 1);
			} else {
				setValue(getMinimum());
			}
		}).start();
	}

}
