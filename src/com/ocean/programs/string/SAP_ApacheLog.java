package com.ocean.programs.string;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given a log file, return IP address(es) which accesses the site most often.
 */
public class SAP_ApacheLog 
{
	public static void main(String[] args) 
	{
		String lines[] = new String[] 
		{
		        "10.0.0.1 - log entry 1 11",
		        "10.0.0.1 - log entry 2 213",
		        "10.0.0.2 - log entry 133132" 
		};
		
		String result = findTopIpaddress(lines);
		    
		if (result.equals("10.0.0.1")) 
		{
		      System.out.println("Test passed");
		      
		} 
		else 
		{
		      System.out.println("Test failed");
		      
		}  
	}
	
	public static String findTopIpaddress(String[] lines) 
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String str : lines)
		{
			String[] splitString = str.split(" ");
			String ip = splitString[0];
			if(map.containsKey(ip))
			{
				map.put(ip, map.get(ip)+1);
			}
			else
			{
				map.put(ip, 1);
			}
		}
		
		System.out.println(map);
		
		String ip = "";
		int count = 0;
		for(Map.Entry<String, Integer> entrySet : map.entrySet())
		{
			if(entrySet.getValue() > count)
			{
				count = entrySet.getValue();
				ip = entrySet.getKey();
			}
		}
		return ip;
	}
}
