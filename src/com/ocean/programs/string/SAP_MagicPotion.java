package com.ocean.programs.string;

import java.util.*;

/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/
public class SAP_MagicPotion 
{
	public static void main(String[] args) 
	{
		if (minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5)
		{
		    System.out.println( "Pass" );
		}
		else
		{
		    System.out.println( "Fail" );
		}
	}
	
	private static int minimalSteps( String ingredients )
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<ingredients.length();i++)
		{
			//System.out.println("i:"+i);
			String s = String.valueOf(ingredients.charAt(i));
			if(!sb.toString().contains(s))
			{
				sb.append(s);
				//System.out.println(sb);
			}
			else
			{
				int sbLength = sb.toString().length();
				//System.out.println("i"+i);
				//System.out.println("sbLength: "+sbLength);
				//System.out.println("sbLength+i: "+(sbLength+i));
				//System.out.println("sbLength-1: "+(sbLength-1));
				//System.out.println("(sbLength+i) <ingredients.length(): "+((sbLength+i) <ingredients.length()));
				String subStr = ingredients.substring(i,((sbLength+i) <ingredients.length() ? (sbLength+i) : ingredients.length() ));
				//System.out.println("subStr: "+subStr);
				if(subStr.equals(sb.toString()))
				{
					sb.append("*");
					ingredients = ingredients.substring(i+sb.toString().length()-1);
					i = -1;
					//System.out.println("i"+i);
					//System.out.println("ingredients: "+ingredients);
					//System.out.println(sb.toString());
				}
				else
				{
					sb.append(s);
				}
			}
		}
		return sb.length();
	}
}
