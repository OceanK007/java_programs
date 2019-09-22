package com.ocean.programs.design.pattern.creational;

/**
•	What is builder pattern?
	o	A builder is a separate component for building an object.
•	Why is it required?
	o	Building an object with 10 constructor arguments is not productive and it increases the chance of wrong input.
	o	So we need to go for piecewise construction. 
	o	It provides an API for construction an object step-by-step.
	o	When piecewise object construction is complicated, provide an API for doing it succinctly.
•	How to create?
	o	Can either give builder a constructor or return it via a static function.
	o	To make builder fluent, return this.
	o	Different facets of an object can be built with different builders working in tandem via a base class. (Faceted builder  s– combination of facade and builder patterns)

•	Example:
	o	StringBuilder (non-fluent builder since we need to call .append() by using StringBuilder object references)
 */
/** This is an example of fluent builder since we can directly call methods after calling another method. **/
public class BuilderPattern 
{
	public static void main(String[] args) 
	{
		Person p = new PersonBuilder()
					.name("Ocean")
					.age(18)
					.address("100A")
					.build();
		
		System.out.println(p);
	}
}

class Person
{
    public String name;
    public int age;
    public String address;

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}

class PersonBuilder
{
	protected Person person = new Person();
	
	public PersonBuilder name(String name)
	{
		person.name = name;
		return this;
	}
	
	public PersonBuilder age(int age)
	{
		person.age = age;
		return this;
	}
	
	public PersonBuilder address(String address)
	{
		person.address = address;
		return this;
	}
	
	public Person build()
	{
		return person;
	}
}
