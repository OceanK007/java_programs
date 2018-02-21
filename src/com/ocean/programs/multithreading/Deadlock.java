package com.ocean.programs.multithreading;

public class Deadlock 
{
	public static void main(String[] args) throws InterruptedException 
	{
		CommonResource commonResource1 = new CommonResource();
		CommonResource commonResource2 = new CommonResource();
		
		Thread thread1 = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					commonResource1.test1(commonResource2);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					commonResource2.test2(commonResource1);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}

class CommonResource
{
	public synchronized void test1(CommonResource cr) throws InterruptedException
	{
		System.out.println("Called test1() by thread: "+Thread.currentThread().getName());
		cr.test2(cr);	// thread1 Calling test2() of cr object which is currently in use by thread2
		System.out.println("Execution complete of test1() by thread: "+Thread.currentThread().getName());
	}
	
	public synchronized void test2(CommonResource cr) throws InterruptedException
	{
		System.out.println("Called test2() by thread: "+Thread.currentThread().getName());
		cr.test1(cr);	// thread2 Calling test1() of cr object which is currently in use by thread1
		System.out.println("Execution complete of test2() by thread: "+Thread.currentThread().getName());
	}
}