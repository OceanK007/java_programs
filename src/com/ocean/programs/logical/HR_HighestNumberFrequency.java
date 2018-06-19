package com.ocean.programs.logical;

import java.util.Scanner;

/**
Sample Input 

4
3 2 1 3

Sample Output 

2

Explanation 

We have one candle of height 1, one candle of height 2, and two candles of height 3. 
Colleen only blows out the tallest candles, meaning the candles where height=3. Because there are 2 such candles, we print 2 on a new line. 
**/
public class HR_HighestNumberFrequency 
{
	static int birthdayCakeCandles(int n, int[] ar) {
        int max = 0;
        int counter = 0;
       for(int i=0;i<n;i++)
       {
           if(max < ar[i])
           {
               max = ar[i];
               counter = 0;
           }
           if(max == ar[i])
           {
               counter += 1;
           }
       }
        
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
