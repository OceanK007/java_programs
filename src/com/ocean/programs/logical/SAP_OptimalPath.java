package com.ocean.programs.logical;

public class SAP_OptimalPath 
{
	  public static Integer optimalPath(Integer[][] grid)
	  {
		  if(grid.length == 0 || grid[0].length == 0)
		  {
			  return 0;
		  }
		  
		  for(Integer row = grid.length-1; row >= 0; row--)
		  {
			  
		  }
		  Integer result = grid[0][grid[0].length-1];
		  System.out.println(result);
		  return result;
	  }

	  public static boolean doTestsPass()
	  {
		  boolean result = true;
		  // Base test case
	//	  result &= optimalPath(new Integer[][]{
    // 						  {0,0,0,0,5},
	//	                      {0,1,1,1,0},
	//	                      {2,0,0,0,0}}) == 10;
		  // Random numbers
		  result &= optimalPath(new Integer[][]{
			  				  {1,3,2,0,2,1,8},
		                      {3,4,1,2,0,1,1},
		                      {1,1,1,2,3,2,1},
		                      {1,0,1,1,4,2,1}}) == 25;
		  // All 0's
	//	  result &= optimalPath(new Integer[][]{
	//	  					  {0,0,0,0,0},
	//	                      {0,0,0,0,0},
	//	                      {0,0,0,0,0},
	//	                      {0,0,0,0,0}}) == 0;
		  // Many optimal paths
	//	  result &= optimalPath(new Integer[][]{
	//	  					  {1,1,1,1,1},
	//	                      {1,0,1,0,1},
	//	                      {1,0,1,0,1},
	//	                      {1,1,1,1,1}}) == 8;
		  // Empty grid
	//	  result &= optimalPath(new Integer[][]{{}}) == 0;
		  
		  return result;
	  }

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
}
