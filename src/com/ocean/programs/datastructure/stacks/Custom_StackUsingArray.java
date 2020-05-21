package com.ocean.programs.datastructure.stacks;

class StackArray
{
	int top = 0;
	int size = 5;	// Size of stack
	int[] arr = new int[size];
	
	private boolean isFull()
	{
		if(top == size)return true;
		else return false;
	}
	
	private boolean isEmpty()
	{
		if(top == 0) return true;
		else return false;
	}
	
	public void insert(int val)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return;
		}
		
		arr[top++] = val;
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		return arr[--top];
	}
	
	public int top()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		return arr[top-1];
	}
}

public class Custom_StackUsingArray
{
	public static void main(String[] args)
	{
		StackArray sa = new StackArray();
		sa.insert(12);
		sa.insert(5);
		sa.insert(34);
		sa.insert(42);
		sa.insert(91);
		sa.insert(9);
		
		System.out.println(sa.remove());
		sa.insert(9);
		
		System.out.println("Top: "+sa.top());
		
		System.out.println(sa.remove());
		System.out.println(sa.remove());
		System.out.println(sa.remove());
		System.out.println(sa.remove());
		System.out.println(sa.remove());
		System.out.println(sa.remove());
	}
}
