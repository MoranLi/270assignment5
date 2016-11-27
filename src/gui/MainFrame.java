package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


import javax.swing.*;

import containers.FlightSetAccess;
import entities.Flight;

public class MainFrame extends JFrame implements ActionListener{
	
	private JButton addFlight;
	
	private JButton addPassenger;
	
	private JButton showPassenger;
	
	private JButton showFlight;
	
	private JButton close;
	
	private JButton handleFlight;
	
	
	private JButton ButtonAddFlight(){
		JButton chooseAddFlightButton = new JButton();
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new AddFlightFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	private JButton ButtonAddPassenger(){
		JButton chooseAddFlightButton = new JButton();
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new AddPassengerFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	private JButton ButtonDisplayPassenger(){
		JButton chooseAddFlightButton = new JButton();
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new DisplayPassengerFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	private JButton ButtonDisplayFlight(){
		JButton chooseAddFlightButton = new JButton();
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new DisplayFlightFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	
	private JButton ButtonHandleFlight(){
		JButton chooseAddFlightButton = new JButton();
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new AskFlightNumberFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	 public void actionPerformed(ActionEvent event){
		 this.dispose();
	 }
	
	public MainFrame(){
		this.setLayout(new FlowLayout());
		addFlight = ButtonAddFlight();
		addFlight.setText("1");
		addPassenger = ButtonAddPassenger();
		addPassenger.setText("2");
		showPassenger = ButtonDisplayPassenger();
		showPassenger.setText("3");;
		showFlight = ButtonDisplayFlight();
		showFlight.setText("4");
		close = new JButton();
		close.addActionListener(this);
		close.setText("5");
		handleFlight = ButtonHandleFlight();
		handleFlight.setText("6");
		this.add(addFlight);
		this.add(addPassenger);
		this.add(showPassenger);
		this.add(showFlight);
		this.add(close);
		this.add(handleFlight);
		this.setTitle("Flight Reservation System");
		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame a = new MainFrame();
		a.setVisible(true);
	}

}
