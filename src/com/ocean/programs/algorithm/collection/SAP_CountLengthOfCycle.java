package com.ocean.programs.algorithm.collection;

import java.util.*;

/**
Each element of an int array points to the another element, eventually creating a cycle. Starting at array[0], find the length of the cycle.

Examples:

Input:
array = [1, 0]
Output:
2

Input:
array = [1, 2, 1]
Output:
2
Note how element 3 is not part of the cycle

Input:
array = [1, 3, 0, 4, 1]
Output:
3
Note how element 0 is used to find the cycle, but is not part of the cycle count.
**/
public class SAP_CountLengthOfCycle 
{
	public static void main(String[] args) 
	{

		boolean testsPassed = true;
		  
		testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
		testsPassed &= countLengthOfCycle(new int[]{1, 2, 1}, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[]{1, 3, 0, 4, 1}, 0) == 3;
		  
		if(testsPassed) {
		    System.out.println( "Test passed." );
		    //return true;
		} 
		else 
		{
		    System.out.println( "Test failed." );
		    //return false;
		}
	}
	
	public static int countLengthOfCycle(int[] arr, int startIndex) 
	{
		  Map<Integer, Integer> visited = new HashMap<>();
		  int count = 1;
		  int index = startIndex;
		  while(!visited.containsKey(index))
		  {
		    if(arr[index] > arr.length) return -1;
		    visited.put(index, count);
		    count++;
		    index = arr[index];
		  }
		  System.out.println(visited);
		  return count - visited.get(index);
	}
}
