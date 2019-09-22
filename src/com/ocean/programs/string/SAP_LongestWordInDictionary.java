package com.ocean.programs.string;

import java.util.*;

//Given a a string of letters and a dictionary, the function longestWord should
//find the longest word or words in the dictionary that can be made from the letters
//Input: letters = "oet", dictionary = {"to","toe","toes"}
//Output: {"toe"}

public class SAP_LongestWordInDictionary 
{
	public static void main(String[] args) 
	{
		if(pass()) 
		{
			System.out.println("Pass");
		} 
		else 
		{
			System.err.println("Fails");
		}
	}
	
	public static boolean pass() 
	{
		Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
		
		boolean result = true;
		result = result & new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
		result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
	    result = result && new HashSet<String>(Arrays.asList("toe", "doe", "dog", "god")).equals(longestWord("oetdg", dict));
	    result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
	    result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
	    result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
	    result = result && new HashSet<String>().equals(longestWord("a", dict));
		return result;
	}
	
	public static Set<String> longestWord(String letters, Dictionary dict) 
	{
		Set<String> result = new LinkedHashSet<String>();
		String[] dictWords = dict.getEntries();
		int wordLength = Integer.MIN_VALUE;
		for(int i=0;i<dictWords.length;i++)
		{
			char[] wordLetterFromDict = dictWords[i].toCharArray();
			boolean allLettersFound = true;
			for(int j=0;j<wordLetterFromDict.length;j++)
			{
				if(letters.indexOf(wordLetterFromDict[j]) == -1)
				{
					allLettersFound = false;
					break;
				}
			}
			
			if(allLettersFound == true)
			{
				result.add(dictWords[i]);
				if(dictWords[i].length() >= wordLength)
				{
					wordLength = dictWords[i].length();
				}
			}
			
			Iterator<String> iterator = result.iterator();
			while(iterator.hasNext())
			{
				String s = iterator.next();
				if(s.length() < wordLength)
				{
					iterator.remove();
				}
			}
		}
		
		//System.out.println(result);
		return result;
	}
}

class Dictionary 
{
	  private String[] entries;

	  public Dictionary(String[] entries) 
	  {
	    this.entries = entries;
	  }

	  public boolean contains(String word) 
	  {
	    return Arrays.asList(entries).contains(word);
	  }
	  
	  public String[] getEntries() {
		  return entries;
	  }
}