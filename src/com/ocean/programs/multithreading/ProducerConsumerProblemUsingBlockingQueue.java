package com.ocean.programs.multithreading;

import java.util.concurrent.*;

/**
In computing, the producer–consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. 
The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue. 
Here the consumer is trying to consume while producer has not produced yet or it can be like producer is continuously producing but consumer has not started consuming yet.

* The producer’s job is to generate data, put it into the buffer, and start again.
* At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.

Problem:
To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer
**/
public class ProducerConsumerProblemUsingBlockingQueue 
{
	public static void main(String[] args) throws InterruptedException 
	{
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
		//ProducerConsumer2 producerConsumer = new ProducerConsumer2(blockingQueue);
		
		Thread producer = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					for(int i=1;i<=10;i++)
					{
						blockingQueue.put(i);	
						System.out.println("Produced: "+blockingQueue);
			            Thread.sleep(1000);			            
					}
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					for(int i=1;i<=10;i++)
					{						
			            Thread.sleep(1000);
			            System.out.println("Consumed: "+blockingQueue.take());
					}
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		// Both producer and consumer threads have started
		producer.start();
		consumer.start();
		
		// producer finishes before consumer
		producer.join();	// main thread will stop its execution until producer thread completes its execution.
		// Note that since producer thread using wait() and notify() methods inside produce() method and invoking consumer thread as well using notify().
		System.out.println("Main1");
		consumer.join();
		System.out.println("Main2");
	}
}