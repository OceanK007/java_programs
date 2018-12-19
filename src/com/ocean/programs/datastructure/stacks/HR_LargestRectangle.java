package com.ocean.programs.datastructure.stacks;

import java.util.Scanner;

/** 
Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed.

There are a number of buildings in a certain two-dimensional landscape. Each building has a height, h[i] given by . If you join k adjacent buildings, they will form a solid rectangle of area k x min(h[i],h[i+1],...h[i+k-1]).

For example, the heights array h = [3,2,3]. A rectangle of height h=2 and length k=3 can be constructed within the boundaries. The area formed is h*k=2*3=6.

Function Description:
Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.

largestRectangle has the following parameter(s):

h: an array of integers representing building heights

Input Format
The first line contains , the number of buildings. 
The second line contains  space-separated integers, each representing the height of a building.

Output Format
Print a long integer representing the maximum area of rectangle formed.

Sample Input
5
1 2 3 4 5

Sample Output
9

Image URL: https://s3.amazonaws.com/hr-challenge-images/8136/1436794554-75e178e325-drawing47.svg
Question URL: https://www.hackerrank.com/challenges/largest-rectangle/problem
**/
public class HR_LargestRectangle 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer totalBuilding = scanner.nextInt();
		scanner.nextLine();	// Skipping one line
		String buildingHeights = scanner.nextLine();
		System.out.println(totalBuilding);
		System.out.println(buildingHeights);
		//int[] heightArray = 
	}
	
	//public static findMaximumArea()
}
