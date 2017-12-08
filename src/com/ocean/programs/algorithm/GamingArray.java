package com.ocean.programs.algorithm;

import java.util.Scanner;

/** 
Andy loves playing games. He wants to play a game with his little brother, Bob, using an array, A, of n distinct integers. The rules are as follows:

* Bob always plays first and the two players move in alternating turns.
* In a single move, a player chooses the maximum element currently present in the array and removes it as well as all the other elements to its right. 
  For example, if , A = [2,3,5,4,1] then it becomes A = [2,3] after the first move because we remove the maximum element (i.e., 5) and all elements to its right (i.e., 4 and 1).
* The modifications made to the array during each turn are permanent, so the next player continues the game with the remaining array. The first player who is unable to make a move loses the game.
  
Andy and Bob play  games. Given the initial array for each game, can you find and print the name of the winner on a new line? If Andy wins, print ANDY; if Bob wins, print BOB.



Sample Input 0

2
5
5 2 6 3 4
2
3 1

Sample Output 0

ANDY
BOB

Explanation 0

Andy and Bob play the following two games:

1. Initially, the array looks like this: 
		5,2,6,3,4
	In the first move, Bob removes  and all the elements to its right, resulting in A = [5,2]: 
		5,2
	In the second move, Andy removes  and all the elements to its right, resulting in A = []: 
		no elements in array

	At this point, the array is empty and Bob cannot make any more moves. This means Andy wins, so we print ANDY on a new line.

2. In the first move, Bob removes  and all the elements to its right, resulting in A = []. As there are no elements left in the array for Andy to make a move, Bob wins and we print BOB on a new line.
**/
public class GamingArray 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int games = in.nextInt();
        
        for(int a0 = 0; a0 < games; a0++)
        {
            int size = in.nextInt();
            int max = Integer.MIN_VALUE;
            int counter = 0;
            for(int i=0;i<size;i++)
            {
            	int element = in.nextInt();
            	
            	if(element > max)
            	{
            		max = element;
            		counter += 1;
            	}
            }
            
            if(counter % 2 == 0)
            {
            	System.out.println("ANDY");
            }
            else
            	System.out.println("BOB");
        }
	}
}
