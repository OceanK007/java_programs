package com.ocean.programs.tricky;

public class IntegerDoubleCalculation 
{
	public static void main(String[] args) 
	{
		/** Widening not available for wrapper classes **/
		Integer i = 10;
		Integer j = 3;
		Double d = null;
		
		//d = i/j;	// Compile time exception: Add cast to double	
		d = (double) (i/j);	// 3.0
		d = (double) i/j;	// 3.3333333333333335
		System.out.println(d);
		
		
		/** Widening available for primitive data types **/
		int x = 10;
		int y = 3;
		double z = 0;
		
		z = x/y;
		System.out.println(z); 	// 3.0

		
		/** Note1 **/
		long p = 5L;
		long q = 4L;
		
		//int r = p*q;	// Compile time exception: Type mismatch: cannot convert from long to int
		int r = (int) (p*q);
		System.out.println(r); 	// 20
		
		/** Note2 **/
		int s = 2;
		int t = 4;
		
		int u = s * t;
		System.out.println(u);  // 8
		
		/** Note3 **/
		int e = 2;
		long f = 4L;
		
		//int g = e * f;	// Compile time exception: Type mismatch: cannot convert from long to int
		int g = (int) (e * f);	
		System.out.println(g);	// 20
		
		/** Note4 **/
		int k = 5*4;
		System.out.println(k);	// 20
	}
}
