package com.ocean.programs.string;

import java.util.LinkedList;
import java.util.List;

/*
 *  An anagram of a string is another string that contains same characters, 
	only the order of characters can be different. 
	For example, “abcd” and “dabc” are anagram of each other.
	 
	Anagram words:
	LISTEN - SILENT
	TRIANGLE - INTEGRAL
	 
	Non anagrams:
	asdee - asdss
 
 	This program prints set of anagrams together in given string 
  
  	eg. 
  	setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 */

class SAP_AnagramGrouping 
{
	public static void main(String[] args) 
	{
	    boolean result = true;
	    result = result & (setOfAnagrams("cat dog tac sat tas god dog").equals("cat tac dog god dog sat tas"));
	    
	    if(result)
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	}
	  	  
	static String setOfAnagrams(String inputString)
	{ 
		String[] strArray = inputString.split(" ");
		List<String> resultList = new LinkedList<>();
		
		for(int i=0;i<strArray.length;i++)
		{
			String srcString = strArray[i];
			
			if(!resultList.contains(srcString))
			{
				resultList.add(srcString);
				for(int j=i+1;j<strArray.length;j++)
				{
					if(isAnagram(srcString, strArray[j]))
					{
						resultList.add(strArray[j]);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(String s : resultList)
		{
			sb.append(s).append(" ");
		}
		System.out.println(sb.toString().trim());
		return sb.toString().trim();
	}
	  
	static boolean isAnagram(String s1, String s2) 
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
}