package com.ocean.programs.string;

import java.util.Scanner;

/**
Sample Input
saveChangesInTheEditor

Sample Output
5

Explanation
String  contains five words:
save
Changes
In
The
Editor
Thus, we print 5 on a new line.

**/
public class HR_CamelCase 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
    
	static int camelcase(String s) 
	{
        int count = 1;
        
        for(int i=0;i<s.length();i++)
        {
            String real = String.valueOf(s.charAt(i));
            String upper = String.valueOf(s.charAt(i)).toUpperCase();
            if(real.equals(upper))
            {
                count+=1;
            }
        }
        
        return count;
    }
}
