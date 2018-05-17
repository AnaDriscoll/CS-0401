import java.util.Scanner; 

public class Order
{
	private ArrayList<String> list = new ArrayList<String>(1); //stores random words
	private Random wordPicker = new Random(); //used to choose random word from file
	private File words; //file associated with WordList
	private int index; //stores location of random word in file

	public P4A4_Driscoll_4106742_WordList(String f) //constructor, requires file 
	{
		words = new File(f); 
	}	
	public void addWord(String str) //add word to WordList, file not required
	{
		list.add(str);
	}
	public void changeFile(String newFile) //change file that is input source
	{
		words = new File(newFile);
	}
	public void addWordsFromFile(String fi) throws IOException //transfer words from new file into array
	{
		words = new File(fi);
		Scanner inputFile = new Scanner(words);
		while(inputFile.hasNext())
		{
			list.add(inputFile.nextLine());
		}
		inputFile.close();		
	}