package com.ocean.programs.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedList
{
	public static void main(String[] args)
	{
		List<String> list = Collections.synchronizedList(new ArrayList<String>()); 
		  
		Thread addElement = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				// Only one thread can add element at a time
				// So sometimes no element is added!!! why?
				list.add("1");	
				list.add("2");
				list.add("3");
				list.add("4");
				list.add("5");
			}
		});
		
		Thread iterateElement = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				// To avoid ConcurrentModificationException we need to put it inside synchronized block
				synchronized(list) 
		        { 
					Iterator<String> it = list.iterator(); 
					  
		            while (it.hasNext()) 
		                System.out.println(it.next());	
		        }
			}
		});
		
		addElement.start();
		iterateElement.start();
	}
}
