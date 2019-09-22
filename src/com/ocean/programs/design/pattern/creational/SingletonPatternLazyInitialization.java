package com.ocean.programs.design.pattern.creational;

/** Lazy initialization works fine incase of single threaded environment but when it comes to multithreaded systems, 
 * it can cause issues if multiple threads are inside the if loop at the same time. 
 * It will destroy the singleton pattern and both threads will get the different instances of singleton class. **/
final public class SingletonPatternLazyInitialization // Made final so can't be extended, so no inheritance
{
	static private SingletonPatternLazyInitialization instance = null;		

	private SingletonPatternLazyInitialization() {} // Made private, so can't create instance of this class

	public static SingletonPatternLazyInitialization getInstance() 
	{
		if (instance == null)       
			instance = new SingletonPatternLazyInitialization();  
			
		return instance;
	}
}