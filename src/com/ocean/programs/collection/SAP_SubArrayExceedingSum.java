package com.ocean.programs.collection;

public class SAP_SubArrayExceedingSum 
{
	public static void main(String[] args) 
	{
		 boolean result = true; 
		 int[] arr = { 1, 2, 3, 4 };
		 result = result && subArrayExceedsSum( arr, 6 ) == 2;
		 result = result && subArrayExceedsSum( arr, 12 ) == -1;
		
		 if( result )
		 {
		    System.out.println("All tests pass\n");
		 }
		 else
		 {
		    System.out.println("There are test failures\n");
		 }
	}
	
	public static int subArrayExceedsSum(int arr[], int target)
	{
		int count = -1;
		int sum = 0;
		int i = 0;
		int j = 0;
		
		while(true)
		{
			if(j == arr.length-1)
			{
				break;
			}
			
			sum = sum + arr[i];
			System.out.println("Sum: "+sum);
			if(sum > target)
			{
				count++;
				j++;
				i=j-1;
				sum = 0;
			}
			if(i==arr.length-1 && sum < target)
			{
				break;
			}
			i++;
		}

		System.out.println("count: "+count);
		return count;
	}
}
