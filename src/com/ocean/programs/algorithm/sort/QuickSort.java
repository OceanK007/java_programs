package com.ocean.programs.algorithm.sort;

import java.util.Arrays;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		//int[] arr = { 11, 9, 2, 4, 13, 7, 3, 7, 10 };
		int[] arr = { 15, 14, 12, 4, 13, 7, 3, 7, 10 };
		
		System.out.println("Before sorting: "+Arrays.toString(arr));
		sortElements(arr, 0, arr.length-1);
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	static void sortElements(int arr[], int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            /* pi is partitioning index, arr[pi] is now at right place */
            int partitionIndex = partition(arr, startIndex, endIndex);
 
            // Recursively sort elements before partition and after partition
            sortElements(arr, startIndex, partitionIndex-1);
            sortElements(arr, partitionIndex+1, endIndex);
        }
    }
	
	static int partition(int arr[], int startIndex, int endIndex)
    {
        int pivot = arr[endIndex]; 
        int newPivotIndex = (startIndex-1); // index of smaller element
        for (int j=startIndex; j<endIndex; j++)
        {
        	System.out.println("arr[j]: "+arr[j]+" | pivot: "+pivot);
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot)
            {
                newPivotIndex++;
 
                // swap arr[i] and arr[j]
                int temp = arr[newPivotIndex];
                arr[newPivotIndex] = arr[j];
                arr[j] = temp;
            }
            
            System.out.println("List: "+Arrays.toString(arr));
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[newPivotIndex+1];
        arr[newPivotIndex+1] = arr[endIndex];
        arr[endIndex] = temp;
        
        System.out.println("List: "+Arrays.toString(arr));
 
        return newPivotIndex+1;
    }
}
