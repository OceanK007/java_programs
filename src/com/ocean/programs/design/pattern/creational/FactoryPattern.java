package com.ocean.programs.design.pattern.creational;

/**
•	What is factory?
	o	A component responsible solely  for the wholesale (not piecwise) creation of objects.
	o	A factory method is a static method that creates objects.
	o	A factory can be external or reside inside the object as an inner class.
	o	Hierarchies of factories can be used to create related objects.
•	Why is it required?
	o	Wholesale object creation (non-piecewise, unlike Builder) can be outsourced to:
		1.	A separate function (Factory method).
		2.	That may exist in a separate class (Factory).
		3.	Can create hierarchy of factories with Abstract Factory.
 */

class MySQL
{
	private MySQL() {} // TO make sure, we can't create objects of it directly.
	
	public static MySQL getConnection()
	{
		return new MySQL();
	}
}

class MongoDB
{
	private MongoDB() {} // TO make sure, we can't create objects of it directly.
	
	public static MongoDB getConnection()
	{
		return new MongoDB();
	}
}

class DatabaseFactory
{
	public static MySQL getMySQLConnection()
	{
		return MySQL.getConnection();
	}
	
	public static MongoDB getMongoDBConnection()
	{
		return MongoDB.getConnection();
	}
}

public class FactoryPattern 
{
	public static void main(String[] args) 
	{
		DatabaseFactory dbf = new DatabaseFactory();
		MySQL ms = dbf.getMySQLConnection();
		MongoDB mdb = dbf.getMongoDBConnection();
	}
}