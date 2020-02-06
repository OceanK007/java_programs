package com.ocean.programs.algorithm.collection;

/*
 * public static int secondSmallest(int a[])
 * Returns the 2nd smallest number in array that has been rotated
 * For example - Array {3,4,5,6,1,2} returns 2
*/

public class SAP_SecondSmallestElementInArray
{
	public static int secondSmallest(int[] x) 
	{
		// Approach 1: Sort the array then find out. (Bubble sort)
		// Approach 2: Do traversal 2 times, first to find smallest, and 2nd to find 2nd smallest by comparing smallest to all elements
		
		// Approach 2
		/*if(x.length == 1)
			return x[0];
		else
		{
			int smallest = x[0];
			
			for(int i=1;i<x.length;i++)
			{
				if(x[i] < smallest)
				{
					smallest = x[i];
				}
			}

			int difference = Integer.MAX_VALUE;
			for(int j=0;j<x.length;j++)
			{
				int currentDifference = x[j] - smallest;
				
				if(currentDifference != 0 && currentDifference < difference)
				{
					difference = currentDifference;
				}
			}
			
			return smallest+difference;
		}*/
		
		// Approach 3: Single loop
		if(x.length == 1)
			return x[0];
		else
		{
			int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE; 
	        for (int i = 0; i < x.length ; i ++) 
	        { 
	            if (x[i] < first) 
	            { 
	                second = first; 
	                first = x[i]; 
	            } 	 
	            else if (x[i] < second && x[i] > first) 
	            {
	                second = x[i];
	            }
	        } 
	        
	        return second;
		}
	}

	public static void main(String args[])
	{
	  	int[] a = { 0 };
		int[] b = { 0, 1 };
		int[] c = { 1, 0 };
		int[] d = { 0, 1, 2, 3 };

		boolean result = true;
		result &= secondSmallest(a) == 0;
		result &= secondSmallest(b) == 1;
		result &= secondSmallest(c) == 1;
		result &= secondSmallest(d) == 1;

		if (result) 
		{
			System.out.println("Pass");
		} 
		else 
		{
			System.out.println("Fail");
		}
	}
}
