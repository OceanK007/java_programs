package com.ocean.programs.datastructure.stacks;

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

class StackLinked
{
	Node head;
	
	public void push(int val)
	{
		Node node = new Node(val);

		if (this.head == null)
		{
			this.head = node;
		}
		else
		{	
			// Generally in linkedlist, head is always same and we add new elements to "next" attribute. Refer HR_Custom_SinglyLinkedList.java
			// But here we are trying to use make the newly inserted node as head always
			node.next = head;
			head = node;
		}
	}
	
	public int pop()
	{
		if(head == null)
		{
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		// Since linkedlist head property is the last inserted value i.e. top of stack
		int value = head.data;
		head = head.next;
		return value;
	}
	
	public int top()
	{
		if(head == null)
		{
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		return head.data;
	}
}

public class Custom_StackUsingLinkedList
{
	public static void main(String[] args)
	{
		StackLinked sl = new StackLinked();
		sl.push(12);
		sl.push(5);
		sl.push(34);
		sl.push(42);
		sl.push(91);
		sl.push(9);
		System.out.println(sl.pop());

		sl.push(39);
		
		System.out.println("Top: "+sl.top());
		
		System.out.println(sl.pop());
		System.out.println(sl.pop());
		System.out.println(sl.pop());
		System.out.println(sl.pop());
		System.out.println(sl.pop());
		System.out.println(sl.pop());
	}
}
