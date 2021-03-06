package com.ocean.programs.patterns.staircase;

import java.io.IOException;
import java.util.Scanner;

/**
Input Format 
You are given an integer N depicting the height of the staircase.
Constraints

1<=N<=100

Output Format

Draw a staircase of height N in the format given below.
For example:
     #
    ##
   ###
  ####
 #####
######
Staircase of height 6, note that last line has 0 spaces before it.
**/

public class StairCase1 
{
	public static void main(String[] args) 
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input int value: ");
		Integer height = Integer.valueOf(scanner.nextLine());
		
		for(int i=1 ; i<=height ; i++)
		{
			for(int j=1; j<=height; j++)
			{
				int limit = height-i;
				if(j<=limit)
					System.out.print(" ");
				else
					System.out.print("#");
			}
			System.out.println("");
		}
	}
}
