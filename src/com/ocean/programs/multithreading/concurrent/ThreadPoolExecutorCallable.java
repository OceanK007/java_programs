package com.ocean.programs.multithreading.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPoolExecutorCallable 
{
	public static void main(String[] args)
	{
		// ThreadPoolExecutor:
		/** An ExecutorService that executes each submitted task using one of possibly several pooled threads, 
		* normally configured using Executors factory methods. (It extends AbstractExecutorService which extends ExecutorService) 

		* To be useful across a wide range of contexts, this class provides many adjustable parameters and extensibility hooks. 
		* However, programmers are urged to use the more convenient Executors factory methods 
		* Executors.newCachedThreadPool (unbounded thread pool, with automatic thread reclamation), 
		* Executors.newFixedThreadPool (fixed size thread pool) and 
		* Executors.newSingleThreadExecutor (single background thread), 
		* that preconfigure settings for the most common usage scenarios. **/
		
		// newFixedThreadPool():
		/** Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue. 
		* At any point, at most nThreads threads will be active processing tasks. If additional tasks are submitted 
		* when all threads are active, they will wait in the queue until a thread is available. If any thread terminates 
		* due to a failure during execution prior to shutdown, a new one will take its place if needed to execute 
		* subsequent tasks.The threads in the pool will exist until it is explicitly shutdown. **/
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		// OR // ExecutorService executorService = Executors.newFixedThreadPool(1);
		List<Future<String>> futureList = new ArrayList<>();
		
		Callable<String> callable = new Thread2();
		Callable<String> callable2 = new Thread2();
		Callable<String> callable3 = new Thread2();
		
		// Future:
		/** A Future represents the result of an asynchronous computation. Methods are provided to check if the 
		* computation is complete, to wait for its completion, and to retrieve the result of the computation. 
		* The result can only be retrieved using method get when the computation has completed, blocking if 
		* necessary until it is ready. Cancellation is performed by the cancel method. Additional methods are 
		* provided to determine if the task completed normally or was cancelled. Once a computation has completed, 
		* the computation cannot be cancelled. If you would like to use a Future for the sake of cancellability 
		* but not provide a usable result, you can declare types of the form Future<?> and return null as a 
		* result of the underlying task. **/
		
		// submit():
		/** Submits a value-returning task for execution and returns a Future representing the pending results of the task. 
		* The Future's get method will return the task's result upon successful completion. 
		* If you would like to immediately block waiting for a task, you can use constructions of the form 
		* result = exec.submit(aCallable).get(); **/ 
		Future<String> future = threadPoolExecutor.submit(callable);
		futureList.add(future);
		
		Future<String> future2 = threadPoolExecutor.submit(callable2);
		futureList.add(future2);
		
		Future<String> future3 = threadPoolExecutor.submit(callable3);
		futureList.add(future3);
		
		System.out.println("futureList.size(): "+futureList.size()); 
		
		for(Future<String> fut : futureList)
		{
			try
			{
				// cancel(true)
				/** Attempts to cancel execution of this task. This attempt will fail if the task has already completed, 
  			    * has already been cancelled, or could not be cancelled for some other reason. If successful, and this 
  			    * task has not started when cancel is called, this task should never run. If the task has already started, 
  			    * then the mayInterruptIfRunning parameter determines whether the thread executing this task should be 
				* interrupted in an attempt to stop the task. After this method returns, subsequent calls to isDone will 
				* always return true.Subsequent calls to isCancelled will always return true if this method returned true.**/
				// System.out.println(fut.cancel(true));
				
				// get():
				// Waits if necessary for the computation to complete, and then retrieves its result.
				System.out.println(fut.get());
				
				// get(1000, TimeUnit.MILLISECONDS):
				/** Waits if necessary for at most the given time for the computation to complete, and then retrieves its 
				* result, if available.Here, we can specify the time to wait for the result, it’s useful to avoid current 
				* thread getting blocked for longer time. **/ 
				// System.out.println(fut.get(1000, TimeUnit.MILLISECONDS));
				
				// isDone():
				/** Returns true if this task completed. 
				* Completion may be due to normal termination, an exception, or cancellation -- in all of these cases, 
				* this method will return true **/
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
		
		threadPoolExecutor.shutdown();
	}
}

class Thread2 implements Callable<String>
{
	@Override
	public String call() throws Exception 
	{
		Thread.sleep(1000);
		// System.out.println("Inside call(): "+Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}
}

