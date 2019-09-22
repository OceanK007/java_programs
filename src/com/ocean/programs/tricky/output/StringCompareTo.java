package com.ocean.programs.tricky.output;

public class StringCompareTo 
{
	public static void main(String[] args) 
	{
		System.out.println("a".compareTo("d"));	// -3
		System.out.println("d".compareTo("a"));	// 3
		System.out.println("a".compareTo("a"));	// 0
		System.out.println("0".compareTo("3"));	// -3
		System.out.println("3".compareTo("0"));	// 3
		System.out.println("0".compareTo("0"));	// 0
		System.out.println("1".compareTo("4"));	// -3
		System.out.println("4".compareTo("1"));	// 3
		System.out.println("1".compareTo("1"));	// 0
	}
}
