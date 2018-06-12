package com.ocean.programs.design.pattern.creational;

//JAVA code to explain cloning issue with singleton
class SuperClass implements Cloneable
{
	int i = 10;
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}

//Singleton class
class SingletonClass2 extends SuperClass
{
	// public instance initialized when loading the class
	public static SingletonClass2 instance = new SingletonClass2();
	
	private SingletonClass2() 
	{
		// private constructor
	}
}

public class SingletonPatternBreakUsingCloning
{
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		 SingletonClass2 instance1 = SingletonClass2.instance;
		 SingletonClass2 instance2 = (SingletonClass2) instance1.clone();
		 System.out.println("instance1 hashCode: "+ instance1.hashCode());
		 System.out.println("instance2 hashCode: "+ instance2.hashCode()); 
	}
}
