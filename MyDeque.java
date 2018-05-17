// CS 401 Fall 2017
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		if(numItems >= theData.length)
		{
			
		}
		else
		{
			for(int i = numItems - 1; i >= 0; i--)
				theData[i + 1] = theData[i];
			theData[0] = X; 
			numItems++; 
		}
		
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
	}

	public void addRear(Object X)
	{
		if(numItems >= theData.length)
		{
			
		}
		else 
		{
			theData[numItems] = X; 
			numItems++;
		}
		
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
	}

	public Object removeFront()
	{
		if(isEmpty())
			return null; 
		else
		{
			Object temp = new Object(); 
			temp = theData[0];
			for(int i = 1; i < numItems; i++)
				theData[i - 1] = theData[i];
			theData[numItems - 1] = null;
			numItems--;
			return temp; 
		}
		
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
	}

	public Object removeRear()
	{
		if(isEmpty())
			return null; 
		else
		{
			Object temp = new Object();
			temp = theData[numItems - 1]; 
			theData[numItems - 1] = null; 
			numItems--; 
			return temp; 
		}
		
		// Remove and return rear item from list.  If list is empty,
		// return null.
	}
}