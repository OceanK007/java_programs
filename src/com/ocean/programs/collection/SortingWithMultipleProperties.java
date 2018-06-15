package com.ocean.programs.collection;

import java.util.ArrayList;
import java.util.List;

public class SortingWithMultipleProperties 
{
	public static void main(String[] args) 
	{
		List<Student> list = new ArrayList<>();
		list.add(new Student(15, "Raju", "15_middle", "15_last", "15_roll"));
		list.add(new Student(14, "Ashutosh", "15_middle", "15_last", "15_roll"));
		list.add(new Student(13, "Sandeep", "15_middle", "15_last", "15_roll"));
		list.add(new Student(12, "Rajeev", "15_middle", "15_last", "15_roll"));
		list.add(new Student(11, "Kanhaiya", "15_middle", "15_last", "15_roll"));
		list.add(new Student(10, "Aarti", "15_middle", "15_last", "15_roll"));
		list.add(new Student(9, "Chandra", "15_middle", "15_last", "15_roll"));
		list.add(new Student(8, "Varsha", "15_middle", "15_last", "15_roll"));
		list.add(new Student(7, "Varsha2", "15_middle", "15_last", "15_roll"));
		list.add(new Student(6, "Sandeep2", "15_middle", "15_last", "15_roll"));
		list.add(new Student(5, "Ashutosh2", "15_middle", "15_last", "15_roll"));
		list.add(new Student(4, "Rajeev2", "15_middle", "15_last", "15_roll"));
		list.add(new Student(3, "Aarti2", "15_middle", "15_last", "15_roll"));
		list.add(new Student(2, "Rajeev3", "mid_a", "15_last", "15_roll"));
		list.add(new Student(19, "Rajeev5", "15_middle", "15_last", "15_roll"));
		list.add(new Student(17, "Rajeev7", "15_middle", "15_last", "15_roll"));
		list.add(new Student(16, "Rajeev4", "15_middle", "15_last", "15_roll"));
		list.add(new Student(18, "Rajeev6", "15_middle", "15_last", "15_roll"));
	}
}

class Student
{
	int id;
	String firstName;
	String middleName;
	String lastName;
	String rollNo;
	
	public Student(int id, String firstName, String middleName, String lastName, String rollNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.rollNo = rollNo;
	}
}
