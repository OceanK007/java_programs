package com.ocean.programs.algorithm.collection;

import java.util.*;

public class SAP_CustomStackUsingTwoQueue 
{
	public static void main(String[] args) 
	{
		Stack s = new Stack();
		s.push(1);  
	    s.push(2);  
	    s.push(3);  
	  
	    System.out.println("current size: " + s.size());  
	    System.out.println(s.top());  
	    s.pop();  
	    System.out.println(s.top());  
	    s.pop();  
	    System.out.println(s.top());  
	  
	    System.out.println("current size: " + s.size()); 
	}
	
	static class Stack  
	{  
	    // Two inbuilt queues  
	    static Queue<Integer> q1 = new LinkedList<Integer>(); 
	    static Queue<Integer> q2 = new LinkedList<Integer>();  
	      
	    // To maintain current number of elements  
	    static int curr_size;  
	  
	    Stack()  
	    {  
	        curr_size = 0;  
	    }  
	  
	    static void push(int x)  
	    {  
	        curr_size++;  
	  
	        // Push x first in empty q2  
	        q2.add(x);  
	  
	        // Push all the remaining elements from q1 to q2.  
	        while (!q1.isEmpty())  
	        {  
	        	// peek: // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty
	        	// poll: // Retrieves and removes the head of this queue, or returns null if this queue is empty
	        	// remove: // Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
	        	q2.add(q1.poll());   
	        	
	            //q2.add(q1.peek());  
	            //q1.remove();  
	        }  
	  
	        System.out.println("Before swapping");
	        System.out.println("q1: "+q1);
	        System.out.println("q2: "+q2);
	        
	        // swap the names of two queues  
	        Queue<Integer> q = q1;  
	        q1 = q2;  
	        q2 = q;
	        
	        System.out.println("after swapping");
	        System.out.println("q1: "+q1);
	        System.out.println("q2: "+q2);
	    }  
	  
	    static void pop()
	    {  
	        // if no elements are there in q1  
	        if (q1.isEmpty())  
	            return ;  
	        q1.remove();  
	        curr_size--;  
	    }  
	    static int top()  
	    {  
	        if (q1.isEmpty())  
	            return -1;  
	        return q1.peek();  
	    }  
	  
	    static int size()  
	    {  
	        return curr_size;  
	    }  
	};  
}
