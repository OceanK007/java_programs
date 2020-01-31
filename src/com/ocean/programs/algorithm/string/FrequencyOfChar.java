package com.ocean.programs.algorithm.string;

import java.util.Scanner;

/**
	Sample Input:
	ereraeb
	e			// char to find the frequency
	
	Output:
	3
**/

public class FrequencyOfChar 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		String targetChar = scanner.next();
		
		String[] stringArray = string.split("");
		
		Integer frequency = 0;
		for(int i=0;i<stringArray.length;i++)
		{
			if(stringArray[i].equals(targetChar))
			{
				frequency = frequency+1;
			}
		}
		
		System.out.println("Frequency: "+frequency);
	}
}
