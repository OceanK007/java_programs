package com.ocean.programs.collection;

/*
 * public static int secondLargest(int a[])
 * Returns the 2nd largest number in array that has been rotated
 * For example - Array {3,4,5,6,1,2} returns 5
*/

public class SAP_SecondLargestElementInArray
{
	public static int secondLargest(int[] x) 
	{
		// Approach 1: Sort the array then find out. (Bubble sort)
		// Approach 2: Do traversal 2 times, first to find largest, and 2nd to find 2nd largest by comparing smallest to all elements
		
		// Approach 3: Single loop
		if(x.length == 1)
			return x[0];
		else
		{
			int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE; 
	        for (int i = 0; i < x.length ; i ++) 
	        { 
	            if (x[i] > first) 
	            { 
	                second = first; 
	                first = x[i]; 
	            } 	 
	            else if (x[i] > second && x[i] < first) 
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
		result &= secondLargest(a) == 0;
		result &= secondLargest(b) == 0;
		result &= secondLargest(c) == 0;
		result &= secondLargest(d) == 2;

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
