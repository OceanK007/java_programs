package com.ocean.programs.string;

import java.util.*;

/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

public class SAP_LongestUniformString 
{
  private static final Map<String, int[]> testCases = new LinkedHashMap<String, int[]>();

  public static void main(String[] args) 
  {
	testCases.put("", new int[]{-1, 0});
	testCases.put("10000111", new int[]{1, 4});
	testCases.put("aabbbbbCdAA", new int[]{2, 5});
	
	boolean pass = true;
	for(Map.Entry<String,int[]> testCase : testCases.entrySet())
	{
		int[] result = longestUniformSubstring(testCase.getKey());
		pass = pass && (Arrays.equals(result, testCase.getValue()));
	}
	if(pass)
	{
		System.out.println("Pass!");
	} 
	else 
	{
		System.out.println("Failed! ");
	}
  }
  
  static int[] longestUniformSubstring(String input)
  {
	int longestStart = -1;
	int longestLength = 0;
	Character longestChar = null;
	
	if(input != null && input.length() >0)
	{
		char[] charArray = input.toCharArray();
		int tempStart = 0;
		int tempLength = 1;
		Character tempChar = charArray[0];
				
		for(int i=1;i<charArray.length;i++) 
		{
			if(charArray[i] == tempChar)
			{
				tempLength = tempLength+1;
				//System.out.println(tempStart);
				//System.out.println(tempLength);
				//System.out.println(String.valueOf(tempChar));
				
				if(longestLength <= tempLength)
				{
					longestLength = tempLength;
					longestStart = tempStart;
					longestChar = tempChar;					
				}
			}
			else
			{
				tempStart = i;
				tempLength = 1;
				tempChar = charArray[i];
			}
		}
	}
	
	System.out.println("longestStart: "+ longestStart + " | longestLength: "+longestLength+" | longestChar: "+longestChar);
	
	return new int[]{ longestStart, longestLength };
  }
}
