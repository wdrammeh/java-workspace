package gui.design;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MLayered extends JFrame {
	/**
	 * note that this classnis using buttons instead
	 * @param args
	 */
	
	public static void main(String[] args) {
		MLayered lp = new MLayered();
		lp.setVisible(true);
		
	}
	
	@SuppressWarnings("deprecation")
	public MLayered() {
		super("LayeredPane Demo");
		setSize(200, 200);
		JLayeredPane lpane = this.getLayeredPane();
		
		//creating buttons
		JButton top = new JButton();
		top.setBackground(Color.white);
		top.setBounds(20, 20, 50, 50);
		
		JButton middle = new JButton();
		middle.setBackground(Color.red);
		middle.setBounds(40, 40, 50, 50);
		
		JButton bottom = new JButton();
		bottom.setBackground(Color.cyan);
		bottom.setBounds(60, 60, 50, 50);
		
		//adding buttons on pane
		lpane.add(bottom, 0);
		lpane.add(middle, 1);
		lpane.add(top, 2);
		
	}
	
}
