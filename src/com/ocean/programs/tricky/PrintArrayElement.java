package com.ocean.programs.tricky;

import java.util.Arrays;

public class PrintArrayElement 
{
	public static void main(String[] args) 
	{
		String[] str = {"1", "2"};
		System.out.println(str); 		// [Ljava.lang.String;@15db9742
		System.out.println(Arrays.toString(str));	// [1, 2]
		//System.out.println(Arrays.deepToString(2d-array));
	}
}
