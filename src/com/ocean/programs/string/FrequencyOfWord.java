package com.ocean.programs.string;

import java.util.Scanner;

/**
Sample Input: 
hellohowareyouhellosldhellosldjhello
hello		// Word to search the frequency for

Sample Output:
4
**/
public class FrequencyOfWord 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.next();
		String word = scanner.next();
		
		frequencyOfWord(source, word);
	}
	
	public static void frequencyOfWord(String source, String word)
	{
		int frequency = 0;
		
		for(int i=0;i>=0;i++)
		{
			if(source.contains(word))
			{
				frequency = frequency+1;
				source = source.substring(source.indexOf(word)+word.length());	
			}
			else
			{
				break;
			}
		}
		
		System.out.println(frequency);
	}
}
