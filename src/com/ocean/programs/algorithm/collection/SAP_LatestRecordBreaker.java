package com.ocean.programs.algorithm.collection;

import java.util.*;

/**
Given a dataset as follows(In a particular year, for a particular sport, the corresponding sports person broke the record. e.g. In the year 1990, in Cricket ABC broke a record and so on.): 
	Year         Sports 		SportsPerson 
	----------------------------------------- 
	1990 		Cricket 			ABC 
	1990 		Tennis 				XYZ 
	1995 		Cricket 			ABC2 
	1996 		Tennis 				XYZ2 
	Write a data structure to store these data, so that if a year and sport is given in the argument, it should return the name of the sports person who broke a record in that particular sport in the year latest to the given year. 
	e.g. for year 1992 and sport Cricket it should return the latest record breaker i.e. ABC. 
**/
public class SAP_LatestRecordBreaker 
{
	public static void main(String[] args) 
	{
		Map<String, Map<Integer, String>> map = new HashMap<>();
		Map<Integer, String> innerMap = null;
		{
			innerMap = new TreeMap<>();
			innerMap.put(1990, "ABC");
			innerMap.put(1995, "ABC2");
			map.put("Cricket", innerMap);
		}
		{
			innerMap = new TreeMap<>();
			innerMap.put(1990, "ABC");
			innerMap.put(1996, "XYZ2");
			map.put("Tennis", innerMap);
		}
		
		boolean result = true;
		result = result & latestBreakRecorder(map, 1992, "Cricket").equals("ABC");
		result = result & latestBreakRecorder(map, 1998, "Tennis").equals("XYZ2");
		
		if(result)
		{
			System.out.println("Tests Passed");
		}
		else
		{
			System.out.println("Tests Failed");
		}
	}
	
	public static String latestBreakRecorder(Map<String, Map<Integer, String>> map, int year, String sport)
	{
		String name = null;
		
		Map<Integer, String> innerMap = map.get(sport);
		if(innerMap != null && innerMap.size() != 0)
		{
			for(Map.Entry<Integer, String> entry: innerMap.entrySet())
			{
				if(entry.getKey() < year)
				{
					name = entry.getValue();
				}
				else
				{
					break;
				}
			}
		}
		
		return name;
	}
}
