package com.ocean.programs.algorithm.string;

import java.util.Scanner;

/**
Given a string, recursively remove adjacent duplicate characters from string. The output string should not have any adjacent duplicates.
 
Input:
The first line of input contains an integer T denoting the no of String to check for duplicates. Then T test cases follow. Each test case contains an string str.

Output:For each test case output a new line containing the resulting string.

Example:

Input:
geeksforgeek
Output:
gksforgk

Input:
acaaabbbacdddd
Output:
acac
**/

public class GFG_RemoveAdjacentDuplicates 
{
	public static String reducedString = "";
	
	public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = superReducedString(s);
        if(result.length() > 0)
            System.out.println(result);
        else
            System.out.println("Empty String");
    }
		
	/** Using recursion **/
	static String superReducedString(String text)
	{
		if(text.equals(reducedString))
			return text;
		
		boolean anyAdjacentDuplicate = false;
		for(int i=0;i<text.length();i++)
		{
			if((i+1 < text.length()) && (text.charAt(i) == text.charAt(i+1)))
			{
				anyAdjacentDuplicate = true;
				int duplicateCharsLength = duplicateCharsLength(text.charAt(i), text.substring(i));
				text =text.substring(0, i) +((i+duplicateCharsLength < text.length()) ? text.substring(i+duplicateCharsLength) : "");
				break;
			}
		}
		
		if(anyAdjacentDuplicate == false)
		{
			reducedString = text;
		}
		
		return superReducedString(text);
    }
	
	static int duplicateCharsLength(char c, String text)
	{
		int length =0;
		for(int i=0;i<text.length();i++)
		{
			if(String.valueOf(text.charAt(i)).equals(String.valueOf(c)))
			{
				length += 1;
			}
			else
				break;
		}
		
		return length;
	}
	
	/** Using infinite loop **/
	/*public static String superReducedString(String text)
	{
		String reducedString = "";
		boolean anyAdjacentDuplicate = false;
		int i = 0;
		while(true)
		{
			if(text.equals(reducedString))
				break;
			
			if((i+1 < text.length()) && (text.charAt(i) == text.charAt(i+1)))
			{
				int duplicateCharsLength = duplicateCharsLength(text.charAt(i), text.substring(i));
				text =text.substring(0, i) +((i+duplicateCharsLength < text.length()) ? text.substring(i+duplicateCharsLength) : "");
				i=0;
				anyAdjacentDuplicate = true;
			}
			else
			{
				i++;
				anyAdjacentDuplicate = false;
			}
			
			if((i==text.length()-1) && anyAdjacentDuplicate == false)
			{
				reducedString = text;
			}
		}
		
		return reducedString;
	}*/
}
