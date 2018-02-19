package com.ocean.programs.basic;

import java.util.Scanner;

/**
5! = 5*4*3*2*1 = 120
**/
public class Factorial 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer number = scanner.nextInt();
		
		System.out.println("Factorial: "+calculateFactorial(number));
	}
	
	/*public static Integer calculateFactorial(Integer number)
	{
		Integer result = 1;
		for(int i = number; i>0; i--)
		{
			result = result * i;
		}
		
		return result;
	}*/
	
	// Using recursion
	public static Integer calculateFactorial(Integer number)
	{
		if(number > 1)
		{
			number = number * calculateFactorial(number-1);
		}
		
		return number;
	}
}
