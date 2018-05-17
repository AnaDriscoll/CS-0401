//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 2, Scramble Class 
//Retrieves and scrambles words from a file 
//Created 10/15/17, last modified 10/18/17


import java.util.*;
import java.io.*;  

public class Scramble 
{
	private File words;
	private Scanner wordsIn; 
	private StringBuilder realWord, scrambleWord; 
	private boolean scrambleCall, realCall;
	private Random rand; 
	
	public Scramble(String f) throws IOException
	{
		words = new File(f); 
		wordsIn = new Scanner(words); //reads words from file 
		rand = new Random(); 
		scrambleCall = false; //no call to scramble method has been made yet
		realCall = false; //no call to getRealWord method has been made yet
		realWord = new StringBuilder(""); 
		scrambleWord = new StringBuilder(""); 
	} 
	
	public String getRealWord() throws IOException
	{
		realCall = true; 
		String s = new String(); //placeholder for word read in
		if(!(wordsIn.hasNext())) 
			realWord = null;
		else if(scrambleCall == true || (wordsIn.hasNext() && realWord.length() == 0)) //covers 1st call to getRealWord
		{
			s = wordsIn.nextLine(); 
			if(realWord.length() != 0)
				realWord.delete(0, realWord.length() + 1);
			realWord.append(s); 
		}
		
		scrambleCall = false; 
		if(realWord != null)
			return realWord.toString();
		else
			return null; 
	}
	
	public String getScrambledWord() throws IOException
	{
		scrambleCall = true; 
		if(realCall = false || realWord == null ) //if getRealWord() hasn't been called or no words left in file
			scrambleWord = null; 
		else
		{
			StringBuilder realWordPlaceholder = new StringBuilder(realWord); 
			if(scrambleWord.length() != 0)
				scrambleWord.delete(0, scrambleWord.length() + 1); 
			while(realWordPlaceholder.length() != 0)
			{
				int i = rand.nextInt(realWordPlaceholder.length()); 
				char placeholder = realWordPlaceholder.charAt(i); 
				scrambleWord.append(placeholder); 
				realWordPlaceholder.deleteCharAt(i); 
			}
				
		}
		
		if(scrambleWord != null)
			return scrambleWord.toString();
		else
			return null; 
	} 
}