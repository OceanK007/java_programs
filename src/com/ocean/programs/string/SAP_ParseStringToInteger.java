package com.ocean.programs.string;

import java.util.*;

// Takes a string str and returns the int value represented bythe string. 
// For example, "42" returns 42.
// Ascii code of 0 = 48, 1 = 49, 2=50 .. 9 = 57

public class SAP_ParseStringToInteger 
{
	public static void main(String[] args) 
	{
		if(doTestsPass())
	    {
			System.out.println("All tests pass");
	    }
	    else
	    {
	    	System.out.println("There are test failures");
	    }
	}
	
	public static boolean doTestsPass()
	{
		  boolean result = true;
		  result = result && parseToInteger("0") == 0;
		  result = result && parseToInteger("1") == 1;
		  result = result && parseToInteger("123") == 123;
		  result = result && parseToInteger("-1") == -1;
		  result = result && parseToInteger("-123") == -123;
		  result = result && parseToInteger("123a") == 123;
		  result = result && parseToInteger("a") == 0;
		
		  String intMax = String.valueOf(Integer.MAX_VALUE);
		  result = result && parseToInteger(intMax) == Integer.MAX_VALUE;
		
		  String intMin = String.valueOf(Integer.MIN_VALUE);
		  result = result && parseToInteger(intMin) == Integer.MIN_VALUE;
		
		  return result;
	};
	
	public static int parseToInteger(String source)
	{
		char[] charArray = source.toCharArray();
		ArrayList<Integer> asciiArray = new ArrayList();
		
		for(int i=0;i<charArray.length;i++)
		{
			int asciiValue = (int) charArray[i];
			if(asciiValue >= 48 && asciiValue <= 57)
			{
				asciiArray.add(asciiValue);
			}
		}
		
		//System.out.println(asciiArray);
		
		Integer target = 0;
		Integer format = 1;
		// 1 = 49 = 49 - 48 = 1 => 1 x 100 = 100
		// 2 = 50 = 50 - 48 = 2 => 2 x 10 = 20
		// 3 = 51 = 51 - 48 = 3 => 3 x 1 = 3
		// 100 + 20 + 3 = 123
		for(int i=asciiArray.size()-1;i>=0;i--)
		{
			target = target + ((asciiArray.get(i)-48) * format) ;
			
			format= format*10;
		}
		
		//System.out.println(target);
		
		if(String.valueOf(source.charAt(0)).equals("-"))
		{
			target = 0 - target;
		}
		
		//System.out.println(target);
		
		return target;
	}
}
