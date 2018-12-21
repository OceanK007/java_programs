public class Test
{
	public static void main(String[] args) 
	{
		multiException();
	}
	
	public static void multiException()
	{
		try
		{
			throw new ArithmeticException();
		}
		catch(NullPointerException | ArithmeticException ex)
		{
			System.out.println(ex);
		}
	}
}