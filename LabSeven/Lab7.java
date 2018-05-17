// CS 401 Fall 2017 Lab 7 Main Program
// Your job is to complete this program so that it runs correctly.
// The Movie class and MovieDB class have already been completed for you.
// Utilizing data abstraction, you can access/use these classes without
// having to know their implementation details.  However, since you have
// the code for them you certainly can look at the implementations.
// You just need to write the correct code in the 3 passages below.  Some
// comments indicate what you need to do in each case.
import java.util.*;
import java.io.*;
public class Lab7
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10); // Create MovieDB object.  The
					// size is set at 10, meaning it can hold up to 10
					// movies.  If we wanted (as discussed in lecture) we
					// could allow for it to be resized so it could hold
					// an arbitrary number of movies.
		loadData(movies);		// input movie data from file
		getCommands(movies);	// interact with user 
		saveData(movies);		// save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		Scanner S = new Scanner(new FileInputStream("movieFile.txt"));
	
		
		int numMovies = S.nextInt(); 
		S.nextLine(); 
		
		for(int i = 0; i < numMovies; i++)
		{
			String title = new String(S.nextLine());
			String dir = new String(S.nextLine()); 
			String studio = new String(S.nextLine()); 
			String g = S.nextLine(); 
			double gross = Double.parseDouble(g); 
			 
			Movie mov = new Movie(title, dir, studio, gross); 
			movies.addMovie(mov); 
		}
	}

	public static void getCommands(MovieDB movies)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();
		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
			}
			else if (choice.equals("2"))
			{
				System.out.println("Input the movie title.");
				String title = inScan.nextLine(); 
				System.out.println("Input the movie's director.");
				String dir = inScan.nextLine(); 
				System.out.println("Input the movie's studio.");
				String studio = inScan.nextLine(); 
				System.out.println("Input the movie's gross earnings.");
				double gro = inScan.nextDouble(); 
				inScan.nextLine();
				
				Movie m = new Movie(title, dir, studio, gro); 
				
				movies.addMovie(m); 
			}
			else if (choice.equals("3"))
			{
				System.out.println("What is the movie's title?");
				String title = inScan.nextLine(); 
				Movie m = movies.findMovie(title); 
				if(m == null)
					System.out.println(title + " was not found."); 
				else
					System.out.println(m.toString()); 
			}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();
		}
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("movieFile.txt");
		// Note that we are printing the entire DB to the file with
		// one statement.  This is because the toStringFile() method
		// of the MovieDB class calls the toStringFile() method of
		// each Movie within the DB.
		P.print(movies.toStringFile());
		P.close();
	}
}
