package com.ocean.programs.design.pattern.creational;

/** Using reflection, we can break singleton pattern. 
 * 
 * Enum to implement Singleton design pattern as Java ensures that any enum value is instantiated 
 * only once in a Java program. Since Java Enum values are globally accessible, so is the singleton. 
 * The drawback is that the enum type is somewhat inflexible; for example, it does not allow lazy initialization.
 * 
 * Since enums are inherently serializable, we don't need to implement it with a serializable interface. 
 * The reflection problem is also not there. Therefore, it is 100% guaranteed that only one instance of the 
 * singleton is present within a JVM. Thus, this method is recommended as the best method of making singletons in Java.**/
enum EnumSingleton
{
	INSTANCE;
	
	int rollNo;
	String name;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class SingletonPatternEnum
{
	public static void main(String[] args) 
	{
		EnumSingleton es = EnumSingleton.INSTANCE;
		
		System.out.println(es.getRollNo());
		System.out.println(es.getName());
		es.setRollNo(5);
		es.setName("Ocean");
		System.out.println(es.getRollNo());
		System.out.println(es.getName());
	}
}