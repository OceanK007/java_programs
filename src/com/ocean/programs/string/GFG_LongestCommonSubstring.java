package com.ocean.programs.string;

import java.util.Scanner;

/** Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 
Examples :
Input : X = "GeeksforGeeks", y = "GeeksQuiz"
Output : 5
The longest common substring is "Geeks" and is of length 5.
 
Input : X = "abcdxyz", y = "xyzabcd"
Output : 4
The longest common substring is "abcd" and is of length 4.
 
Input : X = "zxabcdezy", y = "yzabcdezx"
Output : 6
The longest common substring is "abcdez" and is of length 6.
 
Output:
For each test case print the length of longest  common substring of the two strings **/

public class GFG_LongestCommonSubstring 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("X = ");
		String x = scanner.nextLine();
		System.out.print("Y = ");
		String y = scanner.nextLine();
		
		if(x.length() > y.length())
			longestCommonSubstring(y, x);
		else
			longestCommonSubstring(x, y);
			
	}
	
	public static void longestCommonSubstring(String x, String y)
	{
		String longestString = "";
		int longestStringSize = 0;
		
		for(int i=0;i<x.length();i++)
		{
			String temp = "";
			for(int j=i;j<x.length();j++)
			{
				temp = temp + x.charAt(j);
				if(y.contains(temp))
				{
					if(temp.length() > longestStringSize)
					{
						longestString = temp;
						longestStringSize = temp.length();
					}
				}
			}
		}
		
		System.out.println("Longest String: "+longestString);
		System.out.println("Longest String Size: "+longestStringSize);
	}
}
