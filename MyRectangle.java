public class MyRectangle 
{
	protected int width; 
	protected int height; 
	protected int startX;
	protected int startY;
	
	public MyRectangle(int x, int y, int w, int h)
	{
		startX = x;
		startY = y;
		width = w;
		height = h;
	}
	
	public MyRectangle()
	{
		startX = 0;
		startY = 0;
		width = 0;
		height = 0; 
	}
	
	public int area()
	{
		return width*height; 
	}
	
	public String toString()
	{
		String s = new String();
		s = "Upper left corner of rectangle is at (" + startX + ", " + startY + ")." +
		"\nThe rectangle is " + width + " units wide and " + height + " units tall.";
		return s;
	}
	
	public boolean isInside(int x, int y)
	{
		if((startX + width) < x || (startY + height) < y || startX > x || startY > y )
			return false;
		else
			return true; 
	}
	
	
	public void setSize(int newWidth, int newHeight)
	{
		width = newWidth;
		height = newHeight; 
	}
	
	public void setPosition(int newX, int newY)
	{
		startX = newX;
		startY = newY; 
	}
}
