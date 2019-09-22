package com.ocean.programs.design.pattern.creational;

import java.util.HashMap;

/** 
* Here we can get instance of a particular object based on our requirement. 
* We will be using Enum and HashMap which holds the instances.
* We can achieve lazy loading using Multiton.
**/
enum Subsystem
{
	PRIMARY,
	SECONDARY,
	FALLBACK
}

class Printer
{
	// Making private to make sure, can't be instantiated
	private Printer() {	}
	
	private static HashMap<Subsystem, Printer> instances = new HashMap<Subsystem, Printer>();
	
	public static Printer get(Subsystem ss)
	{
		if(instances.containsKey(ss))
			return instances.get(ss);
		
		Printer p = new Printer();
		instances.put(ss, p);
		return p;
	}
}

public class SingletonPatternMultiton
{
	public static void main(String[] args) 
	{
		Printer main = Printer.get(Subsystem.PRIMARY);
		Printer seconday = Printer.get(Subsystem.SECONDARY);
		Printer fallback = Printer.get(Subsystem.FALLBACK);
	}
}