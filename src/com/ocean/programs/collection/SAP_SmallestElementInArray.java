package com.ocean.programs.collection;

/*
 * public static int FindMin(int a[])
 * Returns the smallest number in array that has been rotated
 * For example - Array {3,4,5,6,1,2} returns 1
*/

public class SAP_SmallestElementInArray
{
  public static int findMin(int a[])
  {
	   int smallestElement = a[0];
	   for(int i=1;i<a.length;i++)
	   {
		   if(a[i] < smallestElement)
		   {
			   smallestElement = a[i];
		   }
	   }
	   return smallestElement;
  }

  public static void main(String args[])
  {
		boolean result = true;
		result = result && findMin(new int[]{3,4,5,6,1,2}) == 1;
		result = result && findMin(new int[]{2,1}) == 1;
		result = result && findMin(new int[]{1}) == 1;
		
		try 
		{
			findMin(null);
			result = false;
		}
		catch(Exception e)
		{
		  result = result && true;
		}
		
		if(result)
		{
		  System.out.println("All tests pass");
		}
		else
		{
		  System.out.println("There are test failures");
		}
  }
}
