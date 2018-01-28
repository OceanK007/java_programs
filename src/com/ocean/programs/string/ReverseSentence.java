package com.ocean.programs.string;

import java.util.Scanner;

/**
	Sample Input: I Live In India
	Output: India In Live I
**/
public class ReverseSentence 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		String[] stringArray = source.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = stringArray.length-1 ; i>=0 ; i--)
		{
			sb.append(stringArray[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}