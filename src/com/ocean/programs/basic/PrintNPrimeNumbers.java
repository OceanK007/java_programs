package com.ocean.programs.basic;

import java.util.ArrayList;
import java.util.Scanner;

/**
Prime Number: A number that is divisible only by itself and 1 (e.g. 2, 3, 5, 7, 11)

Sample Input:
20		// How many prime numbers to display

Sample Output:
[1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
**/
public class PrintNPrimeNumbers 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		int counter = 1;
		
		boolean isBoolean = false;
		for(int i=0;i>=0;i++)
		{
			if(primeNumbers.size() >= size)
				break;
			
			isBoolean = checkPrimeNumber(counter);
			
			if(isBoolean == true)
				primeNumbers.add(counter);
			
			counter = counter+1;
		}
		
		System.out.println(primeNumbers);
	}
	
	public static boolean checkPrimeNumber(int number)
	{
		boolean isPrime = true;
		
		for(int i=2;i<number-1;i++)
		{
			if(number%i==0)
			{
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
}