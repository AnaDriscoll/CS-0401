// CS 0401 Fall 2017
// Simple class to demonstrate inheritance and access restrictions.  See also
// SubClass.java

public class SuperClass
{
	private int pri;	// accessible only within this class
	public int pub;		// accessible everywhere
	protected int pro;	// accessible within this class, any subclasses
						//    and the same package
						
	public SuperClass(int a, int b, int c)
	{
		pri = a; pub = b; pro = c;
	}

	public SuperClass() // Default constructor does nothing
	{}

	// Some simple mutators -- see SubClass.java and ex15.java for more info
	// on these
	public void mutatePri(int a)
	{
		pri = a;
	}

	public void mutatePro(int b)
	{
		pro = b;
	}

	public void mutatePub(int c)
	{
		pub = c;
	}
	
	public String toString()
	{
		return new String("pri: " + pri + " pub: " + pub + " pro: " + pro);
	}
	
}