//Ana Driscoll
//CS0401, T/TH 1:00-2:15
//Created: 11/28/17
//Last modified: 12/1/17
//Assignment 4, Ballot
//Creates a JPanel corresponding to an individual ballot

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 

public class Ballot extends JPanel
{
	private String ballotId; 
	private JLabel title; 
	private ArrayList<JButton> buttons; 
	private JPanel buttonHolder; 
	private File results; 
	private String candidateChosen; 
	
	public Ballot(String b, String t, String[] c)
	{
		try
		{
			ballotId = b;
			
			candidateChosen = new String(" "); //indicates that no choice has been made
		
			VoteListener theListener = new VoteListener();
		
			buttons = new ArrayList<JButton>(); 
			for(int i = 0; i < c.length; i++)
			{
				JButton temp = new JButton(c[i]); //title of JButton comes from array of Strings given in parameter list 
				temp.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				temp.addActionListener(theListener); 
				buttons.add(temp); 
			}
			
			setLayout(new GridLayout(2, 1)); 
			buttonHolder = new JPanel(); 
			buttonHolder.setLayout(new GridLayout(buttons.size(), 1));  //Panel holding buttons has a section for each button
		
			title = new JLabel(t);
			title.setFont(new Font("TimesRoman", Font.BOLD, 42));
			title.setForeground(Color.BLUE); 
			title.setHorizontalAlignment(SwingConstants.CENTER); 
			add(title); 
			
			for(int i = 0; i < buttons.size(); i++) //add buttons to buttonHolder JPanel 
			{
				buttons.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				buttonHolder.add(buttons.get(i)); 
			}
			
			add(buttonHolder); 
			
			results = new File(ballotId +".txt"); //creates results file with name identical to ballot ID number 
			PrintWriter pw = new PrintWriter(results); 
		
			for(int i = 0; i < buttons.size(); i++) //fills results file 
				pw.println(buttons.get(i).getText() + ":0"); 
			pw.close();
		}
		catch(IOException e)
		{
		}
	}
	
	public void update()
	{
		try
		{
			File tempFile = new File("temp.txt"); 
			PrintWriter pw = new PrintWriter(tempFile); 
			Scanner inScan = new Scanner(results); 
			while(inScan.hasNext())
			{
				String temp = inScan.nextLine(); 
				String [] tempData = temp.split(":"); //Splits ballot info given in line of file into its separate components
				int votes = Integer.parseInt(tempData[1]); 
				if(tempData[0].equals(candidateChosen)) //if choice name is the same as the candidate the voter chose 
					votes++; 
				pw.println(tempData[0] + ":" + votes); 
			}
			pw.close(); 
			inScan.close(); 
			results.delete(); 
			tempFile.renameTo(results); 	
		}
		catch(IOException e)
		{
		}
	}
			
	public void reset()
	{
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).setForeground(Color.BLACK); 
		candidateChosen = " "; //no candidate has been chosen 
	}
	
	private class VoteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			JButton vote = (JButton) e.getSource(); 
			if(candidateChosen.equals(vote.getText())) ////undoes selection if user re-clicks selected button
			{
				vote.setForeground(Color.BLACK); 
				candidateChosen = " "; 
			}
			else if(!candidateChosen.equals(vote.getText()) && !candidateChosen.equals(" ")) //if user is changing selection
			{
				reset(); //sets buttons not chosen to black 
				candidateChosen = vote.getText();
				vote.setForeground(Color.RED);
			}
			else //if user is making selection, but is not changing a choice
			{
				candidateChosen = vote.getText(); 
				vote.setForeground(Color.RED); 
			} 
			
		}
		
	}
}