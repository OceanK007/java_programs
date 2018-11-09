package com.ocean.programs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		
		Collections.sort(list, new Comparator<Student>() 
		{
			@Override
			public int compare(Student student1, Student student2) 
			{
				int c;
				c = Integer.valueOf(student1.id).compareTo(Integer.valueOf(student2.id));
				
				if(c == 0)
				{
					c = student1.firstName.compareTo(student2.firstName);
				}
				
				if(c == 0)
				{
					c = student1.middleName.compareTo(student2.middleName);
				}
				
				if(c == 0)
				{
					c = student1.lastName.compareTo(student2.lastName);
				}
				
				if(c == 0)
				{
					c = student1.rollNo.compareTo(student2.rollNo);
				}
				
				return c;
			}
		});
		
		for(Student student : list)
		{
			System.out.println(student);
		}
	}
}

class Student
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
}
