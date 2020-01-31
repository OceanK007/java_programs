package com.ocean.programs.algorithm.string;

/**
	Find the maximum number of valid consecutive braces. A valid brace is ().   
	e.g.  
		()()()((((())()()()()() Count in this case is 5            
		()()((()()()(()) Count in this case is 3 3
**/
public class SAP_MaximumValidConsecutiveParenthesis 
{
	public static void main(String[] args) 
	{
		boolean result = true;
		result = result & (findMaxLen("((()()") == 2);
		result = result & (findMaxLen("()(()))))") == 1);
		result = result & (findMaxLen("()()()((((())()()()()()") == 5);
		result = result & (findMaxLen("()()((()()()(())") == 3);
		
		if(result)
		{
			System.out.println("All Passes");
		}
		else
		{
			System.out.println("Failed");
		}
	}
	
	static int findMaxLen(String str) 
    { 
    	int maxedLength = 0;
    	int count = 0;
    	int i = 0;
    	while(str.length() > 0)
    	{
    		//System.out.println(i);
    		if(((i+2) <= str.length()) && str.substring(i, i+2).equals("()"))
    		{
    			str = str.substring(i+2);
    			//System.out.println(str);
    			i = 0;
    			count++;
    			//System.out.println(count);
    			if(count > maxedLength)
    			{
    				maxedLength = count;
    			}
    		}
    		else
    		{
    			count = 0;
    			i++;
    			
    			if(i>str.length())
    			{
    				break;
    			}
    		}
    	}
    	//System.out.println("maxedLength: "+maxedLength);
        return maxedLength;
    } 
}
