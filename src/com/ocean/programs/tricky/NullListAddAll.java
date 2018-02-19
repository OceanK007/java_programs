package com.ocean.programs.tricky;

import java.util.ArrayList;
import java.util.List;

public class NullListAddAll 
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<>();
		List<String> list2 = null;
		list.addAll(list2);		// Runtime exception: java.lang.NullPointerException
	}
}
