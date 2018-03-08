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
	}
}