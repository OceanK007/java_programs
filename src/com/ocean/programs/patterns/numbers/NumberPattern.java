package com.ocean.programs.patterns.numbers;

/** 
	Print the following pattern:
	
	1
	2 2
	3 3
	4 4
	3 3 
	2 2
	1
**/

public class NumberPattern 
{
	public static void main(String[] args) 
	{
		boolean countDown = false;
		boolean printDouble = false;
		
		int i = 1;
		while(true)
		{
			if(i == 0)
			{
				break;
			}
			
			if(printDouble == false)
			{
				System.out.println(i);
				printDouble = true;
			}
			else
			{
				if(i >= 4)
				{
					countDown = true;
				}
				
				if(countDown == true)
				{
					i--;
					if(i == 1)
					{
						printDouble = false;
					}
					else if(i > 0)
					{
						System.out.println(i+" "+i);
					}
				} 
				else 
				{
					if(printDouble == true)
					{
						i++;
						System.out.println(i+" "+i);
					}
				}
				
			}
		}
	}
}
