package com.ocean.programs.algorithm.sort;

import java.util.Arrays;

/** 
	Bubble sort is the simplest sorting algorithm, it compares the first two elements, if the first is greater than the second, swaps them, 
	continues doing (compares and swaps) for the next pair of adjacent elements. It then starts again with the first two elements, compares, swaps until no more swaps are required.
	
	Time complexity:
	Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted.
	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
	
	The bubble sort gets its name because elements tend to move up into the correct order like bubbles rising to the surface.
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
        for (int i = 0; i < arr.length; i++)
        {
        	// j < arr.length-i to avoid execution of irrelevant loops
        	for (int j = 0; j < arr.length-i && j+1 < arr.length; j++)
            {
            	if (arr[j] > arr[j+1])
            	{
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            	
            	System.out.println(Arrays.toString(arr));
            }
        }
	}
}
/* 
[9, 10, 8, 7, 6, 5, 4, 3, 2, 1]
[9, 8, 10, 7, 6, 5, 4, 3, 2, 1]
[9, 8, 7, 10, 6, 5, 4, 3, 2, 1]
[9, 8, 7, 6, 10, 5, 4, 3, 2, 1]
[9, 8, 7, 6, 5, 10, 4, 3, 2, 1]
[9, 8, 7, 6, 5, 4, 10, 3, 2, 1]
[9, 8, 7, 6, 5, 4, 3, 10, 2, 1]
[9, 8, 7, 6, 5, 4, 3, 2, 10, 1]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 10]
[8, 9, 7, 6, 5, 4, 3, 2, 1, 10]
[8, 7, 9, 6, 5, 4, 3, 2, 1, 10]
[8, 7, 6, 9, 5, 4, 3, 2, 1, 10]
[8, 7, 6, 5, 9, 4, 3, 2, 1, 10]
[8, 7, 6, 5, 4, 9, 3, 2, 1, 10]
[8, 7, 6, 5, 4, 3, 9, 2, 1, 10]
[8, 7, 6, 5, 4, 3, 2, 9, 1, 10]
[8, 7, 6, 5, 4, 3, 2, 1, 9, 10]
[8, 7, 6, 5, 4, 3, 2, 1, 9, 10]
[7, 8, 6, 5, 4, 3, 2, 1, 9, 10]
[7, 6, 8, 5, 4, 3, 2, 1, 9, 10]
[7, 6, 5, 8, 4, 3, 2, 1, 9, 10]
[7, 6, 5, 4, 8, 3, 2, 1, 9, 10]
[7, 6, 5, 4, 3, 8, 2, 1, 9, 10]
[7, 6, 5, 4, 3, 2, 8, 1, 9, 10]
[7, 6, 5, 4, 3, 2, 1, 8, 9, 10]
[7, 6, 5, 4, 3, 2, 1, 8, 9, 10]
[6, 7, 5, 4, 3, 2, 1, 8, 9, 10]
[6, 5, 7, 4, 3, 2, 1, 8, 9, 10]
[6, 5, 4, 7, 3, 2, 1, 8, 9, 10]
[6, 5, 4, 3, 7, 2, 1, 8, 9, 10]
[6, 5, 4, 3, 2, 7, 1, 8, 9, 10]
[6, 5, 4, 3, 2, 1, 7, 8, 9, 10]
[6, 5, 4, 3, 2, 1, 7, 8, 9, 10]
[5, 6, 4, 3, 2, 1, 7, 8, 9, 10]
[5, 4, 6, 3, 2, 1, 7, 8, 9, 10]
[5, 4, 3, 6, 2, 1, 7, 8, 9, 10]
[5, 4, 3, 2, 6, 1, 7, 8, 9, 10]
[5, 4, 3, 2, 1, 6, 7, 8, 9, 10]
[5, 4, 3, 2, 1, 6, 7, 8, 9, 10]
[4, 5, 3, 2, 1, 6, 7, 8, 9, 10]
[4, 3, 5, 2, 1, 6, 7, 8, 9, 10]
[4, 3, 2, 5, 1, 6, 7, 8, 9, 10]
[4, 3, 2, 1, 5, 6, 7, 8, 9, 10]
[4, 3, 2, 1, 5, 6, 7, 8, 9, 10]
[3, 4, 2, 1, 5, 6, 7, 8, 9, 10]
[3, 2, 4, 1, 5, 6, 7, 8, 9, 10]
[3, 2, 1, 4, 5, 6, 7, 8, 9, 10]
[3, 2, 1, 4, 5, 6, 7, 8, 9, 10]
[2, 3, 1, 4, 5, 6, 7, 8, 9, 10]
[2, 1, 3, 4, 5, 6, 7, 8, 9, 10]
[2, 1, 3, 4, 5, 6, 7, 8, 9, 10]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
*/
