package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import containers.PassengerSetAccess;
import entities.Passenger;

public class AddPassengerFrame extends JFrame implements ActionListener{
	
	private String name;
	
	private String telPhone;
	
	private JTextField nameField;
	
	private JTextField telPhoneField;
	
	private JButton submitButton;
    
    public void actionPerformed(ActionEvent event){
    	name = nameField.getText();
    	telPhone = telPhoneField.getText();
    	if(name == null || telPhone == null || name == "" || telPhone == ""){
    		JFrame warning =WarningFrame();
    	    warning.setVisible(true);
    	}
    	else{
    		Passenger newPassenger = new Passenger(name,telPhone);
    		if(PassengerSetAccess.dictionary().containsValue(newPassenger)){
    			JFrame warning =WarningFrame();
    			warning.setVisible(true);
    		}
    		else{
    			PassengerSetAccess.dictionary().put(name, newPassenger);
    		}
    	}
    }
  
	protected JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of name and telPhone");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return warning;
	}
	
	public AddPassengerFrame() {
		this.setLayout(new FlowLayout());
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(200,25));
		JLabel nameLabel = new JLabel("Please enter name of Passenger");
		telPhoneField = new JTextField();
		telPhoneField.setPreferredSize(new Dimension(200,25));
		JLabel telPhoneLabel = new JLabel("Please enter telPhone of Passenger");
		submitButton = new JButton();
		submitButton.setText("Submit!");
		submitButton.addActionListener(this);
		this.setTitle("Passenger Creation Frame");
		this.add(nameLabel);
		this.add(nameField);
		this.add(telPhoneLabel);
		this.add(telPhoneField);
		this.add(submitButton);
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPassengerFrame one = new AddPassengerFrame();
		one.setVisible(true);
	}

}

