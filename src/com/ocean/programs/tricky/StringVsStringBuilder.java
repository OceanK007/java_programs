package com.ocean.programs.tricky;

public class StringVsStringBuilder 
{
	public static void main(String[] args) 
	{
		// Here we are concatenating old string with new string to get string and assigning it to reference variable 
		// so we are assigning 99 new strings to reference variable.
		String str1 = "";
		for(int i = 0; i< 100; i++)
		{
			str1 = str1 +  i;
		}

		// In this case use StringBuilder instead of String, because it’s must faster and consumes less memory
		StringBuilder sb = new StringBuilder(1000);
		for(int i = 0; i< 100; i++)
		{
			sb.append(i).toString();
		}
	}
}
