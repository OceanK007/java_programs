import java.util.Scanner;

public class Test
{	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		while(count-- > 0)
		{
			//System.out.println(count);
			char c = scanner.next().charAt(0);
			System.out.println(c);
		}
	}
}