package com.ocean.programs.string;

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

public class SuperReducedString 
{
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
	
	static String super_reduced_string(String s)
	{
        char[] charArray = s.toCharArray();
        
        String result = "";
        
        List<String> list = new LinkedList<String>();
        for(int i=0;i<charArray.length;i++)
        {
        	list.add(String.valueOf(charArray[i]));
        }
        
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext())
        {
        	String first = listIterator.next();
        	String second = listIterator.next();
        	
        	if(first.equals(second))
        	{
        		
        	}
        	
        }
        
        return result;
    }
	
	/** Best solution: Either use recursion or listIterator **/
	/*static String super_reduced_string(String s)
	{
        char[] charArray = s.toCharArray();
        
        String result = "";
        
        for(int i=0;i<charArray.length;i++)
        {
            if(((i+1) < charArray.length) && charArray[i] == charArray[i+1])
            {
                String temp = s.substring(i+2, s.length());
                result = result+temp;
                
                return super_reduced_string(result);
            }
            else
            {
                result = result+charArray[i];
                
                if(s.equals(result))
                {
                    return result;
                }
            }
        }
        return result;
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
