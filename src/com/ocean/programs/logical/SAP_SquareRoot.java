package com.ocean.programs.logical;

/**
Newton's Iteration:  X(n+1) = (X(n) + number/X(n))/2
 */
public class SAP_SquareRoot 
{
	public static void main(String[] args) 
	{
		double[] inputs = {2, 4, 100};
	    double[] expected_values = {1.41421, 2, 10};
	    double threshold = 0.001;
	    
	    for(int i=0; i < inputs.length; i++)
	    {
			if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
			{
				System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
			}
	    }
	    System.out.println( "All tests passed");
	}
	
	public static double squareRoot( double number )
	{
		double t;
		 
		double squareRoot = number / 2;
		System.out.println("squareRoot: "+squareRoot);
	 
		do 
		{
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
			System.out.println("sqrt: "+squareRoot);
		} 
		while ((t - squareRoot) != 0);
	 
		System.out.println(squareRoot);
		return squareRoot;
	}
}