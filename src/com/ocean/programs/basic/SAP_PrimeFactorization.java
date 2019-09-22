package com.ocean.programs.basic;

import java.util.*;

/**
 * Return an array containing prime numbers whose product is x
 * Examples:
 * primeFactorization( 6 ) == [2,3]
 * primeFactorization( 5 ) == [5]
 */

public class SAP_PrimeFactorization
{
	
	public static List<Integer> primeFactorization(int x)
	{
		if(isPrime(x))
			return Arrays.asList(x);
		else
		{	
			List<Integer> list = new ArrayList<>();
			while(true)
			{
				if((x % 2 == 0))
				{
					list.add(2);
					int quotient = x/2;
					
					if(isPrime(quotient))
					{
						list.add(quotient);
						break;
					}
					else 
					{
						x = quotient;
					}
					
				}
			}
			
			return list;
		}
  	}
	
	public static boolean isPrime(int num)
	{
		if(num == 1)
			return false;
		
		boolean isPrime = true;
		for(int i=2;i<num-1;i++)
		{
			if(num%i == 0)
			{
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}

  	public static void main(String args[])
  	{
	
		boolean result = true;
		result = result & primeFactorization(6).equals(Arrays.asList(2,3));
		result = result & primeFactorization(5).equals(Arrays.asList(5));
		result = result & primeFactorization(12).equals(Arrays.asList(2,2,3));
		
		if(result) 
		{
			System.out.println("All passed");
		}
		else 
		{
			System.out.println("Failed");
		}
  }
}