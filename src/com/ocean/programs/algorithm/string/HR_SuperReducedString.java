package com.ocean.programs.algorithm.string;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

/**

Sample Input 
aaabccddd

Sample Output 
abd

-----------------------

Sample Input 
baab
  
Sample Output 
Empty String

-----------------------

Sample Input 
acdqglrfkqyuqfjkxyqvnrtysfrzrmzlygfveulqfpdbhlqdqrrqdqlhbdpfqluevfgylzmrzrfsytrnvqyxkjfquyqkfrlacdqj
  
Sample Output 
acdqgacdqj

**/

public class HR_SuperReducedString 
{
	public static String reducedString = "";
	
	public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        if(result.length() > 0)
            System.out.println(result);
        else
            System.out.println("Empty String");
    }
		
	/** Using recursion **/
	static String super_reduced_string(String text)
	{
		if(text.equals(reducedString))
			return text;
		
		boolean anyDuplicate = false;
		for(int i=0;i<text.length();i++)
		{
			if((i+1 < text.length()) && (text.charAt(i) == text.charAt(i+1)))
			{
				anyDuplicate = true;
				text =text.substring(0, i) +((i+2 < text.length()) ? text.substring(i+2) : "");
				break;
			}
		}
		
		if(anyDuplicate == false)
		{
			reducedString = text;
		}
		
		return super_reduced_string(text);
    }
	
	/** Using infinite loop **/
	/*public static String superReducedString(String text)
	{
		String reducedString = "";
		boolean anyDuplicate = false;
		int i = 0;
		while(true)
		{
			if(text.equals(reducedString))
				break;
			
			if((i+1 < text.length()) && (text.charAt(i) == text.charAt(i+1)))
			{
				text =text.substring(0, i) +((i+2 < text.length()) ? text.substring(i+2) : "");
				i=0;
				anyDuplicate = true;
			}
			else
			{
				i++;
				anyDuplicate = false;
			}
			
			if((i==text.length()-1) && anyDuplicate == false)
			{
				reducedString = text;
			}
		}
		
		return reducedString;
	}*/

	/** it will fail on 
	  	input: baab 
	  	output: bb 
	  	expected output: Empty String **/
	/*static String super_reduced_string(String s)
	{
        String result = "";
        char[] charArray = s.toCharArray();
        
        boolean needToContinue = false;
        for(int i=0;i<charArray.length;i++)
        {
           if(needToContinue == true)
           {
               needToContinue = false;
               continue;
           }
           if(((i+1) < charArray.length) && charArray[i] == charArray[i+1])
           {
               needToContinue = true;
               continue;
           }
           else
           {
               result = result+String.valueOf(charArray[i]);
           }
        }
        
        return result;
    }*/
	
	/** it will fail on 
	 	input: acdqglrfkqyuqfjkxyqvnrtysfrzrmzlygfveulqfpdbhlqdqrrqdqlhbdpfqluevfgylzmrzrfsytrnvqyxkjfquyqkfrlacdqj 
	  	output: gj 
		expected output: acdqgacdqj **/
	/*static String super_reduced_string(String s)
	{
        String result = "";
        char[] charArray = s.toCharArray();
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<charArray.length;i++)
        {
            if(map.containsKey(String.valueOf(charArray[i])))
            {
                Integer count = map.get(String.valueOf(charArray[i]));
                count += 1;
                map.put(String.valueOf(charArray[i]), count);
            }
            else
            {
                map.put(String.valueOf(charArray[i]), 1);
            }
        }
        for(Map.Entry<String, Integer> entrySet : map.entrySet())
        {
            if(entrySet.getValue() % 2 != 0)
            {
                result = result + entrySet.getKey();
            }
        }
        
        return result;
    }*/
}
