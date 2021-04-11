package com.ocean.programs.algorithm.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CustomSinglyLinkedList
{
	private Node head;
	
	public Node getHead() 
	{
		return head;
	}
	
	public void insert(int data)
	{
		Node newNode = new Node(data);
		if(this.head == null)
		{
			head = newNode;
		}
		else 
		{
			Node currentNode = head;
			while(currentNode.getNext() != null)
			{
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
	}
	
	public void insertHead(int data)
	{
        Node newNode = new Node(data);
        if(head == null)
        {
        	head = newNode;
        }
        else
        {
        	newNode.setNext(head);
            head = newNode;
        }
	}
	
	public void insertAt(int index, int data)
	{
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        // [1, 2, 3, 4, 6]
        // If you want to insert at index 4, then you will find the element value 4 (since there is no way to go back, you can traverse only forward)
        for(int i = 0; i<index-1; i++)
        {
            node = node.getNext();
        }        
        nodeToBeInserted.setNext(node.getNext());
        node.setNext(nodeToBeInserted);
    }
	
	public void deleteNodeAt(int index)
	{
        Node node = head;
        // [1, 2, 3, 4, 5, 6]
        // If you want to insert at index 4, then you will find the element value 4 (since there is no way to go back, you can traverse only forward)
        for(int i = 0; i< index -1; i++)
        {
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
    }
	
	public void display()
	{
        if(head != null)
        {
        	StringBuilder result = new StringBuilder("[");
            Node temp = head;
            while (temp.getNext() != null)
            {
                result.append(temp.getData() + ", ");
                temp = temp.getNext();
            }
            result.append(temp.getData() + "]");
            System.out.println(result.toString());
        }
    }
	
	public void reverse()
	{
        Node reversedList = null;
        Node current = head;
        Node next = null;
        // 1, 2, 3, 4, 5
        // current: 1 | next: 2,3,4,5 | reversedList: null
        // current: 2 | next: 3,4,5 | reversedList: 1
        // current: 3 | next: 4,5 | reversedList: 2,1
        // current: 4 | next: 5 | reversedList: 3,2,1
        // current: 5 | next: null | reversedList: 4,3,2,1
        // current: null | next: null | reversedList: 5,4,3,2,1
        while (current != null)
        {
        	// These steps must be done in this order
            next = current.getNext();	// Step1: set next
            current.setNext(reversedList);	// Step2: set next of current
            reversedList = current;			// Step3: set previous
            current = next;				// Step4: set current
        }
        head = reversedList;
    }
	
	/** If we have already has this node in hashmap it means there is a cycle (Because you are encountering the node second time)**/
	public boolean checkLoop()
	{
        HashSet<Node> uniqueSet = new HashSet<Node>();
        Node temp = head;
        while (temp != null)
        {
            if(uniqueSet.contains(temp))
            {
                return true;
            }
            
            uniqueSet.add(temp);
            
            temp = temp.getNext();
        }
        
        return false;
    }

	
	private class Node
	{
		private int data;
	    private Node next;

	    public Node(int data)
	    {
	        this.data = data;
	    }

	    public int getData()
		{
			return data;
		}
	    
		public Node getNext()
		{
			return next;
		}

		public void setNext(Node next)
		{
			this.next = next;
		}
	}
	
	public static void main(String[] args)
	{
		CustomSinglyLinkedList csll = new CustomSinglyLinkedList();
		csll.insert(1);
		csll.insert(2);
		csll.insert(3);
		csll.insert(4);
		csll.insert(6);
		csll.display();
		csll.reverse();
		csll.display();
		csll.reverse();
		csll.display();
		csll.insertHead(0);
		csll.display();
		csll.insertAt(5, 5);
		csll.display();
		csll.deleteNodeAt(6);
		csll.display();
		System.out.println("Contains Loop: "+csll.checkLoop());
		csll.insert(4);
		csll.insert(5);
		csll.display();
		System.out.println("Contains Loop: "+csll.checkLoop());
		csll.deleteNodeAt(7);
		csll.deleteNodeAt(6);
		csll.display();
		System.out.println("Creating Loop Data");
		csll.getHead().getNext().getNext().getNext().getNext().getNext().setNext(csll.getHead());
		//csll.display(); // This will fail since it will keep calling and will throw java.lang.OutOfMemoryError
		System.out.println("Contains Loop: "+csll.checkLoop());
	}
}
