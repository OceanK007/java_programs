import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test 
{
	public static void main(String args[] ) throws Exception 
	{
		//Scanner
        Scanner s = new Scanner(System.in);
        int sticks = s.nextInt();                 // Reading input from STDIN
        
        int x[] = new int[sticks];
        int y[] = new int[sticks];
       
        for(int i=0;i<sticks;i++)
        {
        	x[i]= s.nextInt();
        	y[i]= s.nextInt();
        }
        
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
     
        for(int i=0;i<y.length;i++)
        {
        	for(int j=0;j<y.length-i;j++)
			{
				if((j+1 <y.length) && y[j] > y[j+1])
				{
					int temp = y[j];
					y[j] = y[j+1];
					y[j+1] = temp;
					
					int temp2 = x[j];
					x[j] = x[j+1];
					x[j+1] = temp2;
				}
			}
        }
        
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        double d1= Math.sqrt(Math.pow((y[sticks-1]-y[0]),2)+ Math.pow((x[sticks-1]-x[0]),2));
      
        for(int j=1;j<y.length;j++)
        {
        	int x2= x[j];
        	int x1= x[j-1];
        	int y2= y[j];
        	int y1= y[j-1];
        	
        	double d= Math.sqrt(Math.pow((y2-y1),2)+ Math.pow((x2-x1),2));
        	d1=d1+d;
        	System.out.println(d1);
        }
        
    }
}
