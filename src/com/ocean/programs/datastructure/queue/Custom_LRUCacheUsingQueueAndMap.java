package com.ocean.programs.datastructure.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Custom_LRUCacheUsingQueueAndMap
{
	Deque<Integer> deque = new LinkedList<Integer>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int CACHE_SIZE = 3;
	
	public Integer getElement(int value)
	{
		if(map.containsKey(value))
		{
			// Removing value and adding it to the front of queue
			deque.remove(value);
			deque.addFirst(value);
			
			return value;
		}
		
		return null;
	}
	
	public void addElement(int value)
	{
		// If map contains key, remove it from queue and add it to front of queue
		if(map.containsKey(value))
		{
			deque.remove(value);
			deque.addFirst(value);
		}
		else
		{
			// If map doesn't contain key and queue size if full, 
			// remove last entry from queue and remove that last element from map as well
			// Add element to queue and put element in map as well
			if(deque.size() == CACHE_SIZE)
			{
				Integer i = deque.removeLast();
				map.remove(i);
				
				deque.addFirst(value);
				map.put(value, value);
			}
			// If map doesn't contain key and queue size is not full
			// Add element to queue and put element in map as well
			else
			{
				deque.addFirst(value);
				map.put(value, value);
			}
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
		Custom_LRUCacheUsingQueueAndMap lru = new Custom_LRUCacheUsingQueueAndMap();
		lru.addElement(1);
		System.out.println();
		lru.display();
		lru.addElement(2);
		System.out.println();
		lru.display();
		lru.addElement(3);
		System.out.println();
		lru.display();
		lru.addElement(4);
		System.out.println();
		lru.display();
		
		System.out.println();
		System.out.println(lru.getElement(2));
		lru.display();
		System.out.println();
		System.out.println(lru.getElement(6));
		lru.display();
	}
}
