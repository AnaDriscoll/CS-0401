import java.lang.*; 
import java.util.*;

public class LabFour
{
	public static void main (String [] args) 
	{
		Random r = new Random(); 
		int roll;
		int decision; 
		Scanner scan = new Scanner(System.in); 
		do
		{
			System.out.println("Enter the number of rolls: "); 
			roll = scan.nextInt(); 
			rollDice(roll, r); 
			System.out.println("Would you like to roll again? Press 1 for yes or 2 for no."); 
			decision = scan.nextInt();
		}while(decision == 1);
	}
	public static void rollDice(int rolls, Random rand)
	{
		int rollOne, rollTwo; 
		int[] dice = new int[rolls];
		for(int i = 0; i < rolls; i++)
		{
			rollOne = 0;
			rollTwo = 0; 
			rollOne = (rand.nextInt(6) + 1);
			rollTwo = (rand.nextInt(6) + 1); 
			dice[i] = rollOne + rollTwo;
		} 
		Arrays.sort(dice); 
		System.out.println("Here are the sums of your rolls: "); 
		System.out.println("\t" + 2 + ": " + Arrays.binarySearch(dice, 2) + " out of " + rolls);
		int count, test;
		for(int j = 3; j < 13; j++)
		{
			test = j - 1; 
			count = Arrays.binarySearch(dice, j) - Arrays.binarySearch(dice, test); 
			if(Arrays.binarySearch(dice, j) < 0)
				System.out.println(j + ": 0 out of " + rolls);
			else
				System.out.println("\t" + j + ": " + count + " out of " + rolls);
		}
	}
}	
		