package com.ocean.programs.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
	Input: rereredferduodjfluerls
	Ouput: r
**/
public class MaxFrequencyChar 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		char[] charArray = source.toCharArray();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<charArray.length;i++)
		{
			if(map.containsKey(String.valueOf(charArray[i])))
			{
				Integer occurrence = map.get(String.valueOf(charArray[i]));
				map.put(String.valueOf(charArray[i]), occurrence+1);
			}
			else
			{
				map.put(String.valueOf(charArray[i]), 1);
			}
		}
		
		/*String result = null;
		Integer frequency = 0;
		
		for(Map.Entry<String, Integer> entrySet : map.entrySet())
		{
			if(entrySet.getValue() > frequency)
			{
				result = entrySet.getKey();
				frequency = entrySet.getValue();
			}
		}
		
		System.out.println(result);*/
		
		String[] stringArray = {null};		// You have to define variable this way while dealing with lambda
		Integer[] frequencyArray = {0};
		map.forEach((k, v) -> 
		{
			if(v > frequencyArray[0])
			{
				stringArray[0] = k;
				frequencyArray[0] = v;
			}
		});
		
		System.out.println(stringArray[0]);
	}
}