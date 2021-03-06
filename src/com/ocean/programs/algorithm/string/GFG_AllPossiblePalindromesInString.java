package com.ocean.programs.algorithm.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sample Input: 
 * nitin
 * 
 * Output: 
 * n i t i n
 * n iti n
 * nitin
 * 
 * Sample Input:
 * geeks
 * 
 * Output:
 * g e e k s
 * g ee k s
**/
public class GFG_AllPossiblePalindromesInString 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.next();
		String[] stringArray = source.split("");
		
		ArrayList<String> possiblePalindromes = new ArrayList<String>();
		
		boolean isPalindrome = true;
		for(int i=0;i<stringArray.length;i++)
		{
			String temp = "";
			for(int j=0;j<stringArray.length;j++)
			{
				temp = temp+stringArray[j];
				
				isPalindrome = isPalindrome(temp);
				
				if(isPalindrome == true)
					possiblePalindromes.add(temp);
			}
		}
		
		System.out.println(possiblePalindromes);
	}
	
	public static boolean isPalindrome(String source)
	{
		boolean isPalidrome = true;
		String[] stringArray = source.split("");
		StringBuilder target = new StringBuilder();
		
		for(int i=stringArray.length-1;i>=0;i--)
		{
			target.append(stringArray[i]);
		}
		
		if(source.equals(target.toString()))
			isPalidrome = true;
		else
			isPalidrome = false;
		
		return isPalidrome;
	}
}

// Status : still incomplete