package com.ocean.programs.basic;

import java.util.Scanner;

/** 
	Fibonacci Series = a series of numbers in which each number is the sum of the two preceding numbers. The simplest is the series 1, 1, 2, 3, 5, 8, etc.
	
	Sample Input:
	5		(length of series to populate)
	1 2		(first and second number of series)
	
	Sample Output: 
	1,2,3,5,8,13,21
**/
public class FibonacciSeries 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer length = scanner.nextInt();
		Integer firstElement = scanner.nextInt();
		Integer secondElement = scanner.nextInt();
		
		StringBuilder sb = new StringBuilder().append(firstElement).append(",").append(secondElement);
		
		Integer sum = null;
		for(int i=0;i<length;i++)
		{
			sum = firstElement+secondElement;
			firstElement = secondElement;
			secondElement = sum;
					
			sb.append(",").append(sum);
		}
		
		System.out.println(sb.toString());
	}
}