package gui;

import javax.swing.*;
import commands.DisplayFlightsCommand;


public class DisplayFlightFrame extends JFrame{

	public DisplayFlightFrame(){
		JTextField allFlight = new JTextField();
		allFlight.setText(new DisplayFlightsCommand().getFlightsString());
		allFlight.setEditable(false);
		JScrollPane FlightPane = new JScrollPane(allFlight);
		this.add(FlightPane);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayFlightFrame one = new DisplayFlightFrame();
		one.setVisible(true);
	}

	
}
