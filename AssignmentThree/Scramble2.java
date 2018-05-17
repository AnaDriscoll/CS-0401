//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 3, Scramble2 Class 
//Retrieves and scrambles words from a file, produces words in random order 
//Created 11/4/17, last modified 11/7/17


import java.util.*;
import java.io.*;  

public class Scramble2 
{
	private File words;
	private Scanner wordsIn; 
	private ArrayList<StringBuilder> wordList; //stores string input from file
	private StringBuilder realWord, scrambleWord; 
	private boolean scrambleCall, realCall;
	private Random rand; 
	private int index; //will keep track of how many words to iterate through 
	
	public Scramble2(String f) 
	{
		try
		{
			words = new File(f); 
			wordsIn = new Scanner(words); //reads words from file 
		}
		catch(IOException e)
		{
			System.out.println("File name not found."); 
		}
		
		rand = new Random(); 
		scrambleCall = true; //so first iteration of getRealWord can be completed
		realCall = false; //no call to getRealWord method has been made yet 
		wordList = new ArrayList<StringBuilder>(); 
		
		while(wordsIn.hasNext()) //fills ArrayList until no words left in file
		{
			StringBuilder temp = new StringBuilder(wordsIn.nextLine());
			wordList.add(temp); 
		}
		
		wordsIn.close(); 
		
		index = wordList.size(); //initially, all words could be chosen
		realWord = new StringBuilder(""); 
		scrambleWord = new StringBuilder(""); 
	} 
	
	public String getRealWord() 
	{
		realCall = true; 
		int tempIndex; //method will retrieve word from random ArrayList index
		
		if(index == 0) //if all words have been used
			realWord = null;
		else if(scrambleCall == true) 
		{
			tempIndex = rand.nextInt(index); 
			
			//moves chosen word to end of wordList so it won't be looked at again
			realWord = wordList.get(tempIndex);
			wordList.set(tempIndex, wordList.get(wordList.size() - 1));
			wordList.set(wordList.size() - 1, realWord);
			
			index--; //will reduce number of words looked through by 1 per iteration
		}
		
		scrambleCall = false; 
		if(realWord != null)
			return realWord.toString();
		else
			return null; 
	}
	
	public String getScrambledWord() 
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
	
	public void reset() 
	{
		index = wordList.size(); 
		scrambleCall = true; 
		realWord = new StringBuilder(""); 
		scrambleWord = new StringBuilder(""); 
	}
}