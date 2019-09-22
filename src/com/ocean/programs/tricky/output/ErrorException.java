package com.ocean.programs.tricky.output;

public class ErrorException 
{
	public static void main(String args[] ) throws Exception 
	{
        try
        {
        	check(null);
        	System.out.println("try");
        }
        catch(Exception ex)
        {
        	System.out.println("catch");
        }
        finally
        {
        	System.out.println("final");
        }
    }
	public static void check(Object obj)
	{
		throw new Error();
	}
}

/** final
	Exception in thread "main" java.lang.Error
	at com.ocean.programs.tricky.output.ErrorException.check(ErrorException.java:23)
	at com.ocean.programs.tricky.output.ErrorException.main(ErrorException.java:9)**/
