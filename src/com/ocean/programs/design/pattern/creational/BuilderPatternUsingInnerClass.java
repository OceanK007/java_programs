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
public class BuilderPatternUsingInnerClass 
{
	public static void main(String[] args) 
	{
		//###### Ways to call non-static inner class ######//
		//InnerClass ic = new User().new InnerClass();  // Or this way
		//User.InnerClass ic = new User().new InnerClass();
			
		//###### Ways to call static inner class ######//
		//InnerClass ic = new User.InnerClass(); // Or this way
		//User.InnerClass ic = new User.InnerClass();

		User s = new User.UsersBuilder()		// This is how, you can call inner static class
					.name("Ocean")
					.age(18)
					.rollNo("100A")
					.build();
		
		System.out.println(s);
	}
}

class User 
{
    public String name;
    public int age;
    public String rollNo;

	/*
	 * private User(Builder builder) // Made private so can't create object of
	 * Student class using constructor { name = builder.name; age = builder.age;
	 * rollNo = builder.rollNo; }
	 */
        
    public static class UsersBuilder 	
    {
        protected User user = new User();

        public UsersBuilder name(String name) 
        {
            user.name = name;
            return this;
        }

        public UsersBuilder age(int age) 
        {
            user.age = age;
            return this;
        }
        
        public UsersBuilder rollNo(String rollNo)
        {
        	user.rollNo = rollNo;
        	return this;
        }

        public User build() 
        {
            return user;
        }
    }

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", age=" + age + ", rollNo=" + rollNo + "]";
	}
}
