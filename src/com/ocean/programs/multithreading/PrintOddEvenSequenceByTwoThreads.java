package com.ocean.programs.multithreading;

import java.util.LinkedList;

/**
Thread1 = will print odd numbers
Thread2 = will print event numbers

SampleOutput: 
1,2,3,4......100
**/
public class PrintOddEvenSequenceByTwoThreads 
{
	public static void main(String[] args) throws InterruptedException 
	{
		PrintOddAndEven printOddAndEven = new PrintOddAndEven(100);
		
		Thread oddThread = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					printOddAndEven.printOdd();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		Thread evenThread = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					printOddAndEven.printEven();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		oddThread.start();
		evenThread.start();
		
		oddThread.join();
		evenThread.join();
		
		System.out.println(printOddAndEven.numbers);
	}
}

class PrintOddAndEven
{
	int size = 0;
	volatile LinkedList<Integer> numbers = new LinkedList<Integer>();
	int counter = 1;
	boolean isOddTurn = true;
	
	PrintOddAndEven(Integer size)
	{
		this.size = size;
	}
	
	public synchronized void printEven() throws InterruptedException
	{
		for(int i=0;i>=0;i++)
		{
			if(numbers.size() >= size)
				break;
			
			if(isOddTurn == true)
				wait();
			
			if(numbers.size() < size)
				numbers.add(counter);
			
			counter++;
			isOddTurn = true;
			
			notify();
		}
	}
	
	public synchronized void printOdd() throws InterruptedException
	{
		for(int i=0;i>=0;i++)
		{
			if(numbers.size() >= size)
				break;
			
			if(isOddTurn == false)
				wait();
			
			if(numbers.size() < size)
				numbers.add(counter);
			
			counter++;
			isOddTurn = false;
			
			notify();
		}
	}
}
