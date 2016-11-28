package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class AskFlightNumberPanel extends JPanel{
	
	/*
	 * the number of flight used to search
	 */
	private int number;
	
	/*
	 * the text field handle number of flight used to search
	 */
	private JTextField numberField;
	
	/**
	 * Construct the window to and input a number to call Handle flight frame
	 */
	public AskFlightNumberPanel(){
		numberField = NumberField();
		numberField.setPreferredSize(new Dimension(200,25));
		JLabel numberLabel = new JLabel("Please enter Number of Flight");
		this.setLayout(new FlowLayout());
		this.add(numberLabel);
		this.add(numberField);
		this.setSize(getPreferredSize());
	}
	
	
	/**
	 * the textField use to add number and check input
	 * @return NumberField a JTextField with event to check input and submit to handle flight frame
	 */
	private JTextField NumberField(){
		JTextField NumberField = new JTextField();
		NumberField.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
				    	if(!(numberField.getText().matches("^-?\\d+$"))){
				    		JFrame errorFrame = WarningFrame();
				    		errorFrame.setVisible(true);
				    	}
				    	else{
				    		number = Integer.valueOf(numberField.getText());
				    		JFrame HandleFlightFrame= new HandleFlightFrame(number);
				    		HandleFlightFrame.setVisible(true);
				    	}
				    }
				}
		);
		return NumberField;
	}
	
	/**
	 * the frame used only when error occur
	 * @return warning the frame contain warning information
	 */
	private JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of Number");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
		return warning;
	}
	
	public static final long serialVersionUID = 1;
	
}
