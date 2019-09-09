package com.ocean.programs.matrix;

import java.util.Scanner;

/**
	Working with 2D arrays is quite important. Here we will do swapping of columns in a 2D array. You are given a matrix M of r rows and c columns. You need to swap the first column with the last column.
	
	Input Format:
	The first line of input contains T, the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains r and c, separated by a space. The next r lines contains c elements of the matrix, separated by spaces.
	
	Output Format:
	For each testcase, in a new line, print the modified matrix.
	
	Your Task:
	Since this is a function problem, you don't need to take any input. Just complete the provided function interchange(int ,  int ) that take rows and columns number as parameter.
	
	Constraints:
	1 <= T <= 100
	1 <= r,c <= 100
	
	Example:
	Input:
	1
	3 4
	1 2 3 4
	4 3 2 1
	6 7 8 9
	Output:
	4 2 3 1
	1 3 2 4
	9 7 8 6
 */
public class GFG_MatrixInterchange 
{
	static int matrix[][] = null;
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		
		while(tests-- > 0)
		{
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			
			matrix = new int[rows][columns];
			
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<columns;j++)
				{
					int element = scanner.nextInt();
					matrix[i][j] = element;
				}
			}
			
			System.out.println("Before");
			printMatrix(rows, columns);
			interchange(rows, columns);
			System.out.println("After");
			printMatrix(rows, columns);
		}
	}
	
	public static void interchange(int rows, int columns)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(j==0)
				{
					int length = matrix[i].length;
					int temp = matrix[i][length-(j+1)];
					matrix[i][length-(j+1)] = matrix[i][j];
					matrix[i][j] = temp;
				}
			}
		}
	}
	
	public static void printMatrix(int rows, int columns)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
