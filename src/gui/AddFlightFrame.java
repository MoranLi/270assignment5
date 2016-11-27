package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import containers.FlightSetAccess;
import entities.Flight;

public class AddFlightFrame extends JFrame implements ActionListener{
	
	private int number;
	
	private int width;
	
	private int capacity;
	
	private JTextField numberField;
	
	private JTextField widthField;
	
	private JTextField capacityField;
	
	private JButton submitButton;
    
    public void actionPerformed(ActionEvent event){
    	if(!(numberField.getText().matches("^-?\\d+$")) || !(widthField.getText().matches("^-?\\d+$")) || !(capacityField.getText().matches("^-?\\d+$")) ){
    		JFrame warning =WarningFrame();
 	    	warning.setVisible(true);
    	}
    	else {
    		number = Integer.valueOf(numberField.getText());
    		width = Integer.valueOf(widthField.getText());
    		capacity = Integer.valueOf(capacityField.getText());
    		if(width > capacity){
    			JFrame warning =WarningFrame();
 	    		warning.setVisible(true);
    		}
    		else{
    			Flight newFlight = new Flight(number,width,capacity);
    			if(FlightSetAccess.dictionary().containsValue(newFlight)){
    	    		JFrame warning =WarningFrame();
    	    		warning.setVisible(true);
    	    	}
    	    	else{
    	    		FlightSetAccess.dictionary().put(number, newFlight);
    	    		this.dispose();
    	    	}
    		}
    	}
    }
    
	private JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of Number, Width, and Capacity");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return warning;
	}
	
	public AddFlightFrame() {
		this.setLayout(new FlowLayout());
		numberField = new JTextField();
		numberField.setPreferredSize(new Dimension(200,25));
		JLabel numberLabel = new JLabel("Please enter Number of Flight");
		widthField = new JTextField();
		widthField.setPreferredSize(new Dimension(200,25));
		JLabel widthLabel = new JLabel("Please enter Width of Flight");
		capacityField = new JTextField();
		capacityField.setPreferredSize(new Dimension(200,25));
		JLabel capacityLabel = new JLabel("Please enter Capacity of Flight");
		submitButton = new JButton();
		submitButton.setText("Submit!");
		submitButton.addActionListener(this);
		this.setTitle("Flight Creation Frame");
		this.add(numberLabel);
		this.add(numberField);
		this.add(widthLabel);
		this.add(widthField);
		this.add(capacityLabel);
		this.add(capacityField);
		this.add(submitButton);
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddFlightFrame one = new AddFlightFrame();
		one.setVisible(true);
	}

}
