package com.ocean.programs.string;

import java.util.*;

public class SAP_UniqueTuples 
{
	public static void main(String[] args) 
	{
		String input = "aab";
	    HashSet<String> result = uniqueTuples(input, 2);
	    if( result.contains( "aa" ) && result.contains( "ab" ) ) 
	    {
	    	System.out.println( "Test passed." );
	    } 
	    else 
	    {
	    	System.out.println( "Test failed." );
	    }
	}
	
	public static HashSet<String> uniqueTuples(String input, int tupleLength) 
	{
	    HashSet<String> result = new HashSet<String>();
	    
	    for(int i=0;i<=input.length()-tupleLength;i++)
	    {
	    	result.add(input.substring(i, (tupleLength+i < input.length() ? tupleLength : input.length())));
	    }
	    
	    System.out.println(result);
	    return result;
	}
}
