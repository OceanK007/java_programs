package com.ocean.programs.basic;

import java.util.Scanner;

/** 
	A palindromic number or numeral palindrome is a number that remains the same when its digits are reversed. Like 16461
**/
public class Palindrome 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		
		char[] charArray = number.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i=charArray.length-1;i>=0;i--)
		{
			sb.append(charArray[i]);
		}
		
		if(number.equals(sb.toString()))
		{
			System.out.println("Palindrome Number");
		}
		else
		{
			System.out.println("Not a palindrome number");
		}
	}
}
