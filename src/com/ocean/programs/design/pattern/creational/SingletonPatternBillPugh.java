package com.ocean.programs.design.pattern.creational;

/** Prior to Java 5, java memory model had a lot of issues and above approaches used to fail 
 * in certain scenarios where too many threads try to get the instance of the Singleton class simultaneously. 
 * So Bill Pugh came up with a different approach to create the Singleton class using a inner static helper class. 
 * 
 * Notice the private inner static class that contains the instance of the singleton class. 
 * When the singleton class is loaded, SingletonHelper class is not loaded into memory and only 
 * when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 * 
 * This is the most widely used approach for Singleton class as it doesn’t require synchronization.**/
final public class SingletonPatternBillPugh
{
	private SingletonPatternBillPugh() {} // Made private, so can't create instance of this class

	// Inner static class
	private static class SingletonHelperClass
	{
        private static final SingletonPatternBillPugh instance = new SingletonPatternBillPugh();
    }
	
	public static SingletonPatternBillPugh getInstance() 
	{
		return SingletonHelperClass.instance;
	}
}