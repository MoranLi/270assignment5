package gui;

import javax.swing.*;
import commands.DisplayPassengersCommand;


public class DisplayPassengerFrame extends JFrame{

	public DisplayPassengerFrame(){
		JTextField allPassenger = new JTextField();
		allPassenger.setText(new DisplayPassengersCommand().getPassengersString());
		allPassenger.setEditable(false);
		JScrollPane passengerPane = new JScrollPane(allPassenger);
		this.add(passengerPane);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayPassengerFrame one = new DisplayPassengerFrame();
		one.setVisible(true);
	}

}
