package com.ocean.programs.collection;

import java.util.Arrays;

public class SAP_CustomQueueUsingArray 
{
	public static void main(String[] args) 
	{
		Queue queue = new Queue(10);
		queue.insert(31);
		queue.insert(49);
		
		System.out.println(queue);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue);
		
		queue.insert(50);
		queue.insert(65);
		queue.insert(497);
		queue.insert(4);
		System.out.println(queue);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue);
	}
	
	static class Queue
	{
		private int[] queue;
		private int size;
		private int front;
		private int rear;
		private int noOfElements;
		
		public Queue(int size)
		{
			this.size = size;
			queue = new int[this.size];
		}
		
		public void insert(int value)
		{
			if(size == noOfElements)
			{
				throw new RuntimeException("Queue is full");
			}
			
			if(rear != size)
			{
				queue[rear] = value;
				rear++;
				noOfElements++;
			}
			else // Dealing with wrapAround
			{
				rear = 0;
				queue[rear] = value;
				rear++;
				noOfElements++;
			}
		}

		public int remove()
		{
			if(noOfElements == 0)
			{
				throw new RuntimeException("Queue is empty");
			}
			
			if(front == size) // Dealing with wrapAround
			{
				front = 0;
			}
			int removedElement = queue[front];
			front++;
			noOfElements--;
			
			return removedElement;
		}
		
		@Override
		public String toString() 
		{
			return Arrays.toString(queue);
		}	
	}
}
