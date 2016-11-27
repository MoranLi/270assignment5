package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AskFlightNumberFrame extends JFrame implements ActionListener{
	
	private int number;
	
	private JTextField numberField;
	
	private JButton submitButton;
	
	public void actionPerformed(ActionEvent event){
    	while(!(numberField.getText().matches("^-?\\d+$"))){
    		JFrame warning = WarningFrame();
 	    	warning.setVisible(true);
    	}
    	number = Integer.valueOf(numberField.getText());
    	JFrame HandleFlightFrame= new HandleFlightFrame(number);
    	HandleFlightFrame.setVisible(true);
    	this.dispose();
    }
	
	private JFrame WarningFrame(){
		JFrame warning = new JFrame();
		warning.setTitle("You must make some mistake!");
		JLabel warningLabel = new JLabel("Please check your input of Number.");
		warning.add(warningLabel);
		warning.setSize(400,100);
		warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return warning;
	}
	
	public AskFlightNumberFrame(){
		numberField = new JTextField();
		numberField.setPreferredSize(new Dimension(200,25));
		JLabel numberLabel = new JLabel("Please enter Number of Flight");
		submitButton = new JButton();
		submitButton.setText("Submit!");
		submitButton.addActionListener(this);
		this.setTitle("Flight Creation Frame");
		this.setLayout(new FlowLayout());
		this.add(numberLabel);
		this.add(numberField);
		this.add(submitButton);
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
