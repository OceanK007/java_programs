package com.ocean.programs.logical;

import java.util.Scanner;

/**
Input: 22
Output: 00010110

 * Binary Format : 2^7,2^6,2^5,2^4,2^3,2^2,2^1,2^0	== 128,64,32,16,8,4,2,1
 * Binary format of 192	: 11000000
 * Binary format of 168	: 10101000
 * Binary format of 10 	: 00001010
 * Binary format of 15	: 00001111
**/
public class ConvertNumberToBinary 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		System.out.println("Binary Format: "+convertToBinary(number));
	}
	
	public static String convertToBinary(int number)
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i=7;i>=0;i--)
		{
			int powerOf2 = (int) Math.pow(2, i);
			if(powerOf2 > number)
			{
				sb.append("0");
			}
			else
			{
				sb.append("1");
				number = number - powerOf2;
			}
		}
		return sb.toString();
	}
}
