package gui.design;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OptionPane extends WindowAdapter{
	JFrame f;
	
	public static void main(String[] args) {
		new OptionPane();
	}
	
	public OptionPane(){
		
	f = new JFrame();
	f.addWindowListener(this);
	f.setSize(300, 300);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	f.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(f, "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION);
		//Try the one with an icon as well
		if(a == JOptionPane.YES_OPTION){
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
}
