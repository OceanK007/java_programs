package com.ocean.programs.collection;

import java.util.*;

/**
We are given total possible page numbers that can be referred. We are also given cache (or memory) 
size (Number of page frames that cache can hold at a time). 
The LRU caching scheme is to remove the least recently used frame when the cache is full 
and a new page is referenced which is not there in cache. 

https://www.geeksforgeeks.org/lru-cache-implementation/
**/

public class LRUCache 
{
	static Deque<Integer> deque;
	static HashSet<Integer> set;
	static int cacheSize;
	
	public LRUCache(int size) 
	{
		deque = new LinkedList<>();
		set = new HashSet<>();
		cacheSize = size;
	}
	
	public void insert(int element)
	{
		if(!set.contains(element))
		{
			if(deque.size() == cacheSize)
			{
				int i = deque.removeLast(); // Will remove and return element
				set.remove(i);
			}
			
			deque.push(element);
			set.add(element);
		}
		else
		{
			if(deque.size() == cacheSize)
			{
				deque.remove(element);
				set.remove(element);
			}
			deque.push(element);
			set.add(element);
		}
	}
	
	public void display()
	{
		for(Integer i : deque)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) 
	{
		LRUCache cache = new LRUCache(4);
		cache.insert(1);
		cache.insert(2);
		cache.insert(3);
		cache.insert(1);
		cache.insert(4);
		cache.insert(5);
		
		cache.display();
	}
}
