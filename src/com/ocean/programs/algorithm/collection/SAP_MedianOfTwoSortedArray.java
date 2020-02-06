package com.ocean.programs.algorithm.collection;

/**
 	find the median of the two sorted arrays.
  	ex. {1, 3} and {2} => {1, 2, 3} = 2
  	ex. {1, 3} and {2, 4} => {1, 2, 3, 4} = (2+3)/2 = 2.5


	Case 1: m+n is odd
	Then we will find a clear median at (m+n)/2 index in the array obtained after merging both the arrays so 
	we just traverse both the arrays and keep the last value in m1 after the loop, m1 will contain the value of the median
	
	Case 2: m+n is even
	Median will be average of elements at index ((m+n)/2 – 1) and (m+n)/2 in the array obtained after merging 
	both the arrays so we need to keep track of not only the last element but also the second last element (m2 is used for this) 
	so we traverse both the arrays and keep the last value in m1 and second last value in m2 after the loop, (m1+m2)/2 will contain the value of the median.
**/
public class SAP_MedianOfTwoSortedArray 
{
	public static void main(String[] args)
	{
		if(pass())
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("some failures");
		}
	}
	
	public static boolean pass()
	{
	  boolean result = true;
	  result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
	  result = result && logic(new int[]{1, 3}, new int[]{2}) == 2.0;
	  return result;
	};
	
	public static double logic(int[] a, int[] b) 
	{
		float f = 0.0f;
		int[] mergedArray = mergeArray(a, b);
		if(mergedArray.length % 2 != 0)
		{
			f = mergedArray[mergedArray.length/2];
		}
		else
		{
			int element1 = mergedArray[mergedArray.length/2];
			int element2 = mergedArray[(mergedArray.length/2)-1];
			//System.out.println(element1);
			//System.out.println(element2);
			
			f = (element1 + element2)/2.0f;
			//System.out.println(f);
		}
		
		return f;
	} 
	
	public static int[] mergeArray(int[] a, int[] b)
	{
		int aLength = a.length;
		int bLength = b.length;
		
		int[] c = new int[aLength+bLength];
		//System.out.println(Arrays.toString(c));
		
		int ax = 0, by = 0, cz = 0;
		while(true)
		{
			if(ax == aLength || by == bLength)
			{
				break;
			}
			
			if(a[ax] < b[by])
			{
				c[cz] = a[ax];
				cz++;
				ax++;
			}
			else
			{
				c[cz] = b[by];
				cz++;
				by++;
			}
		}
		
		//System.out.println("ax: "+ax+" | by: "+by+" | cz: "+cz);
		
		// Add remaining elements of a to c
		while(ax < aLength)
		{
			c[cz] = a[ax];
			cz++;
			ax++;
		}
		// Add remaining elements of b to c
		while(by < bLength)
		{
			c[cz] = b[by];
			cz++;
			by++;
		}
		
		//System.out.println(Arrays.toString(c));
		
		return c;
	}
}
