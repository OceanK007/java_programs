package com.ocean.programs.logical;

/**
* Given two arrays of integers, returns the dot product of the arrays
* {1, 2}, {2, 3} = 1*2 + 2*3 = 2 + 6 = 8 
*/
public class SAP_DotProductOfTwoArray 
{
	public static void main(String[] args) 
	{
		int[] array1 = { 1, 2 };
	    int[] array2 = { 2, 3 };
	    int result = dotProduct(array1, array2);

	    if( result == 8 ) 
	    {
	    	System.out.println( "Passed." );
	    } 
	    else 
	    {
	    	System.out.println( "Failed." );
	    }
	}
	
	public static int dotProduct( int[] array1, int[] array2 ) 
	{
		int result = 0;
		for(int i=0;i<array1.length;i++)
		{
			result = result + (array1[i]*array2[i]);
		}
		return result;
	}
}
