package com.ocean.programs.algorithm.implementation;

/**
Towers of Hanoi. recursive solution to towers of Hanoi In the towers of Hanoi problem, 
we have three poles and n discs that fit onto the poles. 
The discs differ in size and are initially stacked on one of the poles, 
in order from largest (disc n) at the bottom to smallest (disc 1) at the top. 
The task is to move all n discs to another pole, while obeying the following rules:
Move only one disc at a time.
Never place a larger disc on a smaller one.
**/

public class TowerOfHanoi 
{
	public static void main(String[] args) 
	{
		int[] tower1 = {8,5,2};
		int[] tower2 = new int[5];
		int[] tower3 = new int[5];
		
		towerOfHanoi(tower1,tower2,tower3);
	}
	
	public static void towerOfHanoi(int[] tower1, int[] tower2, int[] tower3)
	{
//		if(tower2.length == 0 || tower2[tower2.length-1] )
			
	}
}
