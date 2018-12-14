package com.ocean.programs.algorithm;

import java.util.Arrays;

/**
Selection sort is a simple sorting algorithm. 
This sorting algorithm is an in-place comparison-based algorithm in which the list is divided into two parts, 
the sorted part at the left end and the unsorted part at the right end. Initially, 
the sorted part is empty and the unsorted part is the entire list.

The smallest element is selected from the unsorted array and swapped with the leftmost element, 
and that element becomes a part of the sorted array. This process continues moving unsorted array boundary by one element to the right.

This algorithm is not suitable for large data sets as its average and worst case complexities are of O(n2), where n is the number of items.
**/
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
