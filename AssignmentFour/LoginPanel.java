//Ana Driscoll
//CS0401, T/TH 1:00-2:15
//Created: 11/25/17
//Last modified: 12/1/17
//Assignment 4, LoginPanel
//Panel allowing user to search for a voter by ID number

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 

public class LoginPanel extends JPanel
{ 
	private JPanel middlePanel; //will store JTextField and its label 
	private JLabel title;
	private JLabel voterInfo; 
	private JTextField voterId; 
	private JButton submit; 
	private String voterFile; 
	private LoginInterface lf; 

	public LoginPanel(String file, LoginInterface L) 
	{
		voterFile = file;
		
		lf = L; 
		
		setLayout(new GridLayout(3, 1)); 
		
		title = new JLabel("Please log into the site");
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		title.setFont(new Font("TimesRoman", Font.BOLD, 72));
		add(title); 
			
		middlePanel = new JPanel(); 
		middlePanel.setLayout(new FlowLayout()); 
		voterInfo = new JLabel("Voter ID: "); 
		voterInfo.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		voterId = new JTextField(10); 
		voterId.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		middlePanel.add(voterInfo); 
		middlePanel.add(voterId); 
		
		add(middlePanel); 
			
		submit = new JButton("Submit");
		submit.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		IDListener theListener = new IDListener(); 
		submit.addActionListener(theListener); 
		add(submit); 			
	}
	
	private class IDListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String testId = voterId.getText(); 
			Voter v = Voter.getVoter(voterFile, testId); 
			lf.setVoter(v); //call to method in LoginInterface, program using this class must implement the interface
		}
	} 
	
}