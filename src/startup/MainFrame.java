package startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;

import gui.AskFlightNumberPanel;
import gui.AddFlightFrame;
import gui.AddPassengerFrame;
import gui.DisplayFlightFrame;
import gui.DisplayPassengerFrame;

public class MainFrame extends JFrame{

	/*
	 *  button to call add flight frame
	 */
	private JButton addFlight;
	
	/*
	 *  button to call add passenger frame
	 */
	private JButton addPassenger;
	
	/*
	 *  button to call display passenger frame
	 */
	private JButton showPassenger;
	
	/*
	 *  button to call display flight frame
	 */
	private JButton showFlight;
	
	/*
	 *  button to close frame
	 */
	private JButton close;
	
	/*
	 *  panel to ask a number and do further modification to the flight
	 */
	private JPanel handleFlight;
	
	/**
	 * the button use to call add flight frame
	 * @return chooseAddFlightButton a JButton with event to call add flight frame
	 */
	private JButton ButtonAddFlight(){
		JButton chooseAddFlightButton = new JButton();
		chooseAddFlightButton.setText("1 Add Flight to FlightSetAccess");
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new AddFlightFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddFlightButton.addActionListener(new showFrameOneListener());
		return chooseAddFlightButton;
	}
	
	/**
	 * the button use to call add passenger frame
	 * @return chooseAddPassengerButton a JButton with event to call add passenger frame
	 */
	private JButton ButtonAddPassenger(){
		JButton chooseAddPassengerButton = new JButton();
		chooseAddPassengerButton.setText("2 Add Passenger to PassengerSetAccess");
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new AddPassengerFrame();
		    	aFrame.setVisible(true);
		    }
		}
		chooseAddPassengerButton.addActionListener(new showFrameOneListener());
		return chooseAddPassengerButton;
	}
	
	/**
	 * the button use to call display passenger frame
	 * @return chooseAddPassengerButton a JButton with event to call add passenger frame
	 */
	private JButton ButtonDisplayPassenger(){
		JButton DisplayPassengerButton = new JButton();
		DisplayPassengerButton.setText("3 Display all Passenger in PassengerSetAccess");
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new DisplayPassengerFrame();
		    	aFrame.setVisible(true);
		    }
		}
		DisplayPassengerButton.addActionListener(new showFrameOneListener());
		return DisplayPassengerButton;
	}
	
	/**
	 * the button use to call display flight frame
	 * @return DisplayFlightButton a JButton with event to call display flight frame
	 */
	private JButton ButtonDisplayFlight(){
		JButton DisplayFlightButton = new JButton();
		DisplayFlightButton.setText("4 Display all Flight in FlightSetAccess");
		class showFrameOneListener implements ActionListener{
		    public void actionPerformed(ActionEvent event) {
		    	JFrame aFrame = new DisplayFlightFrame();
		    	aFrame.setVisible(true);
		    }
		}
		DisplayFlightButton.addActionListener(new showFrameOneListener());
		return DisplayFlightButton;
	}
	
	/**
	 * the button use to close frame
	 * @return CloseButton a JButton with event to close frame
	 */
	private JButton CloseButton(){
		JButton CloseButton = new JButton();
		CloseButton.setText("5 Close");
		CloseButton.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent event){
	    				dispose();
	    			}
	    		}
	    );
		return CloseButton;
	}
	 
	/**
	 * Construct the window for all 6 operation can be done.
	 */
	public MainFrame(){
		this.setLayout(new FlowLayout());
		addFlight = ButtonAddFlight();
		addPassenger = ButtonAddPassenger();
		showPassenger = ButtonDisplayPassenger();
		showFlight = ButtonDisplayFlight();
		close = CloseButton();
		handleFlight = new AskFlightNumberPanel();
		this.add(addFlight);
		this.add(addPassenger);
		this.add(showPassenger);
		this.add(showFlight);
		this.add(close);
		this.add(handleFlight);
		this.setTitle("Flight Reservation System");
		this.setSize(800,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static final long serialVersionUID = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame a = new MainFrame();
		a.setVisible(true);
	}


}
