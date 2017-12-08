import java.util.Scanner;

public class Test 
{
	 	static String timeConversion(String s) 
	 	{
	        String[] stringArray = s.split(":");
	        int hour = Integer.valueOf(stringArray[0]);
	       if(s.contains("AM"))
	       {
	           if(hour == 12)
	           {
	               hour = 0;
	           }
	       }
	       if(s.contains("PM"))
	       {
	           if(hour != 12)
	               hour = 12 + hour;
	       }
	        
	        String result = String.format("%02d", hour)+":"+stringArray[1]+":"+(stringArray[2].substring(0, 2));
	        return result;
	    }

	    public static void main(String[] args) 
	    {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        String result = timeConversion(s);
	        System.out.println(result);
	    }
}