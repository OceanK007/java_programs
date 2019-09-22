package com.ocean.programs.design.pattern.creational;

/** 
 * Using inner class to instantiate object.
 * This is used to avoid the problem of synchronization, when you initialize an instance, you will only get only one instance, no matter what. So there is not need of thread safety for this.
**/

class InnerStaticClassSingleton
{
	private InnerStaticClassSingleton() {}
	
	private static class InnerClass
	{
		// Inner class can access private constructors of outer class
		private static final InnerStaticClassSingleton INSTANCE = new InnerStaticClassSingleton();
	}
	
	public static InnerStaticClassSingleton getInstance()
	{
		return InnerClass.INSTANCE;
	}
}

public class SingletonPatternInnerStaticClass
{
	public static void main(String[] args) 
	{
		InnerStaticClassSingleton es = InnerStaticClassSingleton.getInstance();
	}
}