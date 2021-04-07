package com.ocean.programs.algorithm.collection;

import java.util.Arrays;

public class CustomArrayList
{
	private static final int SIZE_FACTOR = 5;	// How much the size will be incremented
	private Object data[];
	private int currentIndex;
	private int currentSize;	
	
	public CustomArrayList()
	{
		this.data = new Object[SIZE_FACTOR];
		this.currentSize = SIZE_FACTOR;
	}
	
	private void increaseSizeAndReallocate() 
	{
		// Doubling the size
		this.currentSize = this.currentSize + SIZE_FACTOR;
		Object newData[] = new Object[this.currentSize];
		
		for(int i=0; i<data.length;i++)
		{
			newData[i]=data[i];
		}
		
		this.data=newData;
	}
	
	public void add(Object obj)
	{
		//we need to increase the size of data[]
		if(this.currentIndex == this.currentSize-1)
			increaseSizeAndReallocate();

		data[this.currentIndex] = obj;
		this.currentIndex++;
	}
	
	public Object get(int index) throws Exception
	{
		if(index > this.currentIndex-1)
		{
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(index < 0)
		{
			throw new Exception("Negative Value");
		}
		
		return this.data[index];		
	}
	
	public void remove(int index) throws Exception
	{
		if(index > this.currentIndex-1)
		{
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(index < 0)
		{
			throw new Exception("Negative Value");
		}
		//System.out.println("Object getting removed:"+this.data[i]);
		for(int x=index; x<this.data.length-1;x++)
		{
			data[x]=data[x+1];
		}
		this.currentIndex--;
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) throws Exception
	{
		CustomArrayList cal = new CustomArrayList();
		cal.add(1);
		cal.add(2);
		cal.add(3);
		cal.add(4);
		cal.add(5);
		cal.add(6);
		cal.add(7);
		cal.add(8);
		cal.add(9);
		cal.add(10);
		
		System.out.println("Before remove: "+cal.toString());
		cal.remove(2);
		System.out.println("get(2): "+cal.get(2));
		System.out.println("After remove: "+cal.toString());
	}
}
