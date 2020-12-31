package gui.design_plus.key_binding;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;

public class TextFieldAction extends TextAction {
	private JTextField fullName;


	public void actionPerformed(ActionEvent arg0) {
		String text = getTextComponent(arg0).getText();
		if("First Name".equalsIgnoreCase(getTextComponent(arg0).getName())){
			if(text != null && text.length()> 0)
				if(fullName.getText() == null || fullName.getText().length() == 0){
					fullName.setText(text);
				}else{
					fullName.setText(text+" "+fullName.getText());
				}
		} else if("Middle Name".equalsIgnoreCase(getTextComponent(arg0).getName())){
			if(text != null && text.length() > 0)
				if(fullName.getText() == null || fullName.getText().length() == 0){
					fullName.setText(text);
				}else if(fullName.getText().indexOf(" ") == -1){
					fullName.setText(fullName.getText()+" "+text);
				}else{
					String currentContent = fullName.getText();
					currentContent = currentContent.substring(0,currentContent.indexOf(" "))+" "+text+currentContent.substring(currentContent.lastIndexOf(" "));
					fullName.setText(currentContent);
				}
		}else{
			if(text != null && text.length()> 0)
				if(fullName.getText() == null || fullName.getText().length() == 0){
					fullName.setText(text);
				}else{
					String currentContent = fullName.getText();
					fullName.setText(currentContent+" "+text);
				}
		}
	}
	
	public TextFieldAction(JTextField fullName) {
		super("Convert to upper case");
		this.fullName = fullName;
	}

}
