package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import containers.PassengerSetAccess;
import entities.Passenger;

public class AddPassengerFrame extends JFrame{
	
	/*
	 * the name of passenger will add
	 */
	private String name;
	
	/*
	 * the phoneNumber of passenger will add
	 */
	private String telPhone;
	
	/*
	 * the text field handle name of passenger will add
	 */
	private JTextField nameField;
	
	/*
	 * the text field handle phoneNumber of passenger will add
	 */
	private JTextField telPhoneField;
	
	/**
	 * Construct the window to add the passenger with the 
	 * input name and TelPhone.
	 */
	public AddPassengerFrame() {
		this.setLayout(new FlowLayout());
		nameField = NameField();
		nameField.setPreferredSize(new Dimension(200,25));
		JLabel nameLabel = new JLabel("Please enter name of Passenger");
		telPhoneField = TelField();
		telPhoneField.setPreferredSize(new Dimension(200,25));
		JLabel telPhoneLabel = new JLabel("Please enter telPhone of Passenger");
		this.setTitle("Passenger Creation Frame");
		this.add(nameLabel);
		this.add(nameField);
		this.add(telPhoneLabel);
		this.add(telPhoneField);
		this.setSize(300,175);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * the textField use to add name and check input
	 * @return NameField a JTextField with event to check input and submit to data set
	 */
	private JTextField NameField(){
		JTextField NameField = new JTextField();
		NameField.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
				    	name = nameField.getText();
				    	telPhone = telPhoneField.getText();
				    	if(nameField.getText().isEmpty()|| telPhoneField.getText().isEmpty()){
				    		JFrame errorFrame = WarningFrame();
        					errorFrame.setVisible(true);
				    	}
				    	else{
				    		Passenger newPassenger = new Passenger(name,telPhone);
				    		if(PassengerSetAccess.dictionary().containsValue(newPassenger)){
				    			JFrame errorFrame = WarningFrame();
	        					errorFrame.setVisible(true);
				    		}
				    		else{
				    			PassengerSetAccess.dictionary().put(name, newPassenger);
				    			nameField.setText("");
				    			telPhoneField.setText("");
				    		}
				    	}
				    }
				}
		);
		return NameField;
	}
	
	/**
	 * the textField use to add telPhone and check input
	 * @return TelField a JTextField with event to check input and submit to data set
	 */
	private JTextField TelField(){
		JTextField TelField = new JTextField();
		TelField.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
				    	name = nameField.getText();
				    	telPhone = telPhoneField.getText();
				    	if(nameField.getText().isEmpty()|| telPhoneField.getText().isEmpty()){
				    		JFrame errorFrame = WarningFrame();
        					errorFrame.setVisible(true);
				    	}
				    	else{
				    		Passenger newPassenger = new Passenger(name,telPhone);
				    		if(PassengerSetAccess.dictionary().containsValue(newPassenger)){
				    			JFrame errorFrame = WarningFrame();
	        					errorFrame.setVisible(true);
				    		}
				    		else{
				    			PassengerSetAccess.dictionary().put(name, newPassenger);
				    			nameField.setText("");
				    			telPhoneField.setText("");
				    		}
				    	}
				    }
				}
		);
		return TelField;
	}
	
	/**
	 * the frame used only when error occur
	 * @return warning the frame contain warning information
	 */
	private JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of name and telPhone");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return warning;
	}

	public static final long serialVersionUID = 1;

}

