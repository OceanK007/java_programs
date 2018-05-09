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
		
		// System.out.println(Arrays.toString(asciiArray));
		
		Integer target = 0;
		Integer format = 1;
		// 1 = 49 = 49 - 48 = 1 => 1 x 100 = 100
		// 2 = 50 = 50 - 48 = 2 => 2 x 10 = 20
		// 3 = 51 = 51 - 48 = 3 => 3 x 1 = 3
		// 100 + 20 + 3 = 123
		for(int i=asciiArray.length-1;i>=0;i--)
		{
			target = target + ((asciiArray[i]-48) * format) ;
			
			format= format*10;
		}
		
		System.out.println(target);
	}
}