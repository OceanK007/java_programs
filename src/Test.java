import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test implements Serializable
{
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/text.txt"));
		Parent vv=	new TestChild();
		oos.writeObject(vv);
		
		System.out.println(vv.i);
		
		
		FileInputStream fis = new FileInputStream("D:/text.txt");
		ObjectInputStream obs = new ObjectInputStream(fis);
		
		Parent tc = (TestChild) obs.readObject();
		
		System.out.println(tc.i+" hshcode"+tc.hashCode());
	}
}

class TestChild extends Parent 
{
	Integer i = 5;
	public TestChild() 
	{
		System.out.println("TestChild");
	}
	
}

class Parent implements Serializable
{
	Integer i ;
	Parent()
	{
		i=10;
		System.out.println("parent");
	}
	
}