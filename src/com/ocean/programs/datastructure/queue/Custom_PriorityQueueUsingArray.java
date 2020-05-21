package com.ocean.programs.datastructure.queue;

class PriorityQueueArray
{
	private int MAX;	// Initial size of array
	private int[] arr;
	private int size;
	
	public PriorityQueueArray()
	{
		MAX = 10;
		arr = new int[MAX];
		size = 0;
	}
	
	public void insert(int val)
	{
		int i;
		
		if(size == 0)
		{
			arr[0] = val;
			size++;
			return;
		}
		
		for(i=size-1;i>=0;i--)
		{
			if(val > arr[i])
			{
				arr[i+1] = arr[i];
			}
			else
				break;
		}
		
		arr[i+1] = val;
		size++;
	}
	
	public void print()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public int remove()
	{
		return arr[--size];	// Reducing size as well
	}
	
	public boolean isFull()
	{
		return size == MAX;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int peek()	// Peek just returns element, but doesn't remove
	{
		return arr[size-1];
	}
}

public class Custom_PriorityQueueUsingArray
{
	public static void main(String[] args)
	{
		PriorityQueueArray pqa = new PriorityQueueArray();
		pqa.insert(12);
		pqa.insert(7);
		pqa.insert(10);
		pqa.insert(1);
		pqa.insert(8);
		
		pqa.print();
		
		System.out.println();
		System.out.println(pqa.remove());
		pqa.print();
		
		System.out.println();
		System.out.println(pqa.remove());
		pqa.print();
	}
}
