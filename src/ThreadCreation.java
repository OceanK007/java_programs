public class ThreadCreation
{
	public static void main(String[] args) 
	{
		Thread thread1 = new Thread() 
		{
			@Override
			public void run() 
			{
				System.out.println("Current Thread Name: "+Thread.currentThread().getName());
			}
		};
		thread1.start();
		
		Thread thread2 = new Thread() 
		{
			@Override
			public void run() 
			{
				System.out.println("Current Thread Name: "+Thread.currentThread().getName());
			}
		};
		thread2.start();
	}
}