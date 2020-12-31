package gui.design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCombo {
	JFrame f;
	
	public static void main(String[] args) {
		new MCombo();
	}
	
	public MCombo(){
		
		f = new JFrame("ComboBox Example");
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400,100);
		
		JButton b = new JButton("Show");
		b.setBounds(200,100,75,20);
		
		String languages[] = {"C","C++","C#","Java","PHP"};
		final JComboBox<Object> cb = new JComboBox<>(languages);
		cb.setBounds(50, 100,90,20);
		f.add(cb); f.add(label); f.add(b);
		f.setLayout(null);
		f.setSize(350,300);
		f.setVisible(true);
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String data = "Programming language Selected: "+cb.getItemAt(cb.getSelectedIndex());
				label.setText(data);
			}
		});
	}
}
