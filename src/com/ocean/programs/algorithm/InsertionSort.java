package com.ocean.programs.algorithm;

import java.util.Arrays;

/**
Example: 
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13
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
				//System.out.println("After sorting: "+Arrays.toString(arr));
			}
		}
	}
}
