package com.ocean.programs.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample 
{
	volatile static Future<?> threadOneFuture = null;
	volatile static Future<?> threadTwoFuture = null;
	
	public static void main(String[] args) 
	{
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		ThreadOne t1 = new ThreadOne();
		ThreadOne t2 = new ThreadOne();
		
		threadOneFuture = executorService.submit(t1);
		threadTwoFuture = executorService.submit(t2);
		
		System.out.println(threadOneFuture.isDone());
		System.out.println(threadTwoFuture.isDone());
	}
}

class ThreadOne implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println("Thread one executing: "+Thread.currentThread().getName());
	}
}
