package com.ocean.programs.design.pattern.creational;

public class BuilderPattern 
{
	public static void main(String[] args) 
	{
		Student s = new Student.Builder()		// This is how, you can call inner static class
					.name("Ocean")
					.age(18)
					.rollNo("100A")
					.build();
		
		System.out.println(s);
	}
}

class Student 
{
    private String name;
    private int age;
    private String rollNo;

    private Student(Builder builder) 	// Made private so can't create object of Student class using constructor
    {
        name = builder.name;
        age = builder.age;
        rollNo = builder.rollNo;
    }
    
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

        public Student build() 
        {
            return new Student(this);
        }
    }

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", age=" + age + ", rollNo=" + rollNo + "]";
	}
}
