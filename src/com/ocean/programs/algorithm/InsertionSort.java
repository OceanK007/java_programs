package com.ocean.programs.algorithm;

import java.util.Arrays;

/**
This is an in-place comparison-based sorting algorithm. 
Here, a sub-list is maintained which is always sorted. 
For example, the lower part of an array is maintained to be sorted. 
An element which is to be 'insert'ed in this sorted sub-list, 
has to find its appropriate place and then it has to be inserted there. 
Hence the name, insertion sort.

The array is searched sequentially and unsorted items are moved and
inserted into the sorted sub-list (in the same array). 
This algorithm is not suitable for large data sets as its average 
and worst case complexity are of O(n2), where n is the number of items.
 
Time Complexity: O(n2)
**/
public class InsertionSort 
{
	public static void main(String[] args) 
	{
		int arr[] = {10,34,2,56,7,67,88,42};
		
		System.out.println("Before sorting: "+Arrays.toString(arr));
		sortElements(arr);
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void sortElements(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				//System.out.println("arr[j]: "+arr[j] + " | arr[j-1]: "+arr[j-1]);
				if(arr[j-1] > arr[j])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
			
			System.out.println(Arrays.toString(arr));
		}
	}
}
