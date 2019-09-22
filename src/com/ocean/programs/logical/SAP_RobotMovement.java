package com.ocean.programs.logical;

import java.util.*;

//Implement the 'walk' method.
//Assume robot inital position is (0,0).
//walk method take path where each character corresponds to a movement of the robot.
//The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
//Ignore other characters.

public class SAP_RobotMovement 
{
	public static void main(String[] args) 
	{
		if(pass())
		{
		    System.out.println("Pass");
		} 
		else 
		{
		    System.out.println("Test failures");
		}
	}
	
	public static boolean pass() 
	{
		  boolean res = true;

		  {
		    String test = "UUU";
		    Integer[] result = walk(test);
		    res &= Arrays.equals(result, new Integer[]{0, 3});
		  }

		  {
		    String test = "ULDR";
		    Integer[] result = walk(test);
		    res &= Arrays.equals(result, new Integer[]{0, 0});
		  }

		  {
		    String test = "ULLLDUDUURLRLR";
		    Integer[] result = walk(test);
		    res &= Arrays.equals(result, new Integer[]{-2, 2});
		  }

		  {
		    String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
		    Integer[] result = walk(test);
		    res &= Arrays.equals(result, new Integer[]{1, 1});
		  }

		  return res;
	}

	// your code
	public static Integer[] walk(String path) 
	{
		int x = 0;
		int y = 0;
		
		for(int i=0;i<path.length();i++)
		{
			char c = path.charAt(i);
			
			switch (c)
			{
				case 'U':
					y = y+1;
					break;
				case 'D':
					y = y - 1;
					break;
				case 'R':
					x = x + 1;
					break;
				case 'L':
					x = x - 1;
					break;
			}
		}
		
		return new Integer[] {x, y};
	}
}
