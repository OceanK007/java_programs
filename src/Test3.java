
public class Test3 
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("try");
		}
		catch(Exception ex)
		{
			System.out.println("catch");
		}
		finally
		{
			throw new ArithmeticException();
			System.out.println("finally");
		}
	}
}
