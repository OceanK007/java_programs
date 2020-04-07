package com.ocean.programs.algorithm.sort;

import java.util.Arrays;

/**
Insertion sort works in the similar way as we sort cards in our hand in a card game.

We assume that the first card is already sorted then, we select an unsorted card. 
If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left. 
In the same way, other unsorted cards are taken and put at their right place.

Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.

The first element in the array is assumed to be sorted. Take the second element and store it separately in key.
 
Time Complexity: O(n2)
**/
public class InsertionSort 
{
	public static void main(String[] args) 
	{
		//int arr[] = {10,34,2,56,7,67,88,42};
		int arr[] = {1,4,3,5,6,2};
		
		System.out.println("Before sorting: "+Arrays.toString(arr));
		sortElements(arr);
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void sortElements(int arr[])
	{
        for (int i = 1; i < arr.length; i++) 
        { 
            int key = arr[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position */
            while (j >= 0 && arr[j] > key) 
            { 
                arr[j+1] = arr[j]; 
                j--; 
                
                System.out.println(Arrays.toString(arr));
            } 
            arr[j+1] = key; 
            System.out.println(Arrays.toString(arr));
        } 
	}
}

/* 
[10, 34, 2, 56, 7, 67, 88, 42]
[10, 34, 34, 56, 7, 67, 88, 42]
[10, 10, 34, 56, 7, 67, 88, 42]
[2, 10, 34, 56, 7, 67, 88, 42]
[2, 10, 34, 56, 7, 67, 88, 42]
[2, 10, 34, 56, 56, 67, 88, 42]
[2, 10, 34, 34, 56, 67, 88, 42]
[2, 10, 10, 34, 56, 67, 88, 42]
[2, 7, 10, 34, 56, 67, 88, 42]
[2, 7, 10, 34, 56, 67, 88, 42]
[2, 7, 10, 34, 56, 67, 88, 42]
[2, 7, 10, 34, 56, 67, 88, 88]
[2, 7, 10, 34, 56, 67, 67, 88]
[2, 7, 10, 34, 56, 56, 67, 88]
[2, 7, 10, 34, 42, 56, 67, 88] 
*/
