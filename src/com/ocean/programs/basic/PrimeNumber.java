package com.ocean.programs.basic;

import java.util.Scanner;

/**
Prime Number: A number that is divisible only by itself and 1 (e.g. 2, 3, 5, 7, 11)
**/
public class PrimeNumber 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer number = scanner.nextInt();
		
		boolean isPrime = true;
		for(int i=2;i<number-1;i++)
		{
			if(number%i == 0)
			{
				System.out.println("Not a prime number");
				isPrime = false;
				break;
			}
		}
		
		if(isPrime == true)
		{
			System.out.println("Prime number");
		}
	}
}
