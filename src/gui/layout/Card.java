package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the card layout on a panel.
 * A very useful layout that allows flipping amongst the cards,
 * and shows one card at a time.
 * Use the next() to flip to the next card on the layout.
 */
public class Card extends JFrame {

	public static void main(String[] args) {
		final CardLayout cardLayout = new CardLayout(0, 0);
		final JPanel cardPanel = new JPanel();

		final JButton button1 = new JButton("Show Component1");
		button1.addActionListener(e-> cardLayout.show(cardPanel, "component1"));
		final JButton button2 = new JButton("Show Component2");
		button2.addActionListener(e-> cardLayout.show(cardPanel, "component2"));

		final JPanel topPanel = new JPanel();
		topPanel.add(button1);
		topPanel.add(button2);

		final Component component1 = new JLabel("This is component 1");
		component1.setFont(new Font("Arial", Font.BOLD, 20));

		final Component component2 = new JLabel("This is component 2");
		component2.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 15));
		component2.setForeground(Color.BLUE);

		cardPanel.setLayout(cardLayout);
		cardLayout.addLayoutComponent(cardPanel.add(component1), "component1");
		cardLayout.addLayoutComponent(cardPanel.add(component2), "component2");

		final JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(500, 300));
		jPanel.setLayout(new BorderLayout(5,10));
		jPanel.add(topPanel, BorderLayout.PAGE_START);
		jPanel.add(cardPanel, BorderLayout.CENTER);

		MFrame.display("Card Layout", jPanel);
	}

}
