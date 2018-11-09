package com.ocean.programs.string;

import java.util.Scanner;

/**
Input: Hello How Are You
Output: olleH woH erA uoY
**/
public class ReverseWords 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		
		reverseWord(source);
	}
	
	public static void reverseWord(String source)
	{
		String[] stringArray = source.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(String s : stringArray)
		{
			sb.append(reverseString(s)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static String reverseString(String source)
	{
		char[] charArray = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=charArray.length-1;i>=0;i--)
		{
			sb.append(charArray[i]);
		}
		
		return sb.toString();
	}
	
	/*public static void reverseString(String source)
	{
		StringBuilder sb = new StringBuilder(source);
		return sb.reverse();
	}*/
}
