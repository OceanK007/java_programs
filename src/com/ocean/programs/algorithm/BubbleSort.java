package com.ocean.programs.algorithm;

import java.util.Arrays;

/** 
	Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
	
	Time complexity:
	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
**/
public class BubbleSort 
{
	public static void main(String[] args) 
	{
	    int arr[] = {10,9,8,7,6,5,4,3,2,1};
	    
	    System.out.println("Before sorting: "+Arrays.toString(arr));
	    sortElements(arr);
	    System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void sortElements(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			// Here j < arr.length-1 to avoid execution of extra irrelevant loops
			for(int j=0;j<arr.length-i;j++)
			{
				if((j+1 <arr.length) && arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
