package com.ocean.programs.logical;

import java.util.*;

//Find the best average grade.
//Given a list of student test scores
//Each student may have more than one test score in the list.

public class SAP_BestAverageGrade 
{
	public static void main(String[] args)
	{
	    if(pass())
	    {
	      System.out.println("Pass");
	    }
	    else
	    {
	      System.out.println("Some Fail");
	    }
	}
	
	public static boolean pass()
	{
	    String[][] s1 = { { "Rohan", "84" },
	               { "Sachin", "102" },
	               { "Ishan", "55" },
	               { "Sachin", "18" } };

	    return bestAvgGrade(s1) == 84;
	}

	public static Integer bestAvgGrade(String[][] scores)
	{
	    Map<String, List<Integer>> map = new HashMap();
	    
	    for(int i=0;i<scores.length;i++)
	    {
	    	String[] scoreCard = scores[i];
	    	String name = scoreCard[0];
	    	int mark = Integer.parseInt(scoreCard[1]);
	    	List<Integer> marks = null;
	    	
	    	if(map.containsKey(name))
	    	{
	    		marks = map.get(name);
	    		marks.add(mark);
	    		map.put(name, marks);
	    	}
	    	else
	    	{
	    		marks = new ArrayList<>();
	    		marks.add(mark);
	    		map.put(name, marks);
	    	}
	    			
	    }
	    
	    //System.out.println(map);
	    
	    
	    String bestStudentName = "";
	    int avg = 0;
	    
	    for(Map.Entry<String, List<Integer>> entrySet : map.entrySet())
	    {
	    	int avgScore = 0;
	    	int totalMarks = 0;
	    	List<Integer> marks = entrySet.getValue();
	    	for(int i=0;i<marks.size();i++)
	    	{
	    		totalMarks = totalMarks + marks.get(i);
	    	}
	    	
	    	avgScore = totalMarks/marks.size();
	    	
	    	if(avgScore > avg)
	    	{
	    		bestStudentName = entrySet.getKey();
	    		avg = avgScore;
	    	}
	    }
	    
	    return avg;
	}
}
