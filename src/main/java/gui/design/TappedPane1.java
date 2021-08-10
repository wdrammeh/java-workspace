package gui.design;

import javax.swing.*;

public class TappedPane1 {
//	JFrame f;

	public static void main(String[] args) {
		new TappedPane1();
	}

	public TappedPane1(){
		final JTextArea ta = new JTextArea(200,200);

		final JPanel p1 = new JPanel();
		p1.add(ta);

		final JPanel p2 = new JPanel();

		final JPanel p3 = new JPanel();

		final JTabbedPane tp = new JTabbedPane();
		tp.setBounds(50,50,200,200);
		tp.add("main",p1);//good huh! title and its corresponding component, especially, a Panel
		tp.add("visit",p2);
		tp.add("help",p3);

		tp.setSelectedIndex(2);

		final JFrame f = new JFrame();
		f.setSize(400,400);
		f.setLayout(null);
		f.add(tp);
		f.setVisible(true);

		// In this case the look and feel renders the title for the tab.
		tp.addTab("Tab", new JPanel());
		// In this case the custom component is responsible for rendering the
		// title of the tab.
		tp.addTab(null, new JPanel());
		tp.setTabComponentAt(0, new JLabel("Tab"));

	}
}
