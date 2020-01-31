package com.ocean.programs.algorithm.string;

/**
 * Pangram Finder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter of english alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing.
 *
 */
class SAP_PangramMissingLettersFinder 
{
	  public static void main(String[] args) 
	  {
		  PangramMissingLettterDetector pd = new PangramMissingLettterDetector();
		  boolean success = true;
		
		  success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		  success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));
		  success = success && "abdfghijklmopqruvwxyz".equals(pd.findMissingLetters("sentence"));
		
		  if (success) 
		  {
			  System.out.println("Pass ");
		  } 
		  else 
		  {
			  System.out.println("Failed");
		  }
	  }
	  
	  private static class PangramMissingLettterDetector 
	  {
		  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
		
		  public String findMissingLetters(String sentence) 
		  {
			  StringBuilder missingLetters = new StringBuilder();
			  
			  char[] charArray = ALPHABET.toCharArray();
			  for(int i=0;i<charArray.length;i++)
			  {
				  if(sentence.indexOf(charArray[i]) == -1) 
				  {
					  missingLetters.append(charArray[i]);
				  }
			  }
			  
			  return missingLetters.toString();
		  }
	  }
}