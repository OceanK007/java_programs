package com.ocean.programs.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

/** Given a array of n strings, find the longest common prefix among all strings present in the array.
 
Input:
Each test case contains an integer n. Next line has space separated n strings. 

Output:
Print the longest common prefix as a string in the given array. If no such prefix exists print "-1"(without quotes).
 
Input:
4
geeksforgeeks geeks geek geezer 

Output:
gee
**/
public class GFG_LongestCommonPrefix 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int arraySize = scanner.nextInt();
		String[] stringArray = new String[arraySize];
		for(int i=0;i<arraySize;i++)
		{
			stringArray[i] = scanner.next();
		}
		
		//System.out.println(Arrays.toString(stringArray));
		
		longestCommonPrefix(stringArray);
	}
	
	public static void longestCommonPrefix(String[] stringArray)
	{
		String commonPrefix = "";
		String sourceString = stringArray[0];
		
		for(int i=0;i<sourceString.length();i++)
		{
			boolean hasCommon = true;
			
			for(int j=1;j<stringArray.length;j++)
			{
				String checkString = stringArray[j];
				if(!String.valueOf(checkString.charAt(i)).equals(String.valueOf(sourceString.charAt(i))))
				{
					hasCommon = false;
					break;
				}
			}
			
			if(hasCommon == true)
			{
				commonPrefix = commonPrefix + sourceString.charAt(i);
			}
			else
			{
				break;
			}
		}
		
		System.out.println(commonPrefix);
	}
}
