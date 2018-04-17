package com.ocean.programs.algorithm;

/**
Binary Search: Search a sorted array by repeatedly dividing the search interval in half. 
Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, 
narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

Time complexity: O(log n)
**/
public class BinarySearch 
{
	public static void main(String[] args) 
	{
	    int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	    int element = 9;
	    
	    int result = searchElement(arr, element);
	    
	    if(result == -1)
	    {
	    	System.out.println("Element not found");
	    }
	    else
	    {
	    	System.out.println("Element found at index : "+result);
	    }
	}
	
	public static int searchElement(int arr[], int element)
	{
		int startIndex = 0;
		int endIndex = arr.length-1;

		while(startIndex <= endIndex)
		{
			// This is the main logic
			int checkIndex = startIndex + (endIndex - startIndex)/2;
			
			if(element == arr[checkIndex])
			{
				return checkIndex;
			}
			
			if(element < arr[checkIndex])
			{
				endIndex = checkIndex - 1;
			}
			else
			{
				startIndex = checkIndex + 1;
			}
		}
			
		return -1;
	}
}
