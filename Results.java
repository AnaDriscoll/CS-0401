//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 2, Results Class 
//Stores results of word guesses, writes them to text file
//Created 10/15/17, last modified 10/18/17

import java.util.*;
import java.io.*;  

public class Results 
{
	private PrintWriter pw; 
	private File results; 
	private Scanner scan; 
	int wins, losses, rounds; 
	
	public Results(String f) throws IOException
	{
		results = new File(f);  
		scan = new Scanner(results); 
		rounds = scan.nextInt();
		wins = scan.nextInt();
		losses = scan.nextInt();
	}
	
	public void won() throws IOException
	{
		wins++;
		rounds++;
	}
	
	public void lost() throws IOException 
	{
		losses++;
		rounds++; 
	} 
	
	public void save() throws IOException
	{
		pw = new PrintWriter(results);
		pw.println(rounds);
		pw.println(wins);
		pw.println(losses); 
		scan.close(); 
		pw.close(); 
	}
	
	public String toString() 
	{
		String s = new String(); 
		s = "Wins: " + wins + "\nLosses: " + losses + "\nTotal Rounds: " + rounds; 
		return s; 
		
	}
}
	