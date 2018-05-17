public class MySquare extends MyRectangle
{
	public MySquare()
	{
		startX = 0;
		startY = 0;
		width = 0;
		height = 0; 
	}
	
	public MySquare(int x, int y, int side)
	{
		startX = x;
		startY = y;
		width = side;
		height = side;
	}
	
	public String toString()
	{
		String s = new String();
		s = "Side: " + width + " X: " + startX + " Y: " + startY + " Area: " + (width * height);
		return s; 
	}
	
	public void setSize(int w, int h)
	{
		if(w == h)
		{
			width = w;
			height = h;
		}
		else
		{
			System.out.println("The sides must be equal. " + w + " != " + h); 
		}
	}
	
	public void setSide(int s)
	{
		width = s; 
		height = s;
	}
}