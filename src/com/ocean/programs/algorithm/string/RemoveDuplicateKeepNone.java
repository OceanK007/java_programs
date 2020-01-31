package com.ocean.programs.algorithm.string;

import java.util.Scanner;

/**
 	Sample Input = ereraeb
 	Output = ab
**/
public class RemoveDuplicateKeepNone 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		char[] charArray = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<charArray.length;i++)
		{
			Integer counter = 1;
			for(int j=0;j<charArray.length;j++)
			{
				if(i!=j)
				{
					if(charArray[i] == charArray[j])
					{
						counter = counter +1;
					}
				}
			}
			
			if(counter == 1)
			{
				sb.append(String.valueOf(charArray[i]));
			}
		}
		
		System.out.println(sb.toString());
	}
}