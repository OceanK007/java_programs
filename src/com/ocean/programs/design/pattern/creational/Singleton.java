package com.ocean.programs.design.pattern.creational;

import java.io.Serializable;

final public class Singleton implements Serializable, Cloneable	// Made final so can't be extended, so no inheritance
{
	private static final long serialVersionUID = 6016675667246341117L;
	
	// Made volatile so variable will be stored in main memory not in cpu memory.
	// Without volatile modifier it's possible for another thread in Java to see half initialized state of _instance variable
	// all the write will happen on volatile _instance before any read of _instance variable
	static private volatile Singleton instance = null;		

	private Singleton() // Made private, so can't create instance of this class
	{
		if( instance != null ) 
		{
			// Throwing error so using reflection, you can't create new instance.
			throw new InstantiationError( "Creating of this object is not allowed." );
	    }
	}

	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		// Throwing error so you can't create new instance by cloning
		throw new CloneNotSupportedException();
	}

	protected Object readResolve() 
	{
		// Using readResolve() method so by serialization you can't create the new instance.
		return instance;
	}
	
	public static Singleton getInstance() 
	{
		if (instance == null)	// 1: Without lock (not in synchronized block)
		{
			synchronized(Singleton.class) 
			{  
				//double checked locking - because second check of Singleton instance with lock
				if (instance == null)          // 2: With lock (in synchronized block)
					instance = new Singleton();  
			}
		}
		return instance;
	}
}