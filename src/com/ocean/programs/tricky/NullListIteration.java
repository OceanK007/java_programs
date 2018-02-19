package com.ocean.programs.tricky;

import java.util.List;

public class NullListIteration 
{
	public static void main(String[] args) 
	{
		List<String> list = null;
		for(String s : list)	// Runtime exception: java.lang.NullPointerException
		{
			System.out.println(s);		
		}
	}
}
