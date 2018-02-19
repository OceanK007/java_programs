package com.ocean.programs.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
Sample Input:
ereraeb

Output:
e 3
r 2
a 1
b 1
**/

public class FrequencyOfAllChar 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		frequencyOfChars(string);
	}
	
	public static void frequencyOfChars(String source)
	{
		String[] stringArray = source.split("");
		
		StringBuilder alreadyCalculatedString = new StringBuilder();
		
		for(int i=0;i<stringArray.length;i++)
		{
			Integer counter = 1;
			if(!alreadyCalculatedString.toString().contains(stringArray[i]))
			{
				for(int j=0;j<stringArray.length;j++)
				{
					if(i!=j)
					{
						if(stringArray[i].equals(stringArray[j]))
						{
							counter = counter +1;
						}
					}
				}
				
				alreadyCalculatedString.append(stringArray[i]);
				
				System.out.println(stringArray[i]+" "+counter);
			}
		}
	}
	
	/** Using Map **/
	/*public static void frequencyOfChars(String source)
	{
		String[] stringArray = source.split("");
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		for(int i=0;i<stringArray.length;i++)
		{
			if(map.get(stringArray[i]) == null) // map.get() will return the value of key
				map.put(stringArray[i], 1);
			else
				map.put(stringArray[i], map.get(stringArray[i])+1);
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}*/
}
