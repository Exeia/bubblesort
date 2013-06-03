import java.util.*;

public class bubblesort{

	public static int [] unsorted = new int[200000];

	public static void sort(int[] num)
	{
		boolean swapped = true;
		int temp;
		while(swapped)
		{
			swapped = false;
			for(int i = 1; i <= num.length-1; i++)
			{
				if(num[i-1] > num[i])
				{
					temp = num[i-1];
					num[i-1] = num[i];
					num[i] = temp;
					swapped = true;
				}
			} 
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
		double [] best = new double[MAX];
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
			//best case
			long t2 = System.currentTimeMillis();
			sort(unsorted);
			long t3 = System.currentTimeMillis();
			best[x] = (t3-t2)/1000.0;
			System.out.println("After: ");
		//	print_array();
			reset_array();
		}

		 System.out.println("The results:");
		 System.out.println("Avg   Best");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(time[i] +" " +best[i] );
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
