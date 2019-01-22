package com.ocean.programs.logical;

/*
** 
** https://www.mathsisfun.com/pascals-triangle.html
**
** 
**  Below formation is called Pascals Triangle.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(col,row) = pascal(1,2) should return 2
**
**	Formula is: (row, col) = row! / col!(row-col)!
**
*/

public class SAP_PascalTriangleElementValue 
{
	public static void main(String[] args) 
	{
		 if(pascal(0,0) ==  1 &&
			pascal(1,2) ==  2 &&
			pascal(5,6) ==  6 &&
			pascal(4,8) ==  70 &&
			pascal(6,6) ==  1) 
		 {
			  System.out.println("Pass");		  
		 }
		 else 
		 {
			  System.out.println("Failed");
		 }
	}
	
	public static int pascal(int col, int row)
	{
		int numerator = factorial(row);
		int denominator = factorial(col) * factorial(row-col);
		
		int result = numerator/denominator;
		
		//System.out.println(result);
		
		return result;
	}

	public static int factorial(int num)
	{
		int result = 1;
		
		if(num == 0)
			return result;
		
		for(int i=num;i>0;i--)
		{
			result = result * i;
		}
		
		return result;
	}
}