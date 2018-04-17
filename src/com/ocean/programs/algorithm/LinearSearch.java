package com.ocean.programs.algorithm;

/**
 	Time complexity: O(n)
**/
public class LinearSearch 
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
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==element)
				return i;
		}
		
		return -1;
	}
}
