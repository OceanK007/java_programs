package com.ocean.programs.datastructure.heap;

import java.util.Scanner;

// Heap properties: Element must be added as leaf node and root must be deleted always.
// Note: As per heap property, the root element must be deleted always. But here we are deleting specific element from heap.
public class HR_MinHeapWithSpecificElementDeletion
{
	int size = 0;
	int[] arr = new int[20];
	
	public void insertNewValue(int val)
	{
		if(size == arr.length) arr = doubleSizedArray(arr);		// Doubling the size of array in case there are many elements
		
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
	
	 private static int[] doubleSizedArray(int[] arr) 
	 {
	    int [] doubleSizedArray = new int[arr.length*2];
	    for (int i=0; i<arr.length; i++) 
	    {
	      doubleSizedArray[i] = arr[i];
	    }
	    return doubleSizedArray;
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
	
	public int removeSpecificElement(int elementToDelete)
	{
		int indexToDelete = findIndexInHeap(elementToDelete, 0);
		arr[indexToDelete] = arr[size - 1];		// swapping the last element with indexToDelete element
		size = size - 1;						// element deleted so size will be reduced by 1
		minHeapify(indexToDelete); 				// Re-shuffle the elements starting from index indexToDelete
		return elementToDelete;
	}
	
	public int findIndexInHeap(int elementToDelete, int fromIndex)
	{
		if (fromIndex >= size) return -1;
		
	    if (arr[fromIndex] == elementToDelete) return fromIndex;
	    	    
	    // Finding in left 
	    int foundInLeft = findIndexInHeap(elementToDelete, (2 * fromIndex + 1));
	    if (foundInLeft > -1) return foundInLeft;
	    
	    // Finding in right
	    return findIndexInHeap(elementToDelete, (2 * fromIndex + 2));
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
		HR_MinHeapWithSpecificElementDeletion ins = new HR_MinHeapWithSpecificElementDeletion();
	    Scanner in = new Scanner(System.in);
	    int queries = in.nextInt();
	    for (int q=0; q<queries; q++) 
	    {
	      int i = in.nextInt();
	      switch (i) 
	      {
	        case 1:
	          int value = in.nextInt();
	          ins.insertNewValue(value);
	          break;
	        case 2:
	          value = in.nextInt();  
	          ins.removeSpecificElement(value);
	          break;
	        case 3:
	          System.out.println(ins.getMin());
	          break;
	        default:
	          ;
	      }
	    }
	    in.close();
	}
}
/*
input:
5  
1 4  
1 9  
3  
2 4  
3   

Output:
4
9
*/