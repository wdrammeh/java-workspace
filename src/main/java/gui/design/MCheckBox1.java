package gui.design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MCheckBox1 {
	
	public static void main(String args[]) {
		new MCheckBox1();
	}
	
	public MCheckBox1(){
	JFrame f = new JFrame("CheckBox Example");
	
	final JLabel label = new JLabel("");
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setSize(400,100);
	
	JCheckBox checkbox1 = new JCheckBox("C++");
	checkbox1.setBounds(150,100, 150,50);
	
	JCheckBox checkbox2 = new JCheckBox("Java");
	checkbox2.setBounds(150,150, 150,50);
	checkbox2.setBorderPaintedFlat(false);
	checkbox2.setHorizontalTextPosition(SwingConstants.LEFT);

	f.add(checkbox1); f.add(checkbox2); f.add(label);
	
	checkbox1.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			label.setText("C++ Checkbox: "+(e.getStateChange()==1?"checked":"unchecked"));
		}
	});
	
	checkbox2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		label.setText("Java Checkbox: "+ (e.getStateChange()==1?"checked":"unchecked"));
		}
	});
	
	f.setSize(400,400);
	f.setLayout(null);
	f.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
	f.setVisible(true);
	}
}
