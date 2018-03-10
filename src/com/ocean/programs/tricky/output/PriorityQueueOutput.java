package com.ocean.programs.tricky.output;

import java.util.PriorityQueue;

public class PriorityQueueOutput 
{
	public static void main(String[] args) 
	{
		PriorityQueue<String> queue = new PriorityQueue<>();
		//queue.add(null);		// java.lang.NullPointerException, since can't have null value
		//System.out.println(queue.size());
		
		PriorityQueue<String> queue2 = new PriorityQueue<>();
		queue2.add("One");
		queue2.add("One");
		System.out.println(queue2.size());
	}
}
