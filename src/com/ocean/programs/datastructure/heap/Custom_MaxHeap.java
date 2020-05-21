package com.ocean.programs.datastructure.heap;

public class Custom_MaxHeap
{
	int size = 0;
	int[] arr = new int[20];
	
	public void insertNewValue(int val)
	{
		arr[size] = val;
		int index = size;	// Required for while loop
		int parentIndex = (index - 1)/2;	// Formula to get parent of an element
		
		while(parentIndex >= 0 && arr[parentIndex] < arr[index])
		{
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[index];
			arr[index] = temp;
			
			index = parentIndex;
			parentIndex = (index - 1)/2;
		}
		
		size++;
	}
	
	public int getMax()
	{
		return arr[0];
	}
	
	public int removeMax()
	{
		int maxValue = arr[0];
		arr[0] = arr[size - 1];		// swapping the last element with first element
		size = size - 1;			// element deleted so size will be reduced by 1
		maxHeapify(0); 				// Re-shuffle the elements starting from index 0
		return maxValue;
	}
	
	// Using recursion
	public void maxHeapify(int index)
	{
		int leftChildIndex = 2 * index + 1;			// Formula to get left child of a node
		int rightChildIndex = 2 * index + 2;		// Formula to get right child of a node
		
		int largestElementIndex = index;
		if(leftChildIndex < this.size && arr[leftChildIndex] > arr[largestElementIndex])
		{
			largestElementIndex = leftChildIndex;
		}
		
		if(rightChildIndex < this.size && arr[rightChildIndex] > arr[largestElementIndex])
		{
			largestElementIndex = rightChildIndex;
		}
		
		if(largestElementIndex != index)
		{
			int temp = arr[largestElementIndex];
			arr[largestElementIndex] = arr[index];
			arr[index] = temp;
			
			maxHeapify(largestElementIndex);
		}
	}
	
	// If you are given an array of elements and you want to max heapify them
	public void buildMaxHeap(int[] arr)
	{
		this.arr = arr;
		this.size = arr.length;
		
		int secondLastRowElementIndex = size/2 - 1;		// We need to find index of 2nd last row of tree (not the last row of tree)
		
		for(int i = secondLastRowElementIndex; i>=0; i--)
		{
			maxHeapify(i);
		}
	}
	
	public static void main(String[] args)
	{
		Custom_MaxHeap cmh = new Custom_MaxHeap();
		int[] arr = {10,7,11,30,20,38,2,45};
		
		// If you are given an array of elements and you want to max heapify them
		//cmh.buildMaxHeap(arr);
		//System.out.println(cmh.getMax());
		
		cmh.insertNewValue(arr[0]);
		cmh.insertNewValue(arr[1]);
		cmh.insertNewValue(arr[2]);
		System.out.println(cmh.getMax());
		
		cmh.insertNewValue(arr[3]);
		cmh.insertNewValue(arr[4]);
		System.out.println(cmh.getMax());
		
		cmh.insertNewValue(arr[5]);
		System.out.println(cmh.getMax());
		
		cmh.insertNewValue(arr[6]);
		cmh.insertNewValue(arr[7]);
		System.out.println(cmh.getMax());
		
		cmh.removeMax();
		System.out.println(cmh.getMax());
	}
}
