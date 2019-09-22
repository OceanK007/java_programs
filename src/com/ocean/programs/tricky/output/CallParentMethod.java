package com.ocean.programs.tricky.output;

public class CallParentMethod 
{
	public static void main(String[] args) 
	{
		A a = new B();
		a.callMe();
	}
}

class A
{
	public void callMe()
	{
		System.out.println("A");
	}
}

class B extends A
{
	public void callMe()
	{
		super.callMe();
		System.out.println("B");
	}
}

// Output:
// A
// B