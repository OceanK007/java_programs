package com.ocean.programs.datastructure.stacks;

import java.util.LinkedList;
import java.util.Queue;

class StackQueues
{
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	public void push(int val)
	{
		q1.add(val);
	}
	
	public int pop()
	{
		if(q1.isEmpty()) return -1;
		
		// Adding all values of q1 to q2 except the last element
		while(q1.size() != 1)
		{
			q2.add(q1.poll());
		}
		
		// The last element of q1 will be the popped element
		int result = q1.poll();
		
		// Swapping the queues to make sure q1 always contain the elements to be popped
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return result;
	}
}

public class Custom_StackUsingQueues
{
	public static void main(String[] args)
	{
		StackQueues sq = new StackQueues();
		sq.push(7);
		sq.push(3);
		sq.push(4);
		
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		
		sq.push(5);
		
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
	}
}
