package com.ocean.programs.collection;

/**Find the minimum number from an unsorted stack. Write code to pop in, pop out numbers from stack.
Stack – {99, 34, 1, 5, 0, 2}
Output – 0
 
Class stack 
{
    data;
 
    public void push(int i) {}
 
    public int pop() {}
         
    public int min() {}
}**/

import java.util.LinkedList;
import java.util.List;

public class CustomStackUsingList 
{
	public static void main(String[] args) 
	{
		CustomStackList cs = new CustomStackList();
		cs.push(99);
		cs.push(34);
		cs.push(1);
		cs.push(5);
		cs.push(0);
		cs.push(2);
		
		System.out.println(cs.min());
	}
}

class CustomStackList
{
	private List<Integer> list = new LinkedList<>();
	
	public void push(int i) 
	{ 
		 list.add(i);
	}
	  
	public int pop() 
	{ 
		 return list.get(list.size()-1);
	}
	          
    public int min() 
    {
	   	 int min = Integer.MAX_VALUE;
	   	 
	   	 for(Integer i : list)
	   	 {
	   		 if(i < min)
	   		 {
	   			 min = i;
	   		 }
	   	 }
	   	 return min;
    }
}
