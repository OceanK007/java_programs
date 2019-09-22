package com.ocean.programs.multithreading.concurrent;

import java.util.concurrent.BlockingQueue;

/** java.util.concurrent.BlockingQueue is a java java.util.Queue that support operations that 
 * wait for the queue to become non-empty when retrieving and removing an element, and 
 * wait for space to become available in the queue when adding an element.
 * 
 * Java BlockingQueue doesn’t accept null values and throw NullPointerException 
 * if you try to store null value in the queue.
 * 
 * Java BlockingQueue implementations are thread-safe. All queuing methods are atomic in 
 * nature and use internal locks or other forms of concurrency control.
 * 
 * Java BlockingQueue interface is part of java collections framework and it’s primarily used 
 * for implementing producer consumer problem. We don’t need to worry about waiting for the space 
 * to be available for producer or object to be available for consumer in BlockingQueue because 
 * it’s handled by implementation classes of BlockingQueue.
 * 
 * Java provides several BlockingQueue implementations such as 
 * ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue etc.**/
public class BlockingQueueDemo 
{
	
}
