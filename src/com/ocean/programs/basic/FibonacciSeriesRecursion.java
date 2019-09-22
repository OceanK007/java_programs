package com.ocean.programs.basic;

import java.util.Scanner;

/** 
	Fibonacci Series = a series of numbers in which each number is the sum of the two preceding numbers. The simplest is the series 1, 1, 2, 3, 5, 8, etc.
	Fn = Fn-1 + Fn-2
	
	Sample Input:
	5		(length of series to populate)
	1 2		(first and second number of series)
	
	Sample Output: 
	1,2,3,5,8,13,21
**/
public class FibonacciSeriesRecursion 
{
	static Integer length = 0;
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		length = scanner.nextInt();
		Integer firstElement = scanner.nextInt();
		Integer secondElement = scanner.nextInt();
		
		System.out.println(firstElement);
		System.out.println(secondElement);
		
		fibonacciSeries(firstElement, secondElement);
	}
	
	public static void fibonacciSeries(int n1, int n2)
	{
		System.out.println(n1+n2);
		
		length--;
		if(length == 0)
			return ;
		
		fibonacciSeries(n2, n1+n2);
	}
}