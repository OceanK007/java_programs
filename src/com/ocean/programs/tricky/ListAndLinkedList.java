package com.ocean.programs.tricky;

import java.util.LinkedList;
import java.util.List;

public class ListAndLinkedList 
{
	public static void main(String[] args) 
	{
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("Two");
		linkedList.addLast("Three");
		linkedList.addFirst("One");
		linkedList.addLast("Four");
		System.out.println(linkedList);
		linkedList.removeFirst();
		linkedList.removeLast();
		System.out.println(linkedList);
		
		// LinkedList extends deque, that's why removeFirst() is there 
		List<String> list = new LinkedList<String>();
		//list.removeFirst();	// removeFirst() doesn't exist	
		// Here list can access all methods of class List and all overridden methods of class List by LinkedList
		// But list can't access any additional method of LinkedList
	}
}
