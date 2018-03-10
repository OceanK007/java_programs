package com.ocean.programs.tricky.output;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapOutput 
{
	public static void main(String[] args) 
	{
		/*TreeMap<String, String> tree = new TreeMap<>();
		tree.put(null, "One");		// java.lang.NullPointerException, since can't provide null key
		
		System.out.println(tree.size());	*/
		
		TreeMap<Student, Integer> tree = new TreeMap<>(new Comparator<Student>() 
		{
			@Override
			public int compare(Student o1, Student o2) 
			{
				if(o1.getRollNo() > o2.getRollNo())
					return 1;
				else if (o1.getRollNo() < o2.getRollNo())
					return -1;
				else 
					return 0;
			}
		});
		tree.put(new Student(2, "Stu2"),1);
		tree.put(new Student(4, "St4"),5);
		tree.put(new Student(1, "Stu1"),2);
		tree.put(new Student(5, "Stu5"),3);
		tree.put(new Student(3, "Stu3"),4);
		
		// Map will automatically sort on key basis
		System.out.println("** Sorting by key **");
		for(Map.Entry<Student, Integer> entry : tree.entrySet())
		{
			System.out.println(entry.getKey() + " : "+entry.getValue());
		}
	}
	
}

class Student
{
	private int rollNo;
	private String name;
	
	public Student(int rollNo, String name) 
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
}