//Ana Driscoll
//CS0401, T/TH 1:00-2:15
//Created: 11/28/17
//Last modified: 12/1/17
//Assignment 4, BallotPanel
//Creates a JPanel displaying various ballots

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 

public class BallotPanel extends JPanel
{
	private ArrayList<Ballot> ballots; 
	private JButton castVote; 
	private File ballotInfo; 
	private VoteInterface VI; 
	
	public BallotPanel(String filename, VoteInterface v)
	{
		try
		{
			VI = v; 
		
			ballotInfo = new File(filename);
			Scanner inScan = new Scanner(ballotInfo); 
		
			String ballotNumber = inScan.nextLine(); 
			int numBallots = Integer.parseInt(ballotNumber); 
		
			String[] data = new String[numBallots]; //each String is ALL the data for a given ballot 
			ballots = new ArrayList<Ballot>(); 
			
			for(int i = 0; i < numBallots; i++)
			{
				String temp = inScan.nextLine(); //String temp is equivalent to a single ballot
				data[i] = temp; 
			}
			inScan.close(); 	
			
			for(int j = 0; j < numBallots; j++) //split data for ballot into separate strings so that Ballots can be initialized
			{
				String[] ballotData = data[j].split(":"); 
				String candidateList = ballotData[2]; 
				String[] candidates = ballotData[2].split(","); 
				Ballot temp = new Ballot(ballotData[0], ballotData[1], candidates);
				ballots.add(temp); //add individual ballots to array of ballots
			}
			
			setLayout(new GridLayout(1, ballots.size() + 1));  //room for all ballots + cast vote button
			for(int i = 0; i < ballots.size(); i++)
			{
				add(ballots.get(i)); 
			}
		
			VoteListener buttonListener = new VoteListener();
			castVote = new JButton("Cast your vote"); 
			castVote.setFont(new Font("TimesRoman", Font.PLAIN, 60));
			castVote.addActionListener(buttonListener);
			add(castVote); 	
		}
		catch(IOException e)
		{
		}
	}
	
	public void resetBallots()
	{
		for(int i = 0; i < ballots.size(); i++)
			ballots.get(i).reset(); 
	}
	
	private class VoteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane confirm = new JOptionPane(); 
			int choice = confirm.showConfirmDialog(null, "Confirm vote?", "Confirm vote?", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION)
			{
				VI.voted(); //calls voted() method from VoteInterface, program using BallotPanel must implement VoteInterface
				for(int i = 0; i < ballots.size(); i++)
					ballots.get(i).update(); //update results file for each ballot
			}
			
		}
	} 
} 
		
			