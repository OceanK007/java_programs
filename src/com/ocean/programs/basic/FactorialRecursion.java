package com.ocean.programs.basic;

import java.util.Scanner;

/**
5! = 5*4*3*2*1 = 120
**/
public class FactorialRecursion 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer number = scanner.nextInt();
		
		System.out.println("Factorial: "+calculateFactorial(number));
	}
	
	public static Integer calculateFactorial(Integer number)
	{
		if(number == 1)		// Recursion break condition
			return 1;
		
		return number * calculateFactorial(number-1);
	}
}
