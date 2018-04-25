package com.ocean.programs.multithreading.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceRunnable 
{
	public static void main(String[] args) 
	{
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		List<Future<?>> futureList = new ArrayList<>();
		
		ThreadOne t1 = new ThreadOne();
		ThreadOne t2 = new ThreadOne();
		
		Future<?> future = executorService.submit(t1);
		futureList.add(future);
		
		Future<?> future2 = executorService.submit(t2);
		futureList.add(future2);
		
		for(Future<?> fut : futureList)
		{
			try
			{
				// get(): 
				/** Attempts to cancel execution of this task. This attempt will fail if the task has already completed, has already been cancelled, 
				* or could not be cancelled for some other reason. If successful, and this task has not started when cancel is called, this task should never run. 
				* If the task has already started, then the mayInterruptIfRunning parameter determines whether the thread executing this task should be 
				* interrupted in an attempt to stop the task. After this method returns, subsequent calls to isDone will always return true. 
				* Subsequent calls to isCancelled will always return true if this method returned true. System.out.println(fut.cancel(true)); **/
				
				// Waits if necessary for the computation to complete, and then retrieves its result.
				System.out.println(fut.get());
				
				// get(1000, TimeUnit.MILLISECONDS):
				/** Waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if available.
				* Here, we can specify the time to wait for the result, it’s useful to avoid current thread getting blocked for longer time. **/ 
				// System.out.println(fut.get(1000, TimeUnit.MILLISECONDS));
				
				// isDone():
				/** Returns true if this task completed. 
				* Completion may be due to normal termination, an exception, or cancellation -- in all of these cases, this method will return true **/
				// System.out.println(fut.isDone());
	
				// isCancelled(): 
				/** Returns true if this task was cancelled before it completed normally. **/
				// System.out.println(fut.isCancelled());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		executorService.shutdown();
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
