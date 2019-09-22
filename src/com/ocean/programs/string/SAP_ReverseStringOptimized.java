package com.ocean.programs.string;

import java.util.Arrays;

public class SAP_ReverseStringOptimized 
{
	public static void main(String[] args) 
	{
		 boolean result = true;

		 result = result & reverseStr("abcd").equals("dcba");
		 result = result & reverseStr("abcde").equals("edcba");
		  
		 if(result)
		 {
		    System.out.println("All tests pass");
		 }
		 else
		 {
		    System.out.println("There are test failures");
		 }
	}
	
	public static String reverseStr(String str)
	{
		char[] sourceArray = str.toCharArray();
		char[] resultArray = new char[str.length()];
		
		int mid = (sourceArray.length / 2);	// Looping till half
		for(int i=0;i<=mid;i++)
		{
			char front = sourceArray[i];
			char rear = sourceArray[sourceArray.length-(i+1)];
			
			resultArray[i] = rear;
			resultArray[sourceArray.length-(i+1)] = front;
			
			
		}
		
		//System.out.println(Arrays.toString(resultArray));
		
		StringBuilder sb = new StringBuilder();
		sb.append(resultArray);
		
	    return sb.toString();
	};
}
