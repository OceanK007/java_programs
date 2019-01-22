package com.ocean.programs.logical;

/* 
 * Given base and integer exponent, compute value of base raised to the power of exponent.
 * 
 * 2 ^ 2 = 4
 * 4 ^ 2 = 8
 */
public class SAP_ComputeValueRaisedToPowerOfExponent 
{
	public static void main(String[] args) 
	{
		boolean result = true;
		result = result & power(2,2) == 4;
		result = result & power(4,2) == 16;
		result = result & power(13,1) == 13;
		
		if(result)
		{
		     System.out.println("Pass");
		}
		else
		{
			 System.out.println("There are failures");
		}
	}
	
	public static double power(double base, int exp) 
	{
		double result = 1;
	    for(int i=1;i<=exp;i++)
	    {
	    	result = result * base;
	    }
	    return result;
	}
}