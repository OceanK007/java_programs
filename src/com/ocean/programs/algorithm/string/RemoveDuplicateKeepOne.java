package com.ocean.programs.algorithm.string;

import java.util.Scanner;

/**
 	Sample Input = ereraeb
 	Output = erab
**/
public class RemoveDuplicateKeepOne 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		char[] charArray = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<charArray.length;i++)
		{
			if(!sb.toString().contains(String.valueOf(charArray[i])))
			{
				sb.append(charArray[i]);
			}
		}
		
		System.out.println(sb.toString());
	}
}