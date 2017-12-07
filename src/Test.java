import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int games = in.nextInt();
        
        for(int a0 = 0; a0 < games; a0++)
        {
            int size = in.nextInt();
            int max = 0;
            int counter = 0;
            for(int i=0;i<size;i++)
            {
            	int element = in.nextInt();
            	
            	if(element > max)
            	{
            		max = in.nextInt();
            		counter += 1;
            	}
            }
        }
	}
}
