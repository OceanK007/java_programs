package com.ocean.programs.basic;

import java.util.Scanner;

/**
The following years are leap years: 1600, 2000, 2400, 2016
The following years are not leap years: 1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600, 2018
**/
public class LeapYear 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer year = scanner.nextInt();
		
		if(year%400 == 0 || (year%4==0 && year%100 != 0))
		{
			System.out.println("Leap Year");
		}
		else
		{
			System.out.println("Not a leap year");
		}
	}
}