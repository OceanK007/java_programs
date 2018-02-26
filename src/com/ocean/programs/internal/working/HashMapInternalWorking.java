package com.ocean.programs.internal.working;

import java.util.HashMap;

public class HashMapInternalWorking 
{
	public static void main(String[] args) 
	{
		HashMap<Integer, String> map = new HashMap<>();
		/** Not any element added yet:
		 * 
		 *  loadFactor = .75
		 *  Threshold = 0
		 *   
		 **/
		
		map.put(1, "one");
		
		System.out.println(map);
	}
}
