package com.ocean.programs.basic;

import java.util.Scanner;

/**
Sample Input

1 2 3 4 5

Sample Output

10 14

Explanation

Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following sums using four of the five integers:

If we sum everything except 1, our sum is 2+3+4+5=14.
If we sum everything except 2, our sum is 1+3+4+5=13.
If we sum everything except 3, our sum is 1+2+4+5=12.
If we sum everything except 4, our sum is 1+2+3+5=11.
If we sum everything except 5, our sum is 1+2+3+4=10.

As you can see, the minimal sum is 1+2+3+4=10 and the maximal sum is 2+3+4+5=14. Thus, we print these minimal and maximal sums as two space-separated integers on a new line.
 */

public class MinMaxSumInArray 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++)
        {
            arr[arr_i] = in.nextInt();
        }
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        for(int arr_j=0;arr_j<5;arr_j++)
        {
        	long sum = 0;
        	for(int arr_k=0; arr_k<5; arr_k++)
        	{
        		if(arr_j != arr_k)
        		{
        			sum = sum+arr[arr_k];
        		}
        	}
        	
        	if(sum < min)
        	{
        		min = sum;
        	}
        	if(sum > max)
        	{
        		max = sum;
        	}
        }
        
        System.out.println(min+" "+max);
	}
}
