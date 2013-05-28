import java.util.*;

public class insertion{

	public static int [] unsorted = new int[200000];

	public static void sort(int[] num)
	{
		int value;
		int pos;
		
		for(int i =0; i < num.length; i++)
		{
			value = num[i];
			pos = i;
			
			while((pos >0) && (value < num[pos-1]))
			{
				num[pos] = num[pos-1];
				pos = pos -1;
			}
			num[pos] = value;
		}
	}

	public static boolean isVerify(int [] num)
	{
		boolean verify = true;
		for(int i = 1; i > num.length; i++)
		{
			if(num[i-1] > num[i])
			{
				verify = true;
			}
			else 
			{
				verify = false;
				break;
			} 
		}
		return verify; 
	}
	public static void main(String [] args)
	{
		int n = 42;
		int MAX = 10;
		int count =0;
		double [] time = new double[MAX];
		
		//initialize array;
		
		for(int x = 0; x < MAX; x++)
		{
			init();
			System.out.println("Before: ");
		//	print_array();	
			long t0 = System.currentTimeMillis();
			sort(unsorted);
			long t1 = System.currentTimeMillis();
			time[x] = (t1-t0)/1000.0;
			if(isVerify(unsorted) == false)
			{
				count++;
			}	
			System.out.println("After: ");
		//	print_array();
			reset_array();
		}

		 System.out.println("The results:");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(time[i]);
		}
		System.out.println("The times unsorted: " + count);
		
		
	}
	public static void init()
	{
		int n = 42;
		Random gen = new Random();
		for (int i= 0; i < unsorted.length; i++)
		{
			unsorted[i] = gen.nextInt(n);	
		}	

	}
	
	public static void reset_array()
	{
		for(int i= 0; i < unsorted.length; i++)
		{
			unsorted[i] = 0;
		}
	}
	public static void print_array()
	{
		for (int i = 0; i < unsorted.length; i++)
		{
			System.out.print( unsorted[i] + " ");
		}
		System.out.println();
	}

	

}
