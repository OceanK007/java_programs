package com.ocean.programs.string;

// Input two words returns the shortest distance between their two midpoints in number of characters
// Words can appear multiple times in any order and should be case insensitive.

// E.g. for the document="Example we just made up"
// shortestDistance( document, "we", "just" ) == 4

public class SAP_DistanceBetweenWords 
{   
	  private static final String document;
	  static
	  {
	    StringBuffer sb = new StringBuffer();
	    sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
	    sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
	    sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

	    document = sb.toString();
	  }
	  
	  public static boolean pass() 
	  {
	    return (
	    	shortestDistance(document, "and", "graphic") == 6d &&
	        shortestDistance(document, "transfer", "it") == 14d &&
	        shortestDistance(document, "Design", "filler" ) == 25d 
	    );
	  }
	  
	  public static void main(String[] args) 
	  {
	    if (pass()) 
	    {
	      System.out.println("Pass");
	    } 
	    else 
	    {
	      System.out.println("Some Fail");
	    }
	  }
	  
	  public static double shortestDistance(String document, String word1, String word2) 
	  {
	    String[] strArray = document.split(" ");
	    
	    int firstWordIndex = -1;
	    int secondWordIndex = -1;
	    int shortestDistance = Integer.MAX_VALUE;
	    
	    for(int i=0;i<strArray.length;i++)
	    {
	    	String s = strArray[i];
	    	if(s.contains(","))
	    	{
	    		s = s.substring(0, s.length()-1);
	    	}
	    	
	    	if(word1.equalsIgnoreCase(s))
	    	{
	    		firstWordIndex = i;
	    	}
	    	if(word2.equalsIgnoreCase(s))
	    	{
	    		secondWordIndex = i;
	    	}
	    	
	    	//System.out.println("firstWordIndex: "+firstWordIndex+" | secondWordIndex: "+secondWordIndex);
	    	if(firstWordIndex != -1 && secondWordIndex != -1)
	    	{
	    		StringBuilder sb = new StringBuilder();
	    		
	    		int loopStartIndex = 0;
	    		int loopEndIndex = 0;
	    		
	    		if(firstWordIndex < secondWordIndex)
	    		{
	    			loopStartIndex = firstWordIndex;
	    			loopEndIndex = secondWordIndex;
	    		}
	    		else if(firstWordIndex > secondWordIndex)
	    		{
	    			loopStartIndex = secondWordIndex;
	    			loopEndIndex = firstWordIndex;
	    		}
	    		
	    		
	    		for(int j=loopStartIndex;j<=loopEndIndex;j++)
	    		{
	    			if(j==firstWordIndex)
	    			{
	    				String halfString = strArray[j].substring(strArray[j].length()/2, strArray[j].length());
	    				sb.append(halfString).append(" ");
	    			}
	    			else if(j == secondWordIndex)
	    			{
	    				String halfString = strArray[j].substring(0, strArray[j].length()/2);
	    				sb.append(halfString).append(" ");
	    			}
	    			else
	    			{
	    				sb.append(strArray[j]).append(" ");
	    			}
	    		}
	    		
	    		String fullStringBetween = sb.toString().trim();
	    		//System.out.println(fullStringBetween);
	    			    		
	    		if(shortestDistance > fullStringBetween.length())
	    		{
	    			shortestDistance = fullStringBetween.length();
	    			//System.out.println(shortestDistance);
	    		}
	    	}
	    }	    

	    return shortestDistance;
	  }
}

