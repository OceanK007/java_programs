package com.ocean.programs.algorithm.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
Brie’s Drawing teacher asks her class to open their books to a page number. 
Brie can either start turning pages from the front of the book or from the back of the book. 
She always turns pages one at a time. When she opens the book, page 1 is always on the right side:

When she flips page 1, she sees pages 2 and 3. Each page except the last page will always be printed on both sides. 
The last page may only be printed on the front, given the length of the book. If the book is  pages long, and she wants to turn to page p, 
what is the minimum number of pages she will turn? She can start at the beginning or the end of the book.

Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page p.

Function Description:
Complete the pageCount function in the editor below. It should return the minimum number of pages Brie must turn.
pageCount has the following parameter(s):
n: the number of pages in the book
p: the page number to turn to

Input Format
The first line contains an integer n, the number of pages in the book.
The second line contains an integer p, the page that Brie's teacher wants her to turn to.
 
INPUT:
5
4
OUTPUT:
0

INPUT:
6
5
OUTPUT:
1

INPUT:
6
2
OUTPUT:
1
 */
public class HR_DrawingBook 
{
    static int pageCount(int n, int p) 
    {
    	int frontTurns = 0;
    	int backTurns = 0;

    	frontTurns = p%2 == 0 ? p/2 : (p-1)/2;
    	backTurns = (n-p)%2 == 0 ? (n-p)/2 : ((n%2==0) ? (n-p+1)/2 : (n-p-1)/2);
    	
    	System.out.println(frontTurns);
    	System.out.println(backTurns);
    	
    	if(frontTurns < backTurns)
    		return frontTurns;
    	else
    		return backTurns;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();

        int p = scanner.nextInt();

        pageCount(n, p);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
