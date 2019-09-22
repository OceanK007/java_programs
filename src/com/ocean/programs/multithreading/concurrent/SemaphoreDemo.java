package com.ocean.programs.multithreading.concurrent;

import java.util.concurrent.Semaphore;

/** A semaphore controls access to a shared resource through the use of a counter. 
 * If the counter is greater than zero, then access is allowed. If it is zero, then access is denied. 
 * What the counter is counting are permits that allow access to the shared resource. 
 * Thus, to access the resource, a thread must be granted a permit from the semaphore.
 * 
 * In general, to use a semaphore, the thread that wants access to the shared resource tries to acquire a permit.
 * 
 * If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the semaphore’s count to be decremented.
 * Otherwise, the thread will be blocked until a permit can be acquired.
 * When the thread no longer needs an access to the shared resource, it releases the permit, which causes the semaphore’s count to be incremented.
 * If there is another thread waiting for a permit, then that thread will acquire a permit at that time.
 * 
 * Using semaphore, we can prevent race condition
 * 
 * We can use a semaphore to lock access to a resource, each thread that wants to use that resource must first call acquire( ) 
 * before accessing the resource to acquire the lock. When the thread is done with the resource, it must call release( ) to release lock.
 * 
 * sem.acquire(); and sem.release(); is called critical section and we are locking the critical section. 
 * If critical section contains a shared variable, then it means we are locking that shared variable. That's how locking is applied on shared resource
 * **/
public class SemaphoreDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("Count: "+SharedResource.count);
		
		Semaphore semaphore = new Semaphore(1);
		
		// thread1 will increase counter value 
		// thread2 will decrease counter value
		MyThread1 thread1 = new MyThread1("A", semaphore);
		MyThread1 thread2 = new MyThread1("B", semaphore);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		// Count will always remain 0 after both threads will completes their execution
		System.out.println("Count: "+SharedResource.count);
	}
}

class SharedResource
{
	static int count = 0;
}

class MyThread1 extends Thread
{
	Semaphore semaphone;
	String threadName;
	
	public MyThread1(String threadName, Semaphore semaphore)
	{
		super(threadName);
		this.threadName = threadName;
		this.semaphone = semaphore;
	}
	
	@Override
	public void run() 
	{
		if(this.getName().equals("A"))
		{
			System.out.println("Starting thread: "+this.threadName);
			
			try
			{
				System.out.println("Thread: "+threadName + " is waiting for a permit");
				
				semaphone.acquire();
				
				System.out.println("Thread: "+threadName + " is gets a permit");
				
				for(int i=0;i<5;i++)
				{
					SharedResource.count++;
					System.out.println(threadName + ": "+SharedResource.count); 
					
					Thread.sleep(10);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			System.out.println("Thread: "+threadName + " releases the permit");
			semaphone.release();
		}
		else
		{
			System.out.println("Starting thread: "+this.threadName);
			
			try
			{
				System.out.println("Thread: "+threadName + " is waiting for a permit");
				
				semaphone.acquire();
				
				System.out.println("Thread: "+threadName + " is gets a permit");
				
				for(int i=0;i<5;i++)
				{
					SharedResource.count--;
					System.out.println(threadName + ": "+SharedResource.count); 
					
					Thread.sleep(10);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			System.out.println("Thread: "+threadName + " releases the permit");
			semaphone.release();
		}
	}
}
