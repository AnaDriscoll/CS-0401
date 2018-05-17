//Ana Driscoll
//CS0401, T/TH 1:00-2:15
//Created: 11/30/17
//Last modified: 12/1/17
//Assignment 4, Assig4
//Combines Voter, LoginPanel, and BallotPanel classes

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 

public class Assig4 implements LoginInterface, VoteInterface
{
	private JFrame theWindow; 
	private JLabel introWelcome; 
	private JButton introLogin; 
	private LoginPanel login; 
	private BallotPanel ballots; 
	private String voterFile; 
	private String ballotFile; 
	private Voter voter; 

	public Assig4(String vFilename, String bFilename)
	{
		voterFile = vFilename;
		ballotFile = bFilename; 
		
		theWindow = new JFrame("Assignment 4"); 
		theWindow.setLayout(new GridLayout(2, 1)); 
		
		introWelcome = new JLabel("Welcome to E-Vote!"); 
		introWelcome.setFont(new Font("TimesRoman", Font.BOLD, 60));
		introWelcome.setHorizontalAlignment(SwingConstants.CENTER); 
		theWindow.add(introWelcome); 
		
		introLogin = new JButton("Click to login");
		introLogin.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		IntroListener iListen = new IntroListener(); 
		introLogin.addActionListener(iListen); 
		theWindow.add(introLogin); 
		
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setVisible(true);	
		
		login = new LoginPanel(voterFile, Assig4.this); 
		ballots = new BallotPanel(ballotFile, Assig4.this); 
	}
	
	private class IntroListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //replace intro window with LoginPanel 
		{
			theWindow.remove(introLogin);
			theWindow.add(login); 
			theWindow.pack(); 
		}
	}
	
	public void setVoter(Voter newV) //called when ID number is entered in the LoginPanel
	{
		if(newV == null)
		{
			JOptionPane.showMessageDialog(theWindow, "Voter not found. Please enter a valid ID number."); 	
		}
		else if(newV.hasVoted())
		{
			JOptionPane.showMessageDialog(theWindow, "You have already voted and may not vote again."); 
		}
		else
		{
			voter = newV; 
			introWelcome.setText(newV.getName() + " please make your choices."); 
			theWindow.remove(login); //replace LoginPanel with BallotPanel
			ballots.resetBallots(); 
			theWindow.add(ballots); 
			theWindow.pack(); 
		}
	}
	
	public void voted() //called when "cast vote" button on BallotPanel is pressed
	{
		voter.vote(); 
		Voter.saveVoter(voterFile, voter); 
		
		introWelcome.setText("Welcome to E-Vote!"); //replace BallotPanel with intro window 
		theWindow.remove(ballots); 
		theWindow.add(introLogin); 
		theWindow.pack();
	} 
	
	public static void main(String[] args)
	{
		new Assig4(args[0], args[1]); 
	} 
}
	