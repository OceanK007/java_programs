package com.ocean.programs.algorithm;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/** EASY **/

/**
You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.

For example, given the arrays a=[2,6] and b=[24,36], there are two numbers between them: 6 and 12. 
6%2 = 0, 6%6 = 0, 24%6 = 0 and 36%6 = 0 for the first value. Similarly, 12%2 = 0, 12%6 = 0 and 24%12 = 0, 36%12 = 0.

Function Description

Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.

getTotalX has the following parameter(s):

a: an array of integers
b: an array of integers

Input Format:
The first line contains two space-separated integers, n and m, the number of elements in array a and the number of elements in array b.

The number of integers that are considered to be between a and b.

Sample Input:
2 3
2 4
16 32 96

Sample Output:
3

Explanation:
2 and 4 divide evenly into 4, 8, 12 and 16.
4, 8 and 16 divide evenly into 16, 32, 96.
4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.
**/

public class HR_BetweenTwoSets 
{
	public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        //bufferedWriter.write(String.valueOf(total));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

class Result 
{
    public static int getTotalX(List<Integer> a, List<Integer> b) 
    {   
        int maxValue = Integer.MIN_VALUE;
        Integer maxNumber1 = a.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        Integer maxNumber2 = b.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        if(maxNumber1 > maxNumber2)
            maxValue = maxNumber1;
        else
            maxValue = maxNumber2;

        //System.out.println("maxValue: "+maxValue);
        
        int count = 0;
        for(int i=1;i<=maxValue;i++)
        {
            boolean valid = false;
            for(int j=0;j<a.size();j++)
            {
                if(i%a.get(j) == 0)
                    valid = true;
                else
                    valid = false;
                
                if(valid == false)
                    break;
            }

            if(!valid)
                continue;

            for(int k=0;k<b.size();k++)
            {
                if(b.get(k)%i == 0)
                    valid = true;
                else
                    valid = false;
                
                if(valid == false)
                    break;
            }

            if(!valid)
                continue;

            if(valid)
            {
            	//System.out.println("i: "+i);
            	count += 1;
            }
        }

        return count;
    }
}
