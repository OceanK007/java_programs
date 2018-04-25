package com.ocean.programs.multithreading.concurrent;

import java.util.concurrent.CyclicBarrier;

/** A CyclicBarrier is a synchronizer that allows a set of threads to wait for each other to reach a common 
 * execution point, also called a barrier. 
 * 
 * CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for each 
 * other to reach a common point before continuing execution.
 * 
 * The barrier is called cyclic because it can be re-used after the waiting threads are released using reset() method.
 * 
 * After completing its execution, threads call await() method and wait for other threads to reach the barrier. 
 * Once all the threads have reached, the barriers then give the way for threads to proceed.
 * 
 * CyclicBarrier is used to make threads wait for each other. It is used when different threads process a 
 * part of computation and when all threads have completed the execution, the result needs to be combined 
 * in the parent thread. In other words, a CyclicBarrier is used when multiple thread carry out different 
 * sub tasks and the output of these sub tasks need to be combined to form the final output.**/
public class CyclicBarrierDemo 
{
	public static void main(String[] args) 
	{
		// 4 threads are part of this barrier: CacheServiceThread, AlertServiceThread, ValidationService, main
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		
		System.out.println("Thread: "+Thread.currentThread().getName()+" started execution");
		
		Thread thread1 = new Thread(new MyThread2("CacheServiceThread", 1000, cyclicBarrier));
		Thread thread2 = new Thread(new MyThread2("AlertServiceThread", 1000,cyclicBarrier));
		Thread thread3 = new Thread(new MyThread2("ValidationService", 1000, cyclicBarrier));
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try
		{
			cyclicBarrier.await();
			System.out.println("Thread: "+Thread.currentThread().getName()+" finished");

			// Resetting the cyclicBarrier
			// cyclicBarrier.reset(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class MyThread2 implements Runnable
{
	private String name;
	private int sleepTime;
	private CyclicBarrier cyclicBarrier;
	
	public MyThread2(String name, int sleepTime, CyclicBarrier cyclicBarrier) 
	{
		this.name = name;
		this.sleepTime = sleepTime;
		this.cyclicBarrier = cyclicBarrier;
	}
	
	@Override
	public void run() 
	{
		System.out.println("Starting service: "+this.name);
		try
		{
			Thread.sleep(sleepTime);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("Service: "+this.name+" finished, now waiting for other services to complete");
		
		try
		{
			cyclicBarrier.await();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}