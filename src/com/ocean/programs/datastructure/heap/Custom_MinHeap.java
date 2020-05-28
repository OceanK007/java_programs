package com.ocean.programs.datastructure.heap;

//Heap properties: Element must be added as leaf node and root must be deleted always.
public class Custom_MinHeap
{
	int size = 0;
	int[] arr = new int[20];
	
	public void insertNewValue(int val)
	{
		arr[size] = val;
		int index = size;	// Required for while loop
		int parentIndex = (index - 1)/2;	// Formula to get parent of an element
		
		// Heap sort the added element
		while(parentIndex >= 0 && arr[parentIndex] > arr[index])
		{
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[index];
			arr[index] = temp;
			
			index = parentIndex;
			parentIndex = (index - 1)/2;
		}
		
		size++;
	}
	
	public int getMin()
	{
		return arr[0];
	}
	
	public int removeMin()
	{
		int maxValue = arr[0];
		arr[0] = arr[size - 1];		// swapping the last element with first element
		size = size - 1;			// element deleted so size will be reduced by 1
		minHeapify(0); 				// Re-shuffle the elements starting from index 0
		return maxValue;
	}
	
	// Using recursion
	public void minHeapify(int index)
	{
		int leftChildIndex = 2 * index + 1;			// Formula to get left child of a node
		int rightChildIndex = 2 * index + 2;		// Formula to get right child of a node
		
		int smallestElementIndex = index;
		if(leftChildIndex < this.size && arr[leftChildIndex] < arr[smallestElementIndex])
		{
			smallestElementIndex = leftChildIndex;
		}
		
		if(rightChildIndex < this.size && arr[rightChildIndex] < arr[smallestElementIndex])
		{
			smallestElementIndex = rightChildIndex;
		}
		
		// If equal then return 
		if(smallestElementIndex == index) return ;	
		// Swap
		int temp = arr[smallestElementIndex];
		arr[smallestElementIndex] = arr[index];
		arr[index] = temp;
		// Call again
		minHeapify(smallestElementIndex);
		
		// Or use below code 
		/*if(smallestElementIndex != index)
		{
			int temp = arr[smallestElementIndex];
			arr[smallestElementIndex] = arr[index];
			arr[index] = temp;
			
			minHeapify(smallestElementIndex);
		}*/
	}
	
	// If you are given an array of elements and you want to max heapify them
	public void buildMinHeap(int[] arr)
	{
		this.arr = arr;
		this.size = arr.length;
		
		int secondLastRowElementIndex = size/2 - 1;		// We need to find index of 2nd last row of tree (not the last row of tree)
		
		for(int i = secondLastRowElementIndex; i>=0; i--)
		{
			minHeapify(i);
		}
	}
	
	public static void main(String[] args)
	{
		Custom_MinHeap cmh = new Custom_MinHeap();
		int[] arr = {10,7,11,30,20,38,2,45};
		
		// If you are given an array of elements and you want to min heapify them
		//cmh.buildMinHeap(arr);
		//System.out.println(cmh.getMax());
		
		cmh.insertNewValue(arr[0]);
		cmh.insertNewValue(arr[1]);
		cmh.insertNewValue(arr[2]);
		System.out.println(cmh.getMin());
		
		cmh.insertNewValue(arr[3]);
		cmh.insertNewValue(arr[4]);
		System.out.println(cmh.getMin());
		
		cmh.insertNewValue(arr[5]);
		System.out.println(cmh.getMin());
		
		cmh.insertNewValue(arr[6]);
		cmh.insertNewValue(arr[7]);
		System.out.println(cmh.getMin());
		
		cmh.removeMin();
		System.out.println(cmh.getMin());
	}
}
