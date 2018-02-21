package com.ocean.programs.tricky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAndLinkedList 
{
	public static void main(String[] args) 
	{
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.removeFirst();
		
		List<String> list = new LinkedList<String>();
		//list.removeFirst();	// removeFirst() doesn't exist	// why?
		// Why are we unable to call subclass's method here?
	}
}
