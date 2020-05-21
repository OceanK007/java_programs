package com.ocean.programs.datastructure.queue;

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

class QueueLinked
{
	Node head;
	Node tail;
	int size;
	
	// Complexity: O(1)
	public void enqueue(int val)
	{
		Node node = new Node(val);

		if (this.head == null)
		{
			this.head = node;
			this.tail = node;
		}
		else
		{
			this.tail.next = node;	// Any update in this.tail.next will update in this.head as well
			this.tail = node;
		}
		
		size++;
	}
	
	// Complexity: O(1)
	public int getSize()
	{
		return size;
	}
	
	// Complexity: O(1)
	public int getFront()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty. Nothing at front");
			return Integer.MIN_VALUE;
		}
		return head.data;
	}
	
	// Complexity: O(1)
	public int getRear()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty. Nothing at rear");
			return Integer.MIN_VALUE;
		}
		return tail.data;
	}
	
	// Complexity: O(1)
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty. Nothing to remove");
			return Integer.MIN_VALUE;
		}
		
		int value = head.data;
		head = head.next;
		if(head == null) tail = null;
		
		size--;
		return value;
	}
	
	public boolean isEmpty()
	{
		if(tail == null) return true;
		else return false;
	}
}

public class Custom_QueueUsingLinkedList
{
	public static void main(String[] args)
	{
		QueueLinked ql = new QueueLinked();
		ql.enqueue(12);
		ql.enqueue(2);
		ql.enqueue(7);
		ql.enqueue(27);
		ql.enqueue(18);
		ql.enqueue(80);
		
		System.out.println("Size: "+ql.getSize());
		System.out.println("Front: "+ql.getFront());
		System.out.println("Rear: "+ql.getRear());
		
		System.out.println("Removed Element: "+ql.dequeue());
		
		System.out.println("Size: "+ql.getSize());
		System.out.println("Front: "+ql.getFront());
		System.out.println("Rear: "+ql.getRear());
		ql.enqueue(81);
		
		System.out.println("Size: "+ql.getSize());
		System.out.println("Front: "+ql.getFront());
		System.out.println("Rear: "+ql.getRear());
		
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
		System.out.println("Removed Element: "+ql.dequeue());
	}
}
