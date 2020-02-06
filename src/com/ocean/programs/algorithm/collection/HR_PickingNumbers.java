package com.ocean.programs.algorithm.collection;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/** MEDIUM **/

/**
Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference 
between any two of the chosen integers is less than or equal to 1. 
For example, if your array is a=[1,1,2,2,4,4,5,5,5], you can create two subarrays meeting the criterion: [1,1,2,2] and [4,4,5,5]. The maximum length subarray has 5 elements.

Function Description
Complete the pickingNumbers function in the editor below. It should return an integer that represents the length of the longest array that can be created.
pickingNumbers has the following parameter(s):
a: an array of integers

Input Format
The first line contains a single integer n, the size of the array a.
The second line contains n space-separated integers a[i].

Output Format
A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is <=1.

Sample Input 0
6
4 6 5 3 3 1
Sample Output 0
3
Explanation 0
We choose the following multiset of integers from the array: {4,3,3}. Each pair in the multiset has an absolute difference <=1 (i.e., |4-3|=1 and |3-3|=0), so we print the number of chosen integers, 3, as our answer.

Sample Input 1
6
1 2 2 3 1 2
Sample Output 1
5
Explanation 1
We choose the following multiset of integers from the array: {1,2,2,1,2}. Each pair in the multiset has an absolute difference <=1 (i.e., |1-2|=1, |1-1|=0, and |2-2|=0), so we print the number of chosen integers, 5, as our answer.

Sample Input 2
73
4 2 3 4 4 9 98 98 3 3 3 4 2 98 1 98 98 1 1 4 98 2 98 3 9 9 3 1 4 1 98 9 9 2 9 4 2 2 9 98 4 98 1 3 4 9 1 98 98 4 2 3 98 98 1 99 9 98 98 3 98 98 4 98 2 98 4 2 1 1 9 2 4
Sample Output 2
22
**/
public class HR_PickingNumbers 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.println(Result.pickingNumbers2(a));

        bufferedReader.close();
    }
}

class Result 
{
	// Way 1:
    public static int pickingNumbers(List<Integer> a) 
    {
        int maxLength = 0;
        int prevNumberLength = 1;
        int nextNumberLength = 1;
        int prevNumber = 0;
        int nextNumber = 0;

        for(int i=0;i<a.size();i++)
        {
        	prevNumberLength = 1;
        	nextNumberLength = 1;
            prevNumber = 0;
            nextNumber = 0;
            for(int j=i+1;j<a.size();j++)
            {
            	if(a.get(j) > a.get(i))
            	{
            		if(a.get(j)-a.get(i) == 1)
            		{
            			if(prevNumber == 0)
            			{
            				prevNumber = a.get(j);
            			}
            			
            			if(prevNumber != 0 && a.get(j) == prevNumber)
                    	{
            				prevNumberLength++;
                    	}
            		}
            	}
            	else if(a.get(j) < a.get(i))
            	{
            		if(a.get(i)-a.get(j) == 1)
            		{
            			if(nextNumber == 0)
            			{
            				nextNumber = a.get(j);
            			}
            			
            			if(nextNumber != 0 && a.get(j) == nextNumber)
                    	{
            				nextNumberLength++;
                    	}
            		}
            	}
            	else
            	{
            		prevNumberLength++;
            		nextNumberLength++;
            	}
            }
            
            //System.out.println("prevNumberLength: "+prevNumberLength);
            //System.out.println("nextNumberLength: "+nextNumberLength);
            if(Math.max(prevNumberLength, nextNumberLength) > maxLength)
                maxLength = Math.max(prevNumberLength, nextNumberLength);
        }

        return maxLength;
    }

    // Way 2: 
    public static int pickingNumbers2(List<Integer> a) 
    {
    	Collections.sort(a);
        int maxLength = 0;
        int length = 1;
        int consecutiveNumber = 0;

        for(int i=0;i<a.size();i++)
        {
            length = 1;
            consecutiveNumber = 0;
            for(int j=i+1;j<a.size();j++)
            {
            	if(consecutiveNumber == 0 && Math.abs(a.get(i)-a.get(j)) == 1)
            	{
            		consecutiveNumber = a.get(j);
            	}
            	
            	if((consecutiveNumber != 0 && a.get(j) == consecutiveNumber) || (a.get(i) == a.get(j)))
            	{
            		length++;
            	}
            }

            //System.out.println("Length: "+length);
            if(length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }
}