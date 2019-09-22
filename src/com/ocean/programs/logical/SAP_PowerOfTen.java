package com.ocean.programs.logical;

/**
 * Returns true if x is a power-of-10.
 * 
 *  10 = true
 *  100 = true
 *  110 = false
 *  3 = false
 */
public class SAP_PowerOfTen 
{
	public static void main(String[] args) 
	{
		int[] isPowerList = {10, 100};
		int[] isNotPowerList = {3, 110};

		for(int i : isPowerList)
		{
		    if(!isPowerOf10(i))
		    {
		    	System.out.println("Test failed for: " + i);
		    }
		}

		for(int i : isNotPowerList)
		{
		    if(isPowerOf10(i))
		    {
		    	System.out.println("Test failed for: " + i);
		    }
		}
		
		System.out.println("All tested passed");
	}
	
	public static boolean isPowerOf10(int x)
	{
		if(x < 10)
			return false;
		else
		{
			long source = 10;
			boolean result = true;
			while(true)
			{
				if(x == source)
				{
					result = true;
					break;
				}
				else
				{
					source = source * 10;
					if(source > x)
					{
						result = false;
						break;
					}
				}
			}
			
			return result;
		}
	}
}