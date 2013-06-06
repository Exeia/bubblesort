import java.util.*;

public class bubblesort{

	public static int [] unsorted = new int[200000];
	public static int [] unsorted2 = new int[20000];
	public static int [] unsorted3 = new int[2000];
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
	public static void reverse(int[] num)
	{
		boolean swapped = true;
		int temp;
		while(swapped)
		{
			swapped = false;
			for(int i = 1; i <= num.length-1; i++)
			{
				if(num[i-1] < num[i])
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
		double [] time = new double[MAX];
		double [] best = new double[MAX];
		
		double [] timeA = new double[MAX];
		double [] bestA = new double[MAX];
		double [] worstA = new double[MAX];
		
		double [] time_20000 = new double[MAX];
		double [] best_20000 = new double[MAX];
		double [] worst_20000 = new double[MAX];
		
		double [] time_2000000 = new double[MAX];
		double [] best_2000000 = new double[MAX];
		double [] worst_2000000 = new double[MAX];
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
			timeA[x] = t1 - t0;
			
			if(isVerify(unsorted) == false)
			{
				count++;
			}	
			long t2 = System.currentTimeMillis();
			sort(unsorted);
			long t3 = System.currentTimeMillis();
			best[x] = (t3-t2)/1000.0;
			bestA[x] = t3-t2;
		
			 t2 = System.currentTimeMillis();
			reverse(unsorted);
			 t3 = System.currentTimeMillis();
			worstA[x] = t3-t2;
		//20,000 elements	
			System.out.println("After: ");
			 t2 = System.currentTimeMillis();
			sort(unsorted2);
			 t3 = System.currentTimeMillis();
			time_20000[x] = (t3-t2);
			
			 t2 = System.currentTimeMillis();
			sort(unsorted2);
			 t3 = System.currentTimeMillis();
			best_20000[x] = (t3-t2);

			t2 = System.currentTimeMillis();
			reverse(unsorted2);
			 t3 = System.currentTimeMillis();
			worst_20000[x] = (t3-t2);
		//2,000,000
			 t2 = System.currentTimeMillis();
			sort(unsorted3);
			 t3 = System.currentTimeMillis();
			time_2000000[x] = (t3-t2);
			 t2 = System.currentTimeMillis();
			sort(unsorted3);
			 t3 = System.currentTimeMillis();
			best_2000000[x] = (t3-t2);
			 
			 t2 = System.currentTimeMillis();
			reverse(unsorted3);
			 t3 = System.currentTimeMillis();
			worst_2000000[x] = (t3-t2);
		//	print_array();
			reset_array();
		}

		 System.out.println("The results:");
		 System.out.println("Average Best");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(time[i] + " "+ best[i]);
		}
		
		 System.out.println("In millisecond");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(timeA[i] + " "+ bestA[i] + " "+ worstA[i]);
		}
		 System.out.println("The results 20000:");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(time_20000[i] + " "+ best_20000[i] + " "+ worst_20000[i]);
		}
		System.out.println("The results 2000:");
		for(int i = 0; i < MAX; i++)
		{
		 	System.out.println(time_2000000[i] + " "+ best_2000000[i] + " "+ worst_2000000[i]);
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
		for(int i = 0; i < unsorted2.length; i++)
		{
			unsorted2[i] = gen.nextInt(n);
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
