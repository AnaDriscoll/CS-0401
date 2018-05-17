import java.util.*;
import java.io.*;  // import needed for Java file classes
public class FileTest
{
	// Note that the main method below has the tag "throws IOException" after the
	// header.  This is necessary if you have a method that creates an input file (ex:
	// to read in using a Scanner) or an output file (ex: using a PrintWriter) and also
	// for some other situations.  This also holds for any method that CALLs a method
	// that has this tag.  See what happens if you remove this tag.  We will discuss 
	// exceptions in more detail later.  

	public static void main(String [] args) throws IOException
	{
		// A Scanner is used for both the keyboard input and the file
		// input.  The only difference is in the argument to the constructor.
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fName = keyIn.nextLine();
		File inFile = new File(fName);
		Scanner fileIn = new Scanner(inFile);
		
		System.out.print("Output file name: ");
		fName = keyIn.nextLine();
		PrintWriter fileOut = new PrintWriter(fName);
		
		copyFile(fileIn, fileOut);
		fileIn.close();
		fileOut.close();
	}

	public static void copyFile(Scanner inF, PrintWriter outF)
	{
		while (inF.hasNextLine())
		{
			String line = inF.nextLine();
			outF.println(line);
		}
	}
}