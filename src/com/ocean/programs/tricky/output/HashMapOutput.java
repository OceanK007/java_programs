package com.ocean.programs.tricky.output;

import java.util.HashMap;

public class HashMapOutput 
{
	public static void main(String[] args) 
	{
		HashMap<String, String> map = new HashMap<>();
		// Only one null key possible in HashMap, but can have multiple null values
		map.put(null, "Hi");
		map.put(null, "hello");
		
		System.out.println(map.get(null));	// hello
		System.out.println(map.size());		// 1

		///////////////////////////////////////////////////////////////////////
		
		HashMap<String, String> map2 = new HashMap<>();
		System.out.println(map2.put("One", "Value1"));	// null
		System.out.println(map2.put("Two", "Value2"));	// null
		System.out.println(map2.put("One", "Value3"));	// Value1 (It returns previous value of key if key already exists)
	}
}