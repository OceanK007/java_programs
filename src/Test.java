import java.math.BigInteger;

class Test 
{
	public static void main(String[] args) 
	{
		// BigInteger is immutable
		BigInteger bi = BigInteger.valueOf(2);
		bi = bi.multiply(BigInteger.valueOf(3));		
		System.out.println(bi); // 6
		
		BigInteger bi2 = BigInteger.valueOf(2);
		bi2 = bi2.add(BigInteger.valueOf(3));
		System.out.println(bi2); // 5
	}
}
