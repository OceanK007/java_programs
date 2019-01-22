package com.ocean.programs.string;

/**
* Finds the first character that does not repeat anywhere in the input string
* Given "apple", the answer is "a"
* Given "racecars", the answer is "e"
**/        
public class SAP_FirstNonRepeatingLetter 
{
	public static void main(String[] args) 
	{
		String[] inputs = {"apple","racecars", "ababdc"};
	    char[] outputs = {'a', 'e', 'd' };

	    boolean result = true;
	    for(int i = 0; i < inputs.length; i++ )
	    {
		      result = result && findFirst(inputs[i]) == outputs[i];
		      if(!result)
		        System.out.println("Test failed for: " + inputs[i]);
		      else
		        System.out.println("Test passed for: " + inputs[i]);
	    }
	}
	
	 public static char findFirst(String input)
	 {
		char firstNonRepeatingChar = ' '; 
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);
			String subStr = input.substring(0, i)+input.substring(i+1);
			if(subStr.indexOf(c) == -1)
			{
				firstNonRepeatingChar = c;
				break;
			}
			//System.out.println(subStr);
		}
		return firstNonRepeatingChar;
	 }
}