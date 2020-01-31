package com.ocean.programs.algorithm.implementation;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.

For example, assume your bird sightings are of types arr=[1,1,2,2,3]. There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.

Function Description

Complete the migratoryBirds function in the editor below. It should return the lowest type number of the most frequently sighted bird.

migratoryBirds has the following parameter(s):

arr: an array of integers representing types of birds sighted

Input Format
The first line contains an integer denoting n, the number of birds sighted and reported in the array arr.
The second line describes arr as n space-separated integers representing the type numbers of each bird sighted.

Constraints
It is guaranteed that each type is 1, 2, 3, 4, or 5.

Output Format
Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input 1
11
1 2 3 4 5 4 3 2 1 3 4

Sample Output 1
3

Sample Input 0
6
1 4 4 4 5 3

Sample Output 0
4
 */

public class HR_MigratoryBirds 
{
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) 
    {
        int one =0;
        int two =0;
        int three =0;
        int four = 0;
        int five = 0;

        int type = 1;
        int maxValue = 0;

        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==1)
                one++;
            else if(arr.get(i)==2)
                two++;
            else if(arr.get(i)==3)
                three++;
            else if(arr.get(i)==4)
                four++;
            else if(arr.get(i)==5)
                five++;    
        }
        
        System.out.println("One: "+one);
        System.out.println("Two: "+two);
        System.out.println("Three: "+three);
        System.out.println("Four: "+four);
        System.out.println("Five: "+five);

        maxValue = one;

        if(two>maxValue)
        {
            maxValue = two;
            type = 2;
        }
        if(three>maxValue)
        {    
            maxValue = three;
            type = 3;
        }
        if(four>maxValue)
        {    
            maxValue = four;
            type = 4;
        }
        if(five>maxValue)
        {    
            maxValue = five;
            type = 5;
        }

        System.out.println("type: "+type);
        return type;
    }

    public static void main(String[] args) throws IOException 
    {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

