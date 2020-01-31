package com.ocean.programs.algorithm.string;

import java.util.Scanner;

/**
 input: 
 	2
 	geeksforgeek
	acaaabbbacdddd

 Output:
	gksforgk
	acac
**/

public class GFG_RecursivelyRemoveAjdacentDuplicates 
{
	public static String reducedString = "";
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String[] stringArray = new String[scanner.nextInt()];
		
		for(int i=0;i<stringArray.length;i++) {
			stringArray[i] = scanner.next();
		}
		
		//System.out.println(stringArray.length);
		
		for(String s : stringArray) {
			reducedString = "";
			System.out.println(superRreducedString(s));
		}
	}
	
	static String superRreducedString(String text)
	{
		if(text.equals(reducedString))
			return text;
		
		boolean anyDuplicate = false;
		Integer initialCharIndex = null;
		int duplicateCharsCount = 0;
		boolean duplicateOccurred = false;
		
		for(int i=0;i<text.length();i++)
		{
			
			if(anyDuplicate == false && duplicateOccurred == true)
			{
				break;
			}
			
			if((i+1 < text.length()) && (text.charAt(i) == text.charAt(i+1)))
			{
				if(duplicateOccurred == false) {
					anyDuplicate = true;
					duplicateOccurred = true;
					initialCharIndex = new Integer(i);
				}
				
				duplicateCharsCount++;
				//text = text.substring(0, i) +((i+2 < text.length()) ? text.substring(i+2) : "");
			}
			else
			{
				anyDuplicate = false;
			}
		}
		
		//System.out.println(initialCharIndex);
		//System.out.println(duplicateCharsCount);
		
		if(initialCharIndex != null || duplicateCharsCount != 0) 
		{
			text = text.substring(0, initialCharIndex) +((initialCharIndex+(duplicateCharsCount+1) < text.length()) ? text.substring(initialCharIndex+duplicateCharsCount+1) : "");
			//System.out.println(text);
		}
		
		if(anyDuplicate == false && duplicateOccurred == false)
		{
			reducedString = text;
		}
		
		return superRreducedString(text);
    }
}
