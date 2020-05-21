package com.ocean.programs.datastructure.queue;

class QueueArray
{
	int MAX = 5;
	int queue[] = new int[MAX];
	int size;
	int head = -1;
	int tail = -1;
	
	// Initially the head and tail both will be at same location i.e. index 0
	public void enqueue(int data)
	{
		if(!isFull())
		{
			// To avoid ArrayIndexOutOfBound exception once array is full
			tail = (tail+1) % MAX;	// It will become circular now 0%5=0, 1%5=1, 2%5=2, 3%5=3, 4%5=4, 5%5=0, 6%5=1
			queue[tail] = data;
			size++;
		} 
		else
			System.out.println("Queue is full");
	}
	
	public int dequeue()
	{
		if(!isEmpty())
		{
			head = (head+1) % MAX;	// It will become circular now 0%5=0, 1%5=1, 2%5=2, 3%5=3, 4%5=4, 5%5=0, 6%5=1
			int data = queue[head];
			size--;	// Size of queue will be reduced as well 
			return data;
		}
		else
		{
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	// Complexity: O(1)
	public int getFront()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty. Nothing at front");
			return Integer.MIN_VALUE;
		}
		return queue[head+1];
	}
	
	// Complexity: O(1)
	public int getRear()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty. Nothing at rear");
			return Integer.MIN_VALUE;
		}
		return queue[tail];
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public boolean isFull()
	{
		return size==MAX;
	}
	
	public void show()
	{
		System.out.print("Queue: ");
		for(int i=0;i<size;i++)
		{
			// head needs to be added with i
			System.out.print(queue[(head+1+i)%MAX]+" ");
		}
		
		System.out.println();
		System.out.print("Real array: ");
		
		for(int n : queue)
		{
			System.out.print(n+" ");
		}
	}
}

public class Custom_QueueUsingArray
{
	public static void main(String[] args)
	{
		QueueArray q = new QueueArray();
		q.enqueue(5);
		q.enqueue(2);
		q.enqueue(7);
		q.enqueue(3);
		
		System.out.println("Size: "+q.getSize());
		System.out.println("Front: "+q.getFront());
		System.out.println("Rear: "+q.getRear());
		q.show();
		System.out.println();
		System.out.println();
		
		q.dequeue();
		q.dequeue();
		
		System.out.println("Size: "+q.getSize());
		System.out.println("Front: "+q.getFront());
		System.out.println("Rear: "+q.getRear());
		q.show();
		System.out.println();
		System.out.println();
		
		q.enqueue(9);
		q.enqueue(1);
		q.enqueue(19);
		q.enqueue(15);
		
		System.out.println("Size: "+q.getSize());
		System.out.println("Front: "+q.getFront());
		System.out.println("Rear: "+q.getRear());
		q.show();
	}
}
