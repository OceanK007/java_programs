package com.ocean.programs.tricky.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareToReturnValue 
{
	public static void main(String[] args) 
	{
		List<Student2> list = new ArrayList<>();
		list.add(new Student2(5, "Five"));
		list.add(new Student2(3, "Three"));
		list.add(new Student2(1, "One"));
		
		Collections.sort(list);
		
		System.out.println(list);	
		// [Student [rollNo=1, name=One], Student [rollNo=3, name=Three], Student [rollNo=5, name=Five]]
	}
}

class Student2 implements Comparable<Student2>
{
	private int rollNo;
	private String name;
	
	public Student2(int rollNo, String name) 
	{
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}

	// So compareTo method can return any positive or negative value
	@Override
	public int compareTo(Student2 o) 
	{
		if(o.rollNo > this.rollNo)
			return -1000;
		else if (o.rollNo < this.rollNo)
			return 1000;
		else
			return 0;
	}
}