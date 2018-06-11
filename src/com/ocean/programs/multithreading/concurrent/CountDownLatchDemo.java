package com.ocean.programs.multithreading.concurrent;

import java.util.concurrent.CountDownLatch;

/** CountDownLatch enables a java thread to wait until other set of threads completes their tasks,
 * e.g. Applications' main thread wants to wait, till other service threads which are responsible for
 * starting framework services have completed started all services. 
 * 
 * CountDownLatch works by having a counter initialized with number of threads, which is decremented each
 * time a thread complete its execution. When count reaches to zero, it means all threads have completed
 * their execution, and the thread waiting on latch resume the execution.
 * 
 * new CountDownLatch(int count) {}
 * 
 * This count is the number of threads, for which latch should wait. This value can be set only once, and
 * CountDownLatch provides no other mechanism to reset this count.
 * 
 * The first interaction with CountDownLatch is with main thread which is going to wait for other threads.
 * This main thread must call, await() method immediately after starting other threads. The execution will stop on 
 * await() method till the time, other threads complete their execution.
 * 
 * Other N threads must have reference of latch object, because they will need to notify the CountDownLatch 
 * object that they have completed their task. This notification is done by method : countDown(); 
 * Each invocation of method decreases the initial count set in constructor, by 1. So, when all N threads have 
 * call this method, count reaches to zero, and main thread is allowed to resume its execution past await() method.**/
public class CountDownLatchDemo 
{
	public static void main(String[] args) 
	{
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		
		System.out.println(countDownLatch.getCount());
		System.out.println("Thread: "+Thread.currentThread().getName()+" started execution");
		
		Thread thread1 = new Thread(new MyThread("CacheServiceThread", 1000, countDownLatch));
		Thread thread2 = new Thread(new MyThread("AlertServiceThread", 1000,countDownLatch));
		Thread thread3 = new Thread(new MyThread("ValidationService", 1000, countDownLatch));
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try
		{
			countDownLatch.await();
			Thread.sleep(1000);
			System.out.println("Thread: "+Thread.currentThread().getName()+" finished");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class MyThread implements Runnable
{
	private String name;
	private int sleepTime;
	private CountDownLatch countDownLatch;
	
	public MyThread(String name, int sleepTime, CountDownLatch countDownLatch) 
	{
		this.name = name;
		this.sleepTime = sleepTime;
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() 
	{
		try
		{
			Thread.sleep(sleepTime);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		countDownLatch.countDown();		// Generally this must be the last statement in this run() method
		System.out.println(countDownLatch.getCount());
		System.out.println("Thread: "+name+" finished");
	}
}