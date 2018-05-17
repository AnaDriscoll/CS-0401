import java.util.*; 

public class LabSix
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("How many items will be entered?"); 
		int len = scan.nextInt(); 
		double[] arr = new double[len];
		
		System.out.println("Please enter your values: ");
		for(int i = 0; i < arr.length; i++)
			arr[i] = scan.nextDouble(); 
		
		System.out.println("\nMaximum value: " + LabSix.max(arr)); 
		System.out.println("Minimum value: " + LabSix.min(arr));
		System.out.println("Sum: " + LabSix.sum(arr));
		System.out.println("Average: " + LabSix.ave(arr)); 
	}
	
	public static double max_rec(double[] data, int loc)
	{
		if(loc < data.length - 1)
		{
			double temp1 = data[loc]; 
			double temp2 = max_rec(data, loc + 1);
			if(temp1 > temp2)
				return temp1;
			else
				return temp2;
		}
		else
			return data[data.length - 1]; 
	}
	
	public static double min_rec(double[] data, int loc)
	{
		if(loc < data.length - 1)
		{
			double temp1 = data[loc]; 
			double temp2 = min_rec(data, loc + 1);
			if(temp1 < temp2)
				return temp1;
			else
				return temp2;
		}
		else
			return data[data.length - 1]; 
	}
	
	public static double sum_rec(double[] data, int loc)
	{
		if(loc > 0)
			return (data[loc] + sum_rec(data, loc - 1)); 
		else
			return data[0]; 
	}
	
	public static double ave_rec(double[] data, int loc) 
	{ 
		if(loc > 0)
			return (data[loc] / data.length + ave_rec(data, loc - 1)); 
		else 
			return data[0] / data.length; 
	} 
	
	public static double max(double[] data)
	{
		return max_rec(data, 0); 
	}
	
	public static double min(double[] data)
	{
		return min_rec(data, 0);
	}
	
	public static double sum(double[] data)
	{
		return sum_rec(data, data.length - 1);
	}
	
	public static double ave(double[] data)
	{
		return ave_rec(data, data.length - 1); 
	}
}