package com.ocean.programs.design.pattern.creational;

public class BuilderPattern 
{
	public static void main(String[] args) 
	{
		//###### Ways to call non-static inner class ######//
		//InnerClass ic = new User().new InnerClass();  // Or this way
		//User.InnerClass ic = new User().new InnerClass();
		
		//###### Ways to call static inner class ######//
		//InnerClass ic = new User.InnerClass(); // Or this way
		//User.InnerClass ic = new User.InnerClass();

		User s = new User.Builder()		// This is how, you can call inner static class
					.name("Ocean")
					.age(18)
					.rollNo("100A")
					.build();
		
		System.out.println(s);
	}
}

class User 
{
    private String name;
    private int age;
    private String rollNo;

    private User(Builder builder) 	// Made private so can't create object of Student class using constructor
    {
        name = builder.name;
        age = builder.age;
        rollNo = builder.rollNo;
    }
        
    // Static inner class can't access non-static fields and methods of outer class. But can access constructor of outer (which are non-static)
    public static class Builder 	
    {
        private String name;
        private int age;
        private String rollNo;

        public Builder name(String name) 
        {
            this.name = name;
            return this;
        }

        public Builder age(int age) 
        {
            this.age = age;
            return this;
        }
        
        public Builder rollNo(String rollNo)
        {
        	this.rollNo = rollNo;
        	return this;
        }

        public User build() 
        {
            return new User(this);
        }
    }

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", age=" + age + ", rollNo=" + rollNo + "]";
	}
}
