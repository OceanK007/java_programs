package com.ocean.programs.algorithm;

import java.util.Arrays;

/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning.

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 


Time Complexity: O(n2) as there are two nested loops.

It's called SelectionSort, because we select the minimum valued element by comparing and swaps it.
*/
public class SelectionSort 
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
		for(int i=0;i<arr.length;i++)
		{
			int minValueIndex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				//System.out.println("arr[j]: "+arr[j] + " | arr[i]: "+arr[i]);
				if(arr[j] < arr[minValueIndex])
				{
					minValueIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minValueIndex];
			arr[minValueIndex] = temp;
			
			System.out.println(Arrays.toString(arr));
		}
	}
}
