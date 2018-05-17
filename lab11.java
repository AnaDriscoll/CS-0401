// CS 0401 Fall 2017
// Lab 11
// You must modify this file so that it works as described in the lab handout.
import java.util.*;
import java.io.*;
public class lab11
{
	public static void main(String [] args)
	{
		
		
		while(true)
		{
			try
			{
				Scanner inScan, fScan = null;
				int [] A = new int[5];
				inScan = new Scanner(System.in);
				System.out.println("Please enter the file to read from: ");
				String fName = inScan.nextLine();
				fScan = new Scanner(new File(fName));
				String nextItem;
				int nextInt = 0;
				int i = 0;
		
				while (fScan.hasNextLine())
				{
					nextItem = fScan.nextLine();
					nextInt = Integer.parseInt(nextItem);
					A[i] = nextInt;
					i++;
				}

				System.out.println("Here are your " + i + " items:");
				for (int j = 0; j < i; j++)
				{
					System.out.println(A[j] + " ");
				}
				break; 
			}
			catch(IOException e)
			{
				System.out.println("Invalid file. Please input an existing file."); 
			}
			catch(NumberFormatException n)
			{
				System.out.println("Number read in is not an integer. Number not added to array");
			}
			catch(ArrayIndexOutOfBoundsException r)
			{
				
			}
		}
		
	}
}
