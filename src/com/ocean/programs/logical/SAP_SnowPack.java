package com.ocean.programs.logical;

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills. 
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/
class SAP_SnowPack
{
	  public static void main(String[] args)
	  {
		  if(doTestsPass())
		  {
		    System.out.println("All tests pass");
		  }
		  else
		  {
		    System.out.println("Tests fail.");
		  }
	  }
	  
	  /*
	  **  Returns true if the tests pass. Otherwise, returns false;
	  */
	  public static boolean doTestsPass()
	  {
		  boolean result = true;
		  result &= computeSnowpack(new int[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
		  result &= computeSnowpack(new int[]{1,0,0,0,0,0,0,0,0,0,0,1}) == 10;
		  result &= computeSnowpack(new int[]{0,0,0,0,0}) == 0;
		  result &= computeSnowpack(new int[]{0,0,1,0,0}) == 0;
		  result &= computeSnowpack(new int[]{1}) == 0;
		  result &= computeSnowpack(new int[]{}) == 0;
		  
		  return result;
	  }
	  
	  public static int computeSnowpack(int[] arr)
	  {
		  // Check for empty array
		  if(arr.length == 0)
		  {
		    return 0;
		  }
		  
		  int leftHighest = 0;
		  int rightHighest = 0;
		  int total = 0;
		 
		  int[] leftHighestArray = new int[arr.length];
		  int[] rightHighestArray = new int[arr.length];
		  for(int i=0;i<arr.length;i++)
		  {
			  if(i==0)
			  {
				  leftHighestArray[i] = 0;
			  }
			  else 
			  {
				  leftHighestArray[i] = leftHighest;
			  }
				 
			  if(arr[i] > leftHighest)
			  {
				  leftHighest = arr[i];
			  }
		  }
		  
		  for(int i=arr.length-1;i>=0;i--)
		  {
			  if(i==arr.length-1)
			  {
				  rightHighest = 0;
			  }
			  else
			  {
				  rightHighestArray[i] = rightHighest;
			  }
			  
			  if(arr[i] > rightHighest)
			  {
				  rightHighest = arr[i];
			  }
		  }
		  
		  //System.out.println(Arrays.toString(leftHighestArray));
		  //System.out.println(Arrays.toString(rightHighestArray));
		  
		  for(int i=0;i<arr.length;i++)
		  {
			  if(leftHighestArray[i]>arr[i] && rightHighestArray[i]>arr[i])
			  {
				  int min = Math.min(leftHighestArray[i], rightHighestArray[i]);
				  total = total + (min-arr[i]);
			  }
		  }
		  
		  return total;
	  }
}
