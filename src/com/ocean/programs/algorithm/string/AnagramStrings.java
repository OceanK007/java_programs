package com.ocean.programs.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

/** 
 An anagram of a string is another string that contains same characters, 
 only the order of characters can be different. 
 For example, “abcd” and “dabc” are anagram of each other.
 
 Anagram words:
 LISTEN - SILENT
 TRIANGLE - INTEGRAL
 
 Non anagrams:
 asdee - asdss
 */
public class AnagramStrings 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first string: ");
		String s1 = scanner.nextLine();
		System.out.print("Enter second string: ");
		String s2 = scanner.nextLine();
		
		System.out.println(s1+ " & "+s2+" are anagrams? : "+checkAnagrams(s1,s2));
		System.out.println(s1+ " & "+s2+" are anagrams? : "+checkAnagrams2(s1,s2));
		System.out.println(s1+ " & "+s2+" are anagrams? : "+checkAnagrams3(s1,s2));
	}
	
	// Approach 1:
	public static boolean checkAnagrams(String s1, String s2)
	{
		boolean isAnagram = true;
		
		if(s1.length() != s2.length())
			return false;
		
		for(int i=0;i<s1.length();i++)
		{
			char currentChar = s1.charAt(i);
						
			if(s2.indexOf(currentChar) == -1)
			{
				return false;
			}
			else
			{
				s2 = s2.substring(0,s2.indexOf(currentChar))+s2.substring(s2.indexOf(currentChar)+1);	// removing the char from s2
				//System.out.println(s2);
			}
		}
		
		return isAnagram;
	} 
	
	// Approach 2:
	public static boolean checkAnagrams2(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		
		char[] aArray = s1.toLowerCase().toCharArray();
        char[] bArray = s2.toLowerCase().toCharArray();
        Arrays.sort(aArray);
        Arrays.sort(bArray);

        if(String.valueOf(aArray).equals(String.valueOf(bArray)))
            return true;
        else
            return false;
	} 
	
	// Approach 3:
	public static boolean checkAnagrams3(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		
		int[] aArray = new int[26];
		int[] bArray = new int[26];

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		for(int i=0;i<s1.length();i++)
		{
			int a = (int) s1.charAt(i) - (int) 'a';
			int b = (int) s2.charAt(i) - (int) 'a';
			
			aArray[a] = aArray[a] + 1;
			bArray[b] = bArray[b] + 1;
		}
		
		for(int i=0;i<26;i++)
		{
			if(aArray[i] != bArray[i])
				return false;
		}
		
		return true;
	} 
}