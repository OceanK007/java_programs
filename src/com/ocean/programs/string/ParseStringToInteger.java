package com.ocean.programs.string;

import java.util.Arrays;

// Ascii code of 0 = 48, 1 = 49, 2=50 .. 9 = 57

public class ParseStringToInteger 
{
	public static void main(String[] args) 
	{
		String source = "123";
		
		char[] charArray = source.toCharArray();
		int[] asciiArray = new int[charArray.length];
		
		for(int i=0;i<charArray.length;i++)
		{
			asciiArray[i] = (int) charArray[i];
		}
		
		System.out.println(Arrays.toString(asciiArray));
		
		for(int i=0;i<asciiArray.length;i++)
		{
			
		}
	}
}