package gui.design_plus.key_binding;

import javax.swing.*;
import javax.swing.text.Keymap;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SwingKeyMapExampleFrame extends JFrame  {
	private JTextField firstName = new JTextField(15);
	private JTextField middleName = new JTextField(15);
	private JTextField lastName = new JTextField(15);
	private JTextField fullName = new JTextField(60);
	private JTextField address1 = new JTextField(50);
	private JTextField address2 = new JTextField(20);
	private JTextField pin = new JTextField(6);
	private JTextField phoneNo = new JTextField(10);
	private JTextField emailId = new JTextField(30);
	private JTextArea textArea = new JTextArea(40, 50);
	private JScrollPane scrollText = new JScrollPane(textArea);
	
	public SwingKeyMapExampleFrame(){
		setSize(500,600);
		setTitle("JTextField Demo");

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(250);
		
		textArea.setEditable(false);
		
		splitPane.setLeftComponent(scrollText);
		add(splitPane);
		
		JPanel panel = new JPanel(new GridLayout(0,1));
		
		splitPane.setRightComponent(panel);
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel fullNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel contactsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		addNameControls(namePanel,fullNamePanel);
		addAddressControls(addressPanel);
		addContactsControls(contactsPanel);
		
		panel.add(namePanel);
		panel.add(fullNamePanel);
		panel.add(addressPanel);
		panel.add(contactsPanel);
		panel.add(submitPanel);
	}
	
	private void addNameControls(JPanel namePanel, JPanel fullNamePanel){
		JLabel fName = new JLabel("First name: ");
		namePanel.add(fName);
		
		firstName.setBackground(Color.YELLOW);
		firstName.setName("First Name");
		Keymap firstNameMap = firstName.getKeymap();
		KeyStroke altF1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.SHIFT_MASK);
		firstNameMap.addActionForKeyStroke(altF1, new TextFieldAction(fullName));
				
		namePanel.add(firstName);
		
		JLabel mName = new JLabel("Middle name: ");
		namePanel.add(mName);
				
		middleName.setBackground(Color.YELLOW);
		middleName.setName("Middle Name");
		namePanel.add(middleName);
		
		JLabel lName = new JLabel("Last name: ");
		namePanel.add(lName);
		
		lastName.setBackground(Color.YELLOW);
		lastName.setName("Last Name");
		namePanel.add(lastName);
		
		addFullNameControls(fullNamePanel);
	}
	
	private void addFullNameControls(JPanel fullNamePanel){
		JLabel fullNameTxt = new JLabel("Full name: ");
		fullNamePanel.add(fullNameTxt);
		
		fullName.setEditable(false);
		fullName.setName("Full Name");
		Keymap fullNameMap = fullName.getKeymap();
		KeyStroke altF3 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.SHIFT_MASK|InputEvent.ALT_MASK);
		fullNameMap.addActionForKeyStroke(altF3, new ScrollTextFieldAction(textArea));
				
		fullNamePanel.add(fullName);
	}
	
	private void addAddressControls(JPanel addressPanel){
		JLabel address1Lbl = new JLabel("Address1: ");
		addressPanel.add(address1Lbl);
		address1.setName("Address1");
		addressPanel.add(address1);
		
		JLabel addressLb2 = new JLabel("Address 2: ");
		addressPanel.add(addressLb2);
		address2.setName("Address2");
		addressPanel.add(address2);
		
		JLabel addressLb3 = new JLabel("Pin: ");
		addressPanel.add(addressLb3);
		pin.setName("Pin");
		addressPanel.add(pin);
	}
	
	private void addContactsControls(JPanel contactPanel){
		JLabel phone = new JLabel("Cell No: ");
		contactPanel.add(phone);
		phoneNo.setName("Phone No");
		contactPanel.add(phoneNo);
		
		JLabel email = new JLabel("Email Id: ");
		contactPanel.add(email);
		emailId.setName("Email Id");				
		contactPanel.add(emailId);
	}

}
