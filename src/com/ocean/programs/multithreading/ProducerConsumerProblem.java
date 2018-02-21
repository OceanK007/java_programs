package com.ocean.programs.multithreading;

import java.util.LinkedList;

/**
In computing, the producer–consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. 
The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue. 
Here the consumer is trying to consume while producer has not produced yet or it can be like producer is continuously producing but consumer has not started consuming yet.

* The producer’s job is to generate data, put it into the buffer, and start again.
* At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.

Problem:
To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer
**/
public class ProducerConsumerProblem 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ProducerConsumer producerConsumer = new ProducerConsumer();
		
		Thread producer = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					producerConsumer.produce();
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
					producerConsumer.consume();
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

class ProducerConsumer
{
	LinkedList<Integer> items = new LinkedList<Integer>();
	Integer initialCapacity = 2;
	
	public synchronized void produce() throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			if(items.size() == initialCapacity)
				wait();	// Once wait will be ended, then it will continue execution of next statements 
			
			items.add(i);
			
			System.out.println("Producer produced: "+i);
			
			// notifies the consumer thread that now it can start consuming
			notify();
		}
	}
	
	public synchronized void consume() throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			if(items.size()==0)
				wait();	// Once wait will be ended, then it will continue execution of next statements 
			
			Integer item = items.removeFirst();
			
			System.out.println("Consumer consumed: "+item);
			
			// Wake up producer thread
			notify();
		}
	}
}

// Output:
/**
Producer produced: 0
Producer produced: 1
Consumer consumed: 0
Consumer consumed: 1
Producer produced: 2
Producer produced: 3
Consumer consumed: 2
Consumer consumed: 3
Producer produced: 4
Producer produced: 5
Consumer consumed: 4
Consumer consumed: 5
Producer produced: 6
Producer produced: 7
Consumer consumed: 6
Consumer consumed: 7
Producer produced: 8
Producer produced: 9
Consumer consumed: 8
Consumer consumed: 9
Main1
Main2
**/
/**
Producer produced: 0
Producer produced: 1
Consumer consumed: 0
Consumer consumed: 1
Producer produced: 2
Producer produced: 3
Consumer consumed: 2
Consumer consumed: 3
Producer produced: 4
Producer produced: 5
Consumer consumed: 4
Consumer consumed: 5
Producer produced: 6
Producer produced: 7
Consumer consumed: 6
Consumer consumed: 7
Producer produced: 8
Producer produced: 9
Consumer consumed: 8
Main1
Consumer consumed: 9
Main2
**/
