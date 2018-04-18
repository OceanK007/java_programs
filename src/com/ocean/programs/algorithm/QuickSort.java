package com.ocean.programs.algorithm;

import java.util.Arrays;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };
		
		System.out.println("Before sorting: "+Arrays.toString(arr));
		sortElements(arr, 0, arr.length-1);
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void sortElements(int arr[], int startIndex, int endIndex)
	{
		if(startIndex >= endIndex)
			return ;
		
		// This is the main logic
		int middleIndex = startIndex + (endIndex - startIndex) / 2;
		int pivot = arr[middleIndex];
 
		int tempStartIndex = startIndex, tempEndIndex = endIndex;
		while (tempStartIndex <= tempEndIndex) 
		{
			while (arr[tempStartIndex] < pivot) 
			{
				tempStartIndex++;
			}
 
			while (arr[tempEndIndex] > pivot) 
			{
				tempEndIndex--;
			}
 
			if (tempStartIndex <= tempEndIndex) 
			{
				int temp = arr[tempStartIndex];
				arr[tempStartIndex] = arr[tempEndIndex];
				arr[tempEndIndex] = temp;
				tempStartIndex++;
				tempEndIndex--;
			}
		}
 
		// recursively sort two sub parts
		if (startIndex < tempEndIndex)
			sortElements(arr, startIndex, tempEndIndex);
 
		if (endIndex > tempStartIndex)
			sortElements(arr, tempStartIndex, endIndex);
	}
}
