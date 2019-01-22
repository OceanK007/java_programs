package com.ocean.programs.string;

/**
*
* You have an integer array.
* Starting from arr[startIndex], follow each element to the index it points to. 
* Continue to do this until you find a cycle. 
* Return the length of the cycle. If no cycle is found return -1
*
*/
public class SAP_CountLengthOfCycle 
{
	public static void main(String[] args) 
	{
		 boolean testsPassed = true;
		  
		 testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
		 testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
		  
		 if(testsPassed) 
		 {
		    System.out.println( "Test passed." );
		 } 
		 else 
		 {
		    System.out.println( "Test failed." );
		 }
	}
	
	public static int countLengthOfCycle(int[] arr, int startIndex) 
	{
		return -1;
	}
}