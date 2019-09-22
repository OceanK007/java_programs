package com.ocean.programs.logical;

/**
 * Given two fractions passed in as int arrays,
 * returns the fraction which is result of adding the two input fractions.
 * 2/3 + 1/2 = 7/6
 * 2/4 + 1/2 = 4/4 = (4/4)/(4/4) = 1/1
 */
public class SAP_SumOfFractions 
{
	public static void main(String[] args) 
	{
		int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );
		int[] result2 = addFractions( new int[]{ 2, 4 }, new int[]{ 1, 2 } );

		boolean overall = true;
		overall = overall &  (result[0] == 7 && result[1] == 6);
		overall = overall &  (result2[0] == 1 && result2[1] == 1);
		
	    if(overall) 
	    {
	    	System.out.println( "Test passed." );
	    }
	    else 
	    {
	    	System.out.println( "Test failed." );
	    }
	}
	
	public static int[] addFractions( int[] fraction1, int[] fraction2 ) 
	{
		int denominator = lcm(fraction1[1], fraction2[1]);
		int numerator = (fraction1[0] * (denominator/fraction1[1])) + (fraction2[0] * (denominator/fraction2[1]));
		int gcd = gcd(numerator, denominator);
		numerator = numerator/gcd;
		denominator = denominator/gcd;
		
		//System.out.println(numerator);
		//System.out.println(denominator);
						
		return ( new int[]{ numerator, denominator } );
	}
	
	public static int lcm(int a, int b)
	{
		//System.out.println("a: "+a+" | b: "+b);
		int lcm = (a > b) ? a : b;
		
		while(true)
		{
			if((lcm % a == 0) && (lcm % b == 0))
			{
				break;
			}
			
			lcm++;
		}
		
		//System.out.println("LCM: "+lcm);
		
		return lcm;
	}
	
	public static int gcd(int a, int b)
	{
		//System.out.println("a: "+a+" | b: "+b);
		int gcd = 1;
		int smallest = (a > b) ? b : a;
		
		//System.out.println("smallest: "+smallest);
		for(int i=1; i<=smallest;i++)
		{
			if(a%i == 0 && b%i == 0)
			{
				gcd = i;
			}
		}
		
		//System.out.println("GCD: "+gcd);
		return gcd;
	}
}