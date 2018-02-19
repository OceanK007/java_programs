package com.ocean.programs.tricky;

public class NameConflictionWithoutThisKeyword 
{
	public static void main(String[] args)
	{
		NameConflicton nc = new NameConflicton("Ocean");
	}
}

class NameConflicton
{
	String name;
	
	public NameConflicton(String name)
	{
		name = name;		// use this.name = name;
		
		System.out.println("Name: "+name);		// Ocean
		System.out.println("Name: "+this.name);	// null
	}
}
