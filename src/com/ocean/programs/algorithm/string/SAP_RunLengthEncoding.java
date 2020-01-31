package com.ocean.programs.algorithm.string;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "wwwwaaadexxxxxx" -> “w4a3d1e1x6”
 */

public class SAP_RunLengthEncoding 
{
	public static void main(String[] args) 
	{
		boolean result = true;
		
		result = result & "".equals(rle(""));
		result = result & "a1".equals(rle("a"));
		result = result & "a3".equals(rle("aaa"));
		result = result & "w4a3d1e1x6".equals(rle("wwwwaaadexxxxxx"));
		if(result)
		{
			  System.out.println("Passed");
		}
		else 
		{
			  System.out.println("Failed");
		}
	}
	
	public static String rle(String input)
	{
		char[] charArray = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<charArray.length;)
		{
			char source = charArray[i];
			int length = 1;
			
			int count = i+1;
			while(true)
			{
				if(count < charArray.length && charArray[count] == source)
				{
					length++;
					count++;
				}
				else
				{
					break;
				}
			}
			
			i = i+length;
			sb.append(source).append(length);
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}
}