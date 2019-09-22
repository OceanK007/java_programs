package com.ocean.programs.tricky.output;

import java.util.HashSet;

public class HashSetOutput 
{
	public static void main(String[] args) 
	{
		HashSet<String> set = new HashSet<>();
		set.add(null);
		set.add(null);
		System.out.println(set.size()); 	// 1
		
		HashSet<User> userSet = new HashSet<>();
		userSet.add(new User(1, "Ocean"));
		userSet.add(new User(1, "Life"));
		
		System.out.println(userSet.size());	// 1
		for(User u : userSet)
		{
			System.out.println(u);			// User [id=1, name=Ocean]
		}
	}
}

class User
{
	private int id;
	private String name;
	
	User(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	// Overriding hashcode() and equals() to make id for uniqueness
	@Override
	public int hashCode() 
	{
		return id;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof User)
		{
			User u=(User) obj;
			if(id == u.id)
			       return true;
			else 
				return false;			
		}
		else
			return false;
	}

	// Overriding toString() to display this object as string
	@Override
	public String toString() 
	{
		return "User [id=" + id + ", name=" + name + "]";
	}
}