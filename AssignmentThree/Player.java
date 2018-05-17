//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 3, Player Class 
//Stores information for individual players of a game   
//Created 11/4/17, last modified 11/7/17

import java.util.*;
import java.io.*;

public class Player
{
	private String name; 
	private int rounds, wins, losses;
	
	public Player(String s, int r, int w, int l)
	{
		name = s; 
		rounds = r; 
		wins = w;
		losses = l; 
	}
	
	public Player(String s)
	{
		name = s;
		rounds = 0;
		wins = 0;
		losses = 0; 
	} 
	
	
	
	public void update(boolean won) //updates player info at the end of a round
	{
		rounds++; 
		if(won)
			wins++;
		else
			losses++; 
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getRounds()
	{
		return rounds; 
	} 
	
	public int getWins()
	{
		return wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	public String toString()
	{
		String s = new String(); 
		s = "\tName: " + name + "\n\tTotal rounds played: " + rounds + "\n\tTotal rounds won: " +
		wins + "\n\tTotal rounds lost: " + losses + "\n"; 
		return s; 
	}
} 
	
	