package com.ocean.programs.collection;

import java.util.Scanner;

/**
	Input: 
	6
	1 10 34 54 9 3
	
	6 displays the total number of elements
	
	Output: 54
**/
public class BiggestElementInArray 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int[] intArray = new int[scanner.nextInt()];
		
		for(int i=0;i<intArray.length;i++)
		{
			intArray[i] = scanner.nextInt();
		}
		
		int biggestElement = Integer.MIN_VALUE;
		for(int i=0;i<intArray.length;i++)
		{
			if(intArray[i] > biggestElement)
			{
				biggestElement = intArray[i];
			}
		}
		
		System.out.println(biggestElement);
	}
}
