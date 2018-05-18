package com.ocean.programs.design.pattern.creational;

import java.io.Serializable;

final public class SingletonPatternLazyInitializationThreadSafe implements Serializable, Cloneable	// Made final so can't be extended, so no inheritance
{
	private static final long serialVersionUID = 6016675667246341117L;
	
	// Made volatile so variable will be stored in main memory not in cpu memory.
	// Without volatile modifier it's possible for another thread in Java to see half initialized state of _instance variable
	// all the write will happen on volatile _instance before any read of _instance variable
	static private volatile SingletonPatternLazyInitializationThreadSafe instance;		

	private SingletonPatternLazyInitializationThreadSafe() // Made private, so can't create instance of this class
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
	
	// Making whole method synchronized
	/** This implementation works fine and provides thread-safety but it reduces the performance 
	 * because of cost associated with the synchronized method, although we need it only for the 
	 * first few threads who might create the separate instances. 
	 * 
	 * To avoid this extra overhead every time, double checked locking principle is used. 
	 * In this approach, the synchronized block is used inside the if condition with an additional 
	 * check to ensure that only one instance of singleton class is created. **/
	/*public static synchronized SingletonPatternLazyInitializationThreadSafe getInstance() 
	{
		if (instance == null)	
		{
			instance = new SingletonPatternLazyInitializationThreadSafe(); 
		}
		
		return instance;
	}*/

	public static SingletonPatternLazyInitializationThreadSafe getInstance() 
	{
		// If you don't want to bear cost of synchronization all the time you call this method, while synchronization is only needed on first class, when Singleton instance is created, use double locking
		if (instance == null)	// 1: Without lock (not in synchronized block)
		{
			synchronized(SingletonPatternLazyInitializationThreadSafe.class) 
			{  
				//double checked locking - because second check of Singleton instance with lock
				if (instance == null)          // 2: With lock (in synchronized block)
					instance = new SingletonPatternLazyInitializationThreadSafe();  
			}
		}
		return instance;
	}
}