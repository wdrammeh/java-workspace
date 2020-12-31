package gui.design;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Spinner {
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame("JSpinner Example");
		frame.setLocationRelativeTo(null);

		final JLabel indicatorLabel = new JLabel();
		indicatorLabel.setHorizontalAlignment(JLabel.CENTER);
		indicatorLabel.setSize(250,100);

		final SpinnerModel model = new SpinnerNumberModel(0, 0, 100, 1);

		final JSpinner spinner = new JSpinner(model);
		final JTextField textField = new JTextField(25);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField.getText().length() >= 3 || !Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_DELETE || e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
//					CourseAdditionDialog.this.getToolkit().beep();
					e.consume();
				} else {
					try {
						spinner.setValue((int) e.getKeyChar());
						System.out.println(e.getKeyChar());
					}catch (IllegalArgumentException illegal){

					}
				}
			}
		});

		spinner.addChangeListener(c -> {
			indicatorLabel.setText("Value : " + ((JSpinner)c.getSource()).getValue());
			textField.setText("");
			textField.setText(((JSpinner)c.getSource()).getValue().toString());
		});

		spinner.setEditor(textField);
		spinner.setBounds(100,100,50,30);
		frame.add(spinner);
		frame.add(indicatorLabel);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
