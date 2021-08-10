package gui.design;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SlideMe extends JFrame{

	public static void main(String s[]) {
		final SlideMe frame = new SlideMe();
		frame.setLocationRelativeTo(null);
		frame.setSize(400,250);
		frame.setVisible(true);
	}
	
	public SlideMe() {

		final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTrack(true);

		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(slider,BorderLayout.CENTER);

		getContentPane().add(panel);
	}

}
