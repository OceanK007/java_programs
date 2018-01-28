package com.ocean.programs.string;

import java.util.Scanner;

/**
 	Sample Input: e3re4r2a2sd38r
 	Sample Output: 342238
**/
public class FindNumber 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		char[] charArray = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<charArray.length;i++)
		{
			try
			{
				Integer number = Integer.valueOf(String.valueOf(charArray[i]));
				//int number = charArray[i];		// Will give ASCII value of each char, so don't use it
				sb.append(number);
			}
			catch(Exception ex)
			{
				//System.out.println(charArray[i]+" is not a number");
			}
		}
		
		System.out.println(sb.toString());
	}
}
