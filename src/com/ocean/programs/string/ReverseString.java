package com.ocean.programs.string;

import java.util.Scanner;

/**
Input: Hello
Output: olleH
**/
public class ReverseString 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		
		reverseString(source);
	}
	
	public static void reverseString(String source)
	{
		char[] charArray = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=charArray.length-1;i>=0;i--)
		{
			sb.append(charArray[i]);
		}
		
		System.out.println(sb.toString());
	}
	
	/*public static void reverseString(String source)
	{
		StringBuilder sb = new StringBuilder(source);
		System.out.println(sb.reverse());
	}*/
}
