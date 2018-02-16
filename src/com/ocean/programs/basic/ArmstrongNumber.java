package com.ocean.programs.basic;

import java.util.Scanner;

/** 
	371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371
**/
public class ArmstrongNumber 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		String[] stringArray = number.split("");
		
		Integer total = 0;
		for(int i=0;i<stringArray.length;i++)
		{
			Integer singleElement = 1;
			for(int j=0;j<stringArray.length;j++)
			{
				singleElement = singleElement * Integer.valueOf(stringArray[i]);
			}
			
			total = total + singleElement;
		}
		
		if(String.valueOf(total).equals(number))
		{
			System.out.println("Armstrong number");
		}
		else
		{
			System.out.println("Not Armstrong number");
		}
	}
}