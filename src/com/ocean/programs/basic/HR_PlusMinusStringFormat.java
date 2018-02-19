package com.ocean.programs.basic;

import java.util.Scanner;

/**
Sample Input

6
-4 3 -9 0 4 1         

Sample Output

0.500000
0.333333
0.166667

Explanation

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. 
The respective fractions of positive numbers, negative numbers and zeroes are 3/6 = 0.500000, 2/6 = 0.333333  and 1/6 = 0.166667, respectively.
**/

public class HR_PlusMinusStringFormat 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        
        for(int i=0;i<array.length;i++)
        {
            array[i] = scanner.nextInt();
        }
        
        double positive = 0;
        double negative = 0;
        double zeroes = 0;
        
        for(int j=0;j<array.length;j++)
        {
            if(array[j]==0)
                zeroes += 1;
            if(array[j]>0)
                positive += 1;
            if(array[j]<0)
                negative += 1;
        }
        
        System.out.println(String.format("%.6f",(positive/array.length)));
        System.out.println(String.format("%.6f",(negative/array.length)));
        System.out.println(String.format("%.6f",(zeroes/array.length)));
	}
}
