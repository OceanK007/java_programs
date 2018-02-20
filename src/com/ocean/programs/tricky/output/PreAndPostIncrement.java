package com.ocean.programs.tricky.output;

public class PreAndPostIncrement 
{
	public static void main(String[] args) 
	{ 
		int a=5, i=0;
		
		// i = 6 + 7 + 7
		i = ++a + ++a + a++;
		System.out.println("a = "+a);	// 8
		System.out.println("i = "+i);	// 20
		
		a=5; i=0;
		// i = 5 + 7 + 8
		i=a++ + ++a + ++a;
		System.out.println("a = "+a);	// 8
		System.out.println("i = "+i);	// 20
		
		a=5;
		// a = 6 + 7 + 7  
		a=++a + ++a + a++;
		System.out.println("a=++a + ++a + a++ : "+a);	// 20
		
		a=5;
		int b=5;
		System.out.println("a = "+ ++a);	// 6
		System.out.println("b = "+ b++);	// 5
	}

}
