//Ana Driscoll
//CS0401, T/TH 1:00-2:15
//Created: 11/25/17
//Last modified: 11/28/17
//Assignment 4, Voter Class
//Can store or retrieve/save information from a file for an individual voter

import java.util.*;
import java.io.*; 
import java.nio.file.Files;

public class Voter
{
	private String voterID;
	private String voterName;
	private boolean voted; 
	
	public Voter(String id, String name, boolean vote)
	{
		voterID = id;
		voterName = name;
		voted = vote; 
	}
	
	public String getId()
	{
		return voterID;
	}
	
	public String getName()
	{
		return voterName;
	}
	
	public boolean hasVoted()
	{
		return voted;
	}
	
	public void vote()
	{
		voted = true;
	}
	
	public String toString()
	{
		String s = "ID: " + voterID + "\nName: " + voterName + "\nVoted? " + voted;
		return s; 
	}
	
	public static Voter getVoter(String file, String id) 
	{
		try
		{
			File voters = new File(file);  
			Scanner inScan = new Scanner(voters); 
			while(inScan.hasNext()) 
			{
				String tempVoter = inScan.nextLine(); //read voter info from the file
				String[] test = tempVoter.split(":"); 
				if(test[0].compareToIgnoreCase(id) == 0) //if file ID number matches the ID number given by user
				{
					String newID = test[0];
					String newName = test[1];
					String newVote = test[2];
					boolean voteStatus = false; 
					if(newVote.compareToIgnoreCase("true") == 0) //if string indicating vote status reads "true"
						voteStatus = true;
					Voter newVoter = new Voter(newID, newName, voteStatus); //create new Voter with info from file 
					inScan.close();
					return newVoter;
				}
			}
			inScan.close(); 
			return null; //if no match found in file, return null 
		}
		
		catch(IOException e) 
		{
			return null;
		}		
	}
	
	public static void saveVoter(String file, Voter v) 
	{
		try
		{
			File tempFile = new File("temp.txt"); //create temp file to store info as it is read
			File oldFile = new File(file); 
			PrintWriter pw = new PrintWriter(tempFile); //PrintWriter will write info to temp file 
			Scanner inScan = new Scanner(oldFile); 
			while(inScan.hasNext())
			{
				String voterInfo = inScan.nextLine(); 
				String[] data = voterInfo.split(":"); 
				
				if(data[0].compareToIgnoreCase(v.getId()) == 0) //if given Voter's ID matches ID from file 
				{
					pw.println(v.getId() + ":" + v.getName() + ":" + v.hasVoted()); //write Voter's info
				}
				
				else 
				{
					pw.println(data[0] + ":" + data[1] + ":" + data[2]); //write info from original file
				}
				
			}
			
			inScan.close(); 
			pw.close(); 
			oldFile.delete();
			tempFile.renameTo(oldFile);
		
		}
		
		catch(IOException e) 
		{
		} 
	}
		
} 