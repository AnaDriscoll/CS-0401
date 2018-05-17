//Ana Driscoll
//CS0401 T+Th 1:00-2:15 
//Assignment 3, Assig3 (Main Program)  
//Allows user to play word game using Scramble and Results
//Created 11/8/17, last modified 11/ /17

import java.util.*;
import java.io.*;  

public class Assig3
{
	public static void main (String[] args) throws IOException
	{
	
		Scanner scan = new Scanner(System.in);
		String realWord = new String(""); 
		String scrambleWord = new String(""); 
		boolean playAgain = true; //does user want to play again? 
		boolean isPlayer = true; //if user is finished, is there another player to continue game?
		boolean correct = false; //is user's guess correct? 
		Scramble2 scram = new Scramble2("words.txt");
		PlayerList players = new PlayerList("players.txt"); //initializes PlayerList
	
		do
		{
			
			System.out.println("Welcome! What is your name?");
			String name = scan.nextLine(); 
		
			Player user = new Player("");
			user = players.getPlayer(name); 
			
			if(user == null) //if player isn't on the list
			{
				user = new Player(name); 
				players.addPlayer(user); 
				System.out.println("Hello " + name + "! Welcome. Let's begin."); 
			}
			
			else
				System.out.println("Hello " + name + "! Welcome back. Let's begin."); 
				
	 
			int wins = 0; 
			int losses = 0; 
			int rounds = 0; 
			
			//play game while user wants to continue and word is available 
			while(playAgain && realWord != null && scrambleWord != null) 
			{
				realWord = scram.getRealWord(); 
				scrambleWord = scram.getScrambledWord(); 
				String guessedWord = new String(); //stores user's guess 
				if(realWord != null && scrambleWord != null) //if real/scrambled words are available
				{
					int guessLeft = 3; //keeps track of how many guesses user has left 
					while(guessLeft > 0 && !correct)
					{
						System.out.println("The scrambled word is: " + scrambleWord);
						System.out.println("Guess the word: "); 
						guessedWord = scan.nextLine(); 
						if(guessedWord.compareToIgnoreCase(realWord) == 0) //if guess is correct
						{
							correct = true; 
							user.update(true); //increment number of wins/rounds for Player
							rounds++; 
							wins++; 
							System.out.println("Congratulations! That is the correct word."); 
						}
						else //if guess is incorrect
						{
							System.out.println("That is not the correct word.");
							System.out.println("Here are the letters you guessed correctly: "); 
							String compare; //to compare guessed word and real word
							if(realWord.length() < guessedWord.length()) 
								compare = realWord; 
							else
								compare = guessedWord; 
							//loop will only run through as many chars as the shorter string (guessed or real)
							for(int i = 0; i < compare.length(); i++)
							{
								if(realWord.charAt(i) == guessedWord.charAt(i))
									System.out.print(guessedWord.charAt(i)); 
								else 
									System.out.print("_"); 
							}
							if(guessedWord.length() < realWord.length()) 
							{
								//prints blanks for ending letters of real word if guess is shorter 
								for(int i = 0; i < (realWord.length() - guessedWord.length()); i++)
									System.out.print("_"); 
							}
							guessLeft--; //decreases number of guesses user has left
							System.out.println("\nYou have " + guessLeft + " tries left to guess the scrambled word.");
						}
					}
					if(!correct) //if user hasn't guessed correctly
					{
						System.out.println("Sorry! You didn't guess the correct word.\n" + 
						"The correct word is " + realWord); 
						user.update(false); //increment number of losses/rounds for Player
						rounds++; 
						losses++; 
					}
				
					String decision = new String(); //stores user's decision to play again
					System.out.println("Would you like to play again? Press 'y' for yes or 'n' for no."); 
					decision = scan.nextLine(); 
					while(decision.compareToIgnoreCase("y") != 0 && decision.compareToIgnoreCase("n") != 0) 
					{
						System.out.println("Invalid input. Please press 'y' or 'n'"); 
						decision = scan.nextLine();
					}
					if(decision.compareToIgnoreCase("y") == 0)
						playAgain = true; 
					else
						playAgain = false; 
						
					correct = false; //resets round
				}
			} 
		
			if(realWord == null) //if all words in file have been used
				System.out.println("Game over! You are out of words."); 
			else //if user has decided to end game
				System.out.println("Game over!"); 
		
			System.out.println("Is there another player who would like to play the game?" +
			"\nPress 'y' for yes or 'n' for no.");
			String nextPlayer = scan.nextLine();
			if(nextPlayer.compareToIgnoreCase("y") == 0)
			{
				isPlayer = true; 
				playAgain = true;
				scram.reset(); 
			}
			else
				isPlayer = false;
			
			System.out.println(user.getName() + ", here are your results for this game: " +
			"\n\tRounds: " + rounds + "\n\tWins: " + wins + "\n\tLosses: " + losses); 
			System.out.println("Here are your overall results: "); 
			System.out.println(user.toString()); 
			players.saveList(); 

		}while(isPlayer);
		 	
	}
		
}
