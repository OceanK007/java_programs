package com.ocean.programs.algorithm.collection;

import java.util.ArrayList;
import java.util.List;

/** Given a class that is a wrapper over a List of variable-length List objects, i.e. 
 * List<List<Integer>> implement a next method on the wrapper to iterate over its transpose.
 * Skip the cells where there is no data because that particular list has ended.
	E.g.
	[
	    [  1,  2,  3 ],
	    [  4,  5],
	    [  6,  7,  8,  9,  10,  11,  12 ],
	    [ 13, 14, 15, 16] 
	]
	The output should be
	1, 4, 6, 13, 2, 5, 7, 14, 3, 8, 15, 9, 16, 10, 11, 12
	
	Assume that the internal List has hasNext() and next() methods
	·  How do you optimize your algorithm?
	·  What checks are done again and again?
	·  How do you avoid those checks?
**/
public class CustomIterateListInsideList 
{
	public static void main(String[] args) 
	{
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);list1.add(2);list1.add(3);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(4);list2.add(5);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);list3.add(7);list3.add(8);list3.add(9);list3.add(10);list3.add(11);list3.add(12);
		
		List<Integer> list4 = new ArrayList<>();
		list4.add(13);list4.add(14);list4.add(15);list4.add(16);
		
		List<List<Integer>> fullList = new ArrayList<>();
		fullList.add(list1);
		fullList.add(list2);
		fullList.add(list3);
		fullList.add(list4);
		
		CustomList.setList(fullList);
		CustomList.iterate();
	}
}

class CustomList
{
	static List<List<Integer>> list = new ArrayList<>();
	static int maxIteration =0;
	static int iterationCount=0;
	
	public static List<List<Integer>> getList() 
	{
		return list;
	}
	public static void setList(List<List<Integer>> list) 
	{
		CustomList.list = list;
		for(List<Integer> l : list)
		{
			if(l.size() > maxIteration)
			{
				maxIteration = l.size();
			}
		}
	}
	public static int getMaxIteration() 
	{
		return maxIteration;
	}
	public static void setMaxIteration(int maxIteration) 
	{
		CustomList.maxIteration = maxIteration;
	}
	
	public static void iterate()
	{
		iterationCount += 1;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<maxIteration;i++)
		{
			for(List<Integer> l : list)
			{
				if(i < l.size())
				{
					sb.append(l.get(i)).append(",");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}

