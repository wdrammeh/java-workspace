package gui.design.key_binding;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;

public class ScrollTextFieldAction extends TextAction {
	private JTextArea textArea = new JTextArea();
	
	public ScrollTextFieldAction(JTextArea textArea) {
		super("done");
		this.textArea = textArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String credentials = getTextComponent(e).getText();
		if(getTextComponent(e).getName().equals("Full Name")){
			textArea.setText("Name is: "+credentials);
		}else if(getTextComponent(e).getName().equals("Address1")){
			if(textArea.getText().indexOf("Address 1") == -1)
				textArea.setText(textArea.getText()+"\n"+"Address 1: "+credentials);
		}else if(getTextComponent(e).getName().equals("Address2")){
			if(textArea.getText().indexOf("Address 2") == -1)
				textArea.setText(textArea.getText()+"\n"+"Address 2: "+credentials);
		}else if(getTextComponent(e).getName().equals("Pin")){
			if(textArea.getText().indexOf("Pin") == -1)
				textArea.setText(textArea.getText()+"\n"+"Pin: "+credentials);
		}else if(getTextComponent(e).getName().equals("Phone No")){
			if(textArea.getText().indexOf("Phone") == -1)
				textArea.setText(textArea.getText()+"\n"+"Phone No: "+credentials);
		}else if(getTextComponent(e).getName().equals("Email Id")){
			if(textArea.getText().indexOf("Email") == -1)
				textArea.setText(textArea.getText()+"\n"+"Email Id: "+credentials);
		}
	}

}
