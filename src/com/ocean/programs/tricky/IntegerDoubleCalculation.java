package com.ocean.programs.tricky;

public class IntegerDoubleCalculation 
{
	public static void main(String[] args) 
	{
		Integer i = 10;
		Integer j = 3;
		
		Double d = null;
		
		//d = i/j;	// Compile time exception: Add cast to double	
		d = (double) (i/j);	// 3.0
		d = (double) i/j;	// 3.3333333333333335
		
		System.out.println(d);
	}
}
