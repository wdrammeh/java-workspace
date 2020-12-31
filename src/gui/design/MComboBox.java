package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MComboBox {

	public static void main(String[] args) {
		final String[] options = new String[]{"Java", "Python", "C", "C#"};
		final JComboBox<String> comboBox = new JComboBox<>(options);

		final JLabel label = new JLabel(String.valueOf(comboBox.getSelectedItem()));
		label.setFont(new Font("Courier", Font.BOLD, 20));

		comboBox.addActionListener(e-> label.setText(String.valueOf(comboBox.getSelectedItem())));

		final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setPreferredSize(new Dimension(300, 200));
		panel.add(new JLabel("Select:"));
		panel.add(comboBox);
		panel.add(label);

		MFrame.display("ComboBox", panel);
	}

}
