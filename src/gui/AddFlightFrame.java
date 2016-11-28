package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import containers.FlightSetAccess;
import entities.Flight;

public class AddFlightFrame extends JFrame{
	
	/*
	 * The number of the flight being created.
	 */
	private int number;
	
	/*
	 * The width of the flight being created.
	 */
	private int width;
	
	/*
	 * The capacity of the flight being created.
	 */
	private int capacity;
	
	/*
	 * The field for input number in the frame of the window.
	 */
	private JTextField numberField;
	
	/*
	 * The field for input width in the frame of the window.
	 */
	private JTextField widthField;
	
	/*
	 * The field for input capacity in the frame of the window.
	 */
	private JTextField capacityField;
	
	/*
	 * The button for user to submit in the frame of the window.
	 */
	private JButton submitButton;
	
	/**
	 * Construct the window to add the flight with the 
	 * input number width and capacity.
	 */
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
		submitButton = SubmitButton();
		this.setTitle("Flight Creation Frame");
		this.add(numberLabel);
		this.add(numberField);
		this.add(widthLabel);
		this.add(widthField);
		this.add(capacityLabel);
		this.add(capacityField);
		this.add(submitButton);
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	/**
	 * the button use to add data and check input
	 * @return SubmitButton a JButton with event to check input and submit to data set
	 */
	private JButton SubmitButton(){
		JButton SubmitButton = new JButton();
		SubmitButton.setText("Submit!");
    	SubmitButton.addActionListener(
    		new ActionListener()
    		{
    			public void actionPerformed(ActionEvent event){
    				if(!(numberField.getText().matches("^-?\\d+$")) || !(widthField.getText().matches("^-?\\d+$")) || !(capacityField.getText().matches("^-?\\d+$")) ){
    					JFrame errorFrame = WarningFrame();
    					errorFrame.setVisible(true);
    				}
    				else {
    					number = Integer.valueOf(numberField.getText());
    					width = Integer.valueOf(widthField.getText());
    					capacity = Integer.valueOf(capacityField.getText());
    					if(width > capacity){
    						JFrame errorFrame = WarningFrame();
        					errorFrame.setVisible(true);
    					}
    					else{
    						Flight newFlight = new Flight(number,width,capacity);
    						if(FlightSetAccess.dictionary().containsValue(newFlight)){
    							JFrame errorFrame = WarningFrame();
    	    					errorFrame.setVisible(true);
    						}
    						else{
    							FlightSetAccess.dictionary().put(number, newFlight);
    							dispose();
    						}
    					}
    				}
    			}
    		}
    	);
    	return SubmitButton;
	}
	
	/**
	 * the frame used only when error occur
	 * @return warning the frame contain warning information
	 */
	private JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of Number, Width, and Capacity");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return warning;
	}
	
	public static final long serialVersionUID = 1;

}
