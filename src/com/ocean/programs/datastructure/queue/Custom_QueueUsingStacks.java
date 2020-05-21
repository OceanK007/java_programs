package com.ocean.programs.datastructure.queue;

import java.util.Stack;

class QueueStacks
{
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public void enqueue(int val)
	{
		s1.push(val);
	}
	
	public int dequeue()
	{
		if(!s2.empty()) return s2.pop();
		
		if(s1.empty()) return -1;
		
		while(!s1.empty())
		{
			s2.push(s1.pop());
		}
		
		return s2.pop();
	}
}

public class Custom_QueueUsingStacks
{
	public static void main(String[] args)
	{
		QueueStacks qs = new QueueStacks();
		qs.enqueue(7);
		qs.enqueue(3);
		qs.enqueue(4);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		
		qs.enqueue(5);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
	}
}
