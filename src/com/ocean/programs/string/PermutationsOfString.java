package com.ocean.programs.string;

import java.util.Scanner;
import java.util.Set;

/** 
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list
 
A string of length n has n! permutation.
 
Permutations of string ABC: 
ABC ACB BAC BCA CBA CAB
3! = 3*2*1 = 6

Permutations of string AABC:
4! / 2! = (4*3*2*1)/(2*1) = 24/2 = 12

Permutations of string AABBBC:
6! / 2!*3! = (6*5*4*3*2*1)/((2*1)*(3*2*1)) = 720/12 = 60
 **/
public class PermutationsOfString 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
	
		System.out.println("Total permutations: "+computePermutations(s));
	}
	
	public static Set<String> computePermutations(String s)
	{
		
		return null;
	}
}
