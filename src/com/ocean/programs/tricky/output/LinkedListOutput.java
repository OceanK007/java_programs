package com.ocean.programs.tricky.output;

import java.util.LinkedList;

public class LinkedListOutput 
{
	public static void main(String[] args) 
	{
		LinkedList<String> list = new LinkedList<>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		
		list.remove(1);
		
		System.out.println(list.get(0));	// One
		System.out.println(list.get(1));	// Three
		System.out.println(list.get(2)); 	// java.lang.IndexOutOfBoundsException
	}
}
