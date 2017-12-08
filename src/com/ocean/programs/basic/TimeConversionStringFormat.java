package com.ocean.programs.basic;

import java.util.Scanner;

/**
Input Format

A single string containing a time in -hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM)

Output Format

Convert and print the given time in 24-hour format, where 00 <= hh <= 23.

Sample Input

07:05:45PM
Sample Output

19:05:45

Sample Input

12:05:45PM
Sample Output

12:05:45
**/
public class TimeConversionStringFormat 
{
	static String timeConversion(String s) 
 	{
        String[] stringArray = s.split(":");
        int hour = Integer.valueOf(stringArray[0]);
       if(s.contains("AM"))
       {
           if(hour == 12)
           {
               hour = 0;
           }
       }
       if(s.contains("PM"))
       {
           if(hour != 12)
               hour = 12 + hour;
       }
        
        String result = String.format("%02d", hour)+":"+stringArray[1]+":"+(stringArray[2].substring(0, 2));
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
