package gui;

import javax.swing.*;
import commands.DisplayFlightsCommand;


public class DisplayFlightFrame extends JFrame{

	/**
	 * Construct the window to display all Flight information in Flight Set
	 */
	public DisplayFlightFrame(){
		JTextArea allFlight = new JTextArea();
		allFlight.setText(new DisplayFlightsCommand().getFlightsString());
		allFlight.setEditable(false);
		JScrollPane FlightPane = new JScrollPane(allFlight);
		this.add(FlightPane);
		this.setSize(getPreferredSize());
		this.setTitle("All Flight Information");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static final long serialVersionUID = 1;
	
}
