package gui;

import javax.swing.*;
import commands.DisplayPassengersCommand;


public class DisplayPassengerFrame extends JFrame{

	/**
	 * Construct the window to display all Passenger information in Passenger Set
	 */
	public DisplayPassengerFrame(){
		JTextArea allPassenger = new JTextArea();
		allPassenger.setText(new DisplayPassengersCommand().getPassengersString());
		allPassenger.setEditable(false);
		JScrollPane passengerPane = new JScrollPane(allPassenger);
		this.add(passengerPane);
		this.setSize(getPreferredSize());
		this.setTitle("All Passenger Information");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static final long serialVersionUID = 1;

}
