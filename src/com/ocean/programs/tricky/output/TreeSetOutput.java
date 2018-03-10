package com.ocean.programs.tricky.output;

import java.util.TreeSet;

public class TreeSetOutput 
{
	public static void main(String[] args) 
	{
		TreeSet<String> set = new TreeSet<>();
		set.add(null);		// java.lang.NullPointerException since can't have null value
		
		System.out.println(set.size());
	}
}
