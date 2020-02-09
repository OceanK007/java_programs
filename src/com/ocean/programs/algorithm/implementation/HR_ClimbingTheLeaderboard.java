package com.ocean.programs.algorithm.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HR_ClimbingTheLeaderboard 
{
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard2(scores, alice);
        System.out.println(Arrays.toString(result));
        
        scanner.close();
    }
    
    // First approach : Will give timeout exception in hackerrank long test cases
    static int[] climbingLeaderboard(int[] scores, int[] alice) 
    {
    	int[] ranks = new int[alice.length];
    	
    	for(int a=0;a<alice.length;a++)
    	{
    		int previousElement = -1;
            int rank = 0;
            
        	for(int i=0;i<scores.length;i++)
        	{
        		 if(previousElement == -1 || previousElement != scores[i])
                 {
                     rank++;
                 }
                 
                 previousElement = scores[i];
                 
                 if(scores[i] == alice[a] || scores[i] < alice[a])
                	 break;
                 // In case score is at the end
	             if(i==scores.length-1)
	             {
	            	 rank++;
	             }
	    	}
    	
	    	ranks[a]=rank;
		}

    	return ranks; 
    }
    
    // Second approach : Will give timeout exception in hackerrank long test cases
    static int[] climbingLeaderboard2(int[] scores, int[] alice) 
    {
    	int[] newScores= new int[scores.length+1];
        int[] ranks = new int[alice.length];

        for(int i=0;i<alice.length;i++)
        {            
			// Adding scores to new array on each iteration of alice
			/*for(int j=0;j<scores.length;j++)
			{
				newScores[j]=scores[j];
			}*/
        	newScores = Arrays.copyOf(scores, scores.length+1);
            // Adding alice score in the end of array
            newScores[newScores.length-1] = alice[i];

            Arrays.sort(newScores);

            //System.out.println(Arrays.toString(newScores));
            
            int previousElement = -1;
            int rank = 0;
            for(int k=newScores.length-1;k>=0;k--)
            {
                if(previousElement == -1 || previousElement != newScores[k])
                {
                    rank++;
                }
                
                if(newScores[k] == alice[i])
                    break;
                
                previousElement = newScores[k];
            }

            ranks[i]=rank;
        }    

        return ranks; 
    }
    
    // Third approach : Using binary search (best approach)
    static int[] climbingLeaderboard3(int[] scores, int[] alice) 
    {
    	int[] ranks = new int[alice.length];
    	int[] newScores= new int[scores.length+1];
    	newScores = Arrays.copyOf(scores, scores.length+1);
    	for(int i=0;i<alice.length;i++)
        {  
    		newScores[newScores.length-1] = alice[i];	// Adding alice score in the end of array
    		Arrays.sort(newScores);
        }

    	return ranks; 
    }
    
    static int binarySearch(int[] arr, int element)
    {
    	int rank = 0;
    	
    	int startIndex = 0;
		int endIndex = arr.length-1;

		while(startIndex <= endIndex)
		{
			// This is the main logic
			System.out.println("startIndex: "+startIndex + " | endIndex: "+ endIndex + " | (endIndex - startIndex)/2: "+ (endIndex - startIndex)/2);
			int middleIndex = startIndex + (endIndex - startIndex)/2;
			System.out.println("middleIndex: "+middleIndex);
			
			
			if(element == arr[middleIndex])
			{
				return middleIndex;
			}
			
			if(element < arr[middleIndex])
			{
				endIndex = middleIndex - 1;
			}
			else
			{
				startIndex = middleIndex + 1;
			}
		}
		
    	return rank;
    }
}
