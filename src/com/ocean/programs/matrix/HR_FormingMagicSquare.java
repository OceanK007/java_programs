package com.ocean.programs.matrix;

import java.io.IOException;
import java.util.Scanner;

/** HARD **/

/**
Magical Square of size 3:
These are 8 , 3x3 matrix . These matrices are special in such a way that the sum of the each rows,columns,diagonal 1, diagonal 2 is equal to 15.
The fun part is that only 1 matrix is to be generated ,rest 7 are the reflections and rotations of that matrix.

Points:
	1. 5 is always in middle of matrix
	2. Corners are always even numbers
	3. Middle element between corners is always odd number
	4. Numbers 1 to 9 are used to create magic square and no number is repeated.
 */

/** 
We define a magic square to be an n x n matrix of distinct positive integers from 1 to n^2 where the sum of any row, column, or diagonal of length n is always equal to the same number: the magic constant.

You will be given a 3 x 3 matrix s of integers in the inclusive range [1,9]. We can convert any digit a to any other digit b in the range [1,9] at cost of |a-b|. 
Given s, convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range [1,9]. 

For example, we start with the following matrix s:
5 3 4
1 5 8
6 4 2
We can convert it to the following magic square:
8 3 4
1 5 9
6 7 2
This took three replacements at a cost of |5-8|+|8-9|+|4-7| = 7.


Sample Input 0
4 9 2
3 5 7
8 1 5
Sample Output 0
1
Explanation 0
If we change the bottom right value, s[2][2], from 5 to 6 at a cost of |6-5| = 1, s becomes a magic square at the minimum possible cost.

Sample Input 1
4 8 2
4 5 7
6 1 6
Sample Output 1
4
Explanation 1
s[0][1]->9 at a cost of |9-8| = 1
s[1][0]->3 at a cost of |3-4| = 1
s[2][0]->8 at a cost of |8-6| = 2,
then the total cost will be 1+1+2=4.
**/

public class HR_FormingMagicSquare 
{
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) 
        {
            String[] sRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        System.out.println(formingMagicSquare(s));

        scanner.close();
    }
    
    static int formingMagicSquare(int[][] s) 
    {
    	// We need to find a way to generate these eight matrices
        int[][][] totalSquares = 
        {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;
        int count = 0;

        for(int i=0;i<totalSquares.length;i++)
        {
        	count = 0;
        	
            for(int j=0;j<totalSquares[i].length;j++)
            {
                for(int k=0;k<totalSquares[i][j].length;k++)
                {
                    if(totalSquares[i][j][k] != s[j][k])
                    {
                    	count += Math.abs(totalSquares[i][j][k] - s[j][k]);
                    }
                }          
            }
            
            //System.out.println("Count: "+count);

            if(count < minCost)
            {
                minCost = count;
            }
        }
        
        return minCost;
    }
}
