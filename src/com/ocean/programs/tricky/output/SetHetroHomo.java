package com.ocean.programs.tricky.output;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetHetroHomo 
{
	public static void main(String[] args) 
	{
		// TreeSet is homogeneous
		// LinkedHashSet and HashSet are Homogeneous
		
		//Set set = new TreeSet();	// Runtime exception: java.lang.String cannot be cast to java.lang.Integer
		//Set set = new HashSet();	// [Hi, 5]
		Set set = new LinkedHashSet();	// [Hi, 5]
		set.add("Hi");
		set.add(5);
		
		System.out.println(set);
	}
}
