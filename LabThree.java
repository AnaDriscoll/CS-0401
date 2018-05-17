/* Author: Ana Driscoll
Created: 9/20/2017
Last Edited: 9/20/2017
CS0401 Lab 3 */ 

import java.util.*;

public class LabThree
{
	public static void main (String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int b; //log base
		int x; 
		int p; //holds original x before integer division
		int result = 0; 
		do
		{
			System.out.println("Enter an integer base greater than one.");
			b = scan.nextInt();
			if(b <= 1)
				System.out.println("You entered a base less than or equal to one."); 
			else
			{
				System.out.println("Enter any integer greater than or equal to zero."); 
				x = scan.nextInt(); 
				while(x < 0)
				{
					System.out.println("Invalid input." + 
					"\nPlease enter an integer greater than or equal to zero."); 
					x = scan.nextInt();
				}
				p = x; 
				if(x / b == 0)
					System.out.println("The floor of log base " + b + " " + x + " is 0");
				else
				{
					while(x > b) 
					{
						x = x / b; 
						result++; 
					} 
					System.out.println("The floor of log base " + b + " " + p + " is " + (result + 1)); 
				}
			}
		}while(b > 1); 
	}
} 