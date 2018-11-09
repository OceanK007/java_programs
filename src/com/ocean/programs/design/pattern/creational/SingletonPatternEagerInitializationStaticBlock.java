package com.ocean.programs.design.pattern.creational;

/** Static block initialization implementation is similar to eager initialization, 
except that instance of class is created in the static block that provides option for exception handling. 

Both eager initialization and static block initialization creates the instance even before it’s being 
used and that is not the best practice to use. **/
final public class SingletonPatternEagerInitializationStaticBlock 	// Made final so can't be extended, so no inheritance
{
	static private SingletonPatternEagerInitializationStaticBlock instance;
	
	static
	{
		try
		{
			instance = new SingletonPatternEagerInitializationStaticBlock();
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	private SingletonPatternEagerInitializationStaticBlock() {} // Made private, so can't create instance of this class
	
	public static SingletonPatternEagerInitializationStaticBlock getInstance() 
	{
		return instance;
	}
}