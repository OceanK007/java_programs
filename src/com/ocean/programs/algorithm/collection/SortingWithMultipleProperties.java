package com.ocean.programs.algorithm.collection;

import java.util.*;

/**
	Sort Student by id > firstname > middlename > lastname > rollNo
**/
public class SortingWithMultipleProperties 
{
	public static void main(String[] args) 
	{
		List<Student> list = new ArrayList<>();
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean3", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean2", "", "", ""));
		list.add(new Student(2, "Ocean1", "mid3", "Life8", "rollNo7"));
		list.add(new Student(2, "Ocean1", "mid3", "Life8", "rollNo6"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo5"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo5"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo5"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo4"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo3"));
		list.add(new Student(2, "Ocean1", "mid3", "Life7", "rollNo5"));
		list.add(new Student(2, "Ocean1", "mid2", "Life5", "rollNo2"));
		list.add(new Student(2, "Ocean1", "mid2", "Life5", "rollNo2"));
		list.add(new Student(2, "Ocean1", "", "Life8", "rollNo9"));
		list.add(new Student(2, "Ocean1", "", "Life8", "rollNo8"));
		list.add(new Student(2, "Ocean1", "", "Life8", "rollNo7"));
		list.add(new Student(1, "Ocean5", "", "", ""));
		list.add(new Student(1, "Ocean5", "", "", ""));
		list.add(new Student(1, "Ocean5", "", "", ""));
		list.add(new Student(1, "Ocean5", "", "", ""));
		list.add(new Student(1, "Ocean5", "", "", ""));
		list.add(new Student(1, "Ocean4", "", "", ""));
		list.add(new Student(1, "Ocean4", "", "", ""));
		list.add(new Student(1, "Ocean4", "", "", ""));
		
		Collections.sort(list);
		
		for(Student student : list)
		{
			System.out.println(student);
		}
	}
}

class Student implements Comparable<Student>
{
	int id;
	String firstName;
	String middleName;
	String lastName;
	String rollNo;
	
	public Student(int id, String firstName, String middleName, String lastName, String rollNo) 
	{
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", rollNo=" + rollNo + "]";
	}

	@Override
	public int compareTo(Student student2) 
	{
		int c;
		c = Integer.valueOf(id).compareTo(Integer.valueOf(student2.id));
		
		if(c == 0)
		{
			c = firstName.compareTo(student2.firstName);
		}
		
		if(c == 0)
		{
			c = middleName.compareTo(student2.middleName);
		}
		
		if(c == 0)
		{
			c = lastName.compareTo(student2.lastName);
		}
		
		if(c == 0)
		{
			c = rollNo.compareTo(student2.rollNo);
		}
		
		return c;
	}
}
