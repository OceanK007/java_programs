public class Test 
{
	public static void main(String[] args) 
	{
		int i = newAscii(121,5);
		
		System.out.println(i);
	}
	
	public static int newAscii(int source, int increment)
    {
        if(source >= 97 && source <=122)
        {
            for(int i=1;i<=increment;i++)
            {   
                if((source+1) > 122)
                {
                    source = 97;
                }
                else
                {
                    source = source + 1;
                }
            }
        }
        if(source >= 65 && source <=90)
        {
            for(int i=1;i<=increment;i++)
            {   
                if((source+1) > 90)
                {
                    source = 65;
                }
                else
                {
                    source = source + 1;
                }
            }
        }
        
        return source;
    }
}