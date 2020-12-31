package gui.design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListExample {
	
	public static void main(String args[]) {
		new ListExample();
	}
	
	public ListExample(){
	JFrame f = new JFrame();
	
	final JLabel label = new JLabel();
	label.setSize(500,100);
	
	JButton b = new JButton("Show");
	b.setBounds(200,150,80,30);
	
	final DefaultListModel<String> l1 = new DefaultListModel<>();
	l1.addElement("C");
	l1.addElement("C++");
	l1.addElement("Java");
	l1.addElement("PHP");
	
	final JList<String> list1 = new JList<>(l1);//of the default list model
	list1.setBounds(100,100, 75,75);
	
	DefaultListModel<String> l2 = new DefaultListModel<>();//hm another
	l2.addElement("Turbo C++");
	l2.addElement("Struts");
	l2.addElement("Spring");
	l2.addElement("YII");
	
	final JList<String> list2 = new JList<>(l2);
	list2.setBounds(100,200, 75,75);
	
	f.add(list1); f.add(list2); f.add(b); f.add(label);
	f.setSize(450,450);
	f.setLayout(null);
	
	b.addActionListener(new ActionListener() {
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			String data = "";
			if (!(list1.getSelectedIndex() < 0)) {
				data = "Programming language Selected: " + list1.getSelectedValue();
				label.setText(data);
			}
			if(!(list2.getSelectedIndex() < 0)){
				data += ", FrameWork Selected: ";
			for(Object frame :list2.getSelectedValues()){
				data += frame + " ";
			}
			}
			label.setText(data);
		}
	});
	
	f.setVisible(true);
	}
}
