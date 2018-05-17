//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 3, PlayerList Class 
//Maintains a database of players, reads/writes information to file  
//Created 11/4/17, last modified 11/7/17

import java.util.*;
import java.io.*;
import java.text.*;

public class PlayerList 
{
	private ArrayList<Player> thePlayers;
	private int numPlayers; 
	private int totalR, totalW, totalL; //total rounds, wins, losses for all players combined
	private Scanner playerScan; 
	private File playerInfo; 
	
	public PlayerList(String file) throws IOException
	{
		playerInfo = new File(file); 
		playerScan = new Scanner(playerInfo); 
		thePlayers = new ArrayList<Player>();
		
		totalR = 0;
		totalW = 0;
		totalL = 0; 
		
		while(playerScan.hasNext())
		{
			String name = playerScan.next(); 
			int rounds = playerScan.nextInt(); 
			totalR += rounds;
			int wins = playerScan.nextInt();
			totalW += wins; 
			int losses = playerScan.nextInt(); 
			totalL += losses; 
			Player temp = new Player(name, rounds, wins, losses); 
			thePlayers.add(temp); 
		}
		
		numPlayers = thePlayers.size(); 
		playerScan.close(); 
	}
	
	public void addPlayer(Player p)
	{
		thePlayers.add(p);
		numPlayers++; 
	} 
	
	public Player removePlayer(String n)
	{
		for(int i = 0; i < thePlayers.size(); i++)
		{
			String test = thePlayers.get(i).getName(); 
			if(test.compareToIgnoreCase(n) == 0)
			{
				Player temp = thePlayers.get(i);
				thePlayers.remove(thePlayers.get(i)); 
				numPlayers--;
				
				return temp;
			}
		}
		
		return null; 
	}
	
	public Player getPlayer(String n)
	{
		for(int i = 0; i < thePlayers.size(); i++)
		{
			String test = thePlayers.get(i).getName(); 
			if(test.compareToIgnoreCase(n) == 0)
				return thePlayers.get(i);
		}
		
		return null; 
	}
	
	public String toString()
	{
		double percent = (double)totalW / (double)totalR * 100; 
		DecimalFormat f = new DecimalFormat("#.00"); 
		String percentF = f.format(percent);
		String s = new String();
		s = "Total Players: " + numPlayers +
		"\n\tTotal Rounds Played: " + totalR + "\n\tTotal Rounds Won: " + totalW +
		"\n\tTotal Rounds Lost: " + totalL + "\n\tPct of Rounds Won: " + percentF;
		return s; 
	}
	
	public String toStringAdmin()
	{
		String tot = new String();
		double percent = (double)totalW / (double)totalR * 100;
		DecimalFormat f = new DecimalFormat("#.00"); 
		String percentF = f.format(percent);
		tot = "Total Players: " + numPlayers +
		"\n\tTotal Rounds Played: " + totalR + "\n\tTotal Rounds Won: " + totalW +
		"\n\tTotal Rounds Lost: " + totalL + "\n\tPct of Rounds Won: " + percentF + "\n";
		
		StringBuilder play = new StringBuilder("");
		for(int i = 0; i < thePlayers.size(); i++)
		{
			play.append(thePlayers.get(i).toString() + "\n");
		}
		
		String players = play.toString(); 
		String admin = new String(tot + "\n" + players); 
		return admin; 
		
	}
	
	public void saveList() throws IOException
	{
		PrintWriter pw = new PrintWriter(playerInfo);
		for(int i = 0; i < thePlayers.size(); i++)
		{
			String n = thePlayers.get(i).getName();
			int r = thePlayers.get(i).getRounds();
			int w = thePlayers.get(i).getWins();
			int l = thePlayers.get(i).getLosses();
			pw.println(n + " " + r + " " + w + " " + l);
		}
		
		playerScan.close(); 
		pw.close(); 
	} 
}			