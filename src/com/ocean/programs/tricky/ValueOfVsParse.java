package com.ocean.programs.tricky;

public class ValueOfVsParse 
{
	public static void main(String[] args) 
	{
		String s = "565656";
		
		Long l = Long.valueOf(s);		// It will return Wrapper class Long
		Long l2 = Long.parseLong(s);	// It will return primitive long	// so later it will do autoboxing and convert primitive to wrapper
		
		// So wherever possible use valueOf() instead of parseLong(). But if you need primitive then simply use parseLong();
	}
}