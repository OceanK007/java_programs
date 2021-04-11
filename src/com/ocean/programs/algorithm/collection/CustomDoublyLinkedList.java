package com.ocean.programs.algorithm.collection;

public class CustomDoublyLinkedList
{
	private Node head;
	private Node tail;
	
	public void insertHead(int data)
	{
        Node nodeToBeInserted = new Node(data);
        if(head == null)
        {
            tail = nodeToBeInserted;
            //tail.setNext(null); 	// Already prev and next are null
            head = nodeToBeInserted;
        }
        else 
        {
        	// Head:  null-5-null	// Tail: null-5-null	// Node: null-4-null
        	nodeToBeInserted.setNext(head);		// Head: null-5-null	// Node: null-4-5
            head.setPrev(nodeToBeInserted);		// Head: 4-5-null 	// Node: null-4-5
            head = nodeToBeInserted;	// Head: null-4-5
        }
    }
	
	public void insertTail(int data)
	{
        Node nodeToBeInserted = new Node(data);
        if(tail == null)
        {
        	 tail = nodeToBeInserted;
        	 head = nodeToBeInserted;
        }
        else
        {
        	tail.setNext(nodeToBeInserted);
            nodeToBeInserted.setPrev(tail);
            this.tail = nodeToBeInserted;
        }
    }
	
	public void insertAt(int index, int data)
	{
        Node nodeToBeInserted = new Node(data);
        Node temp = head;
        for(int i = 0; i < index; i++)
        {
            temp = temp.getNext();
        }
        nodeToBeInserted.setPrev(temp.getPrev());
        nodeToBeInserted.setNext(temp);
        temp.setPrev(nodeToBeInserted);
        nodeToBeInserted.getPrev().setNext(nodeToBeInserted) ;
    }
	
	public void deleteHead()
	{
        this.head = this.head.getNext();
        this.head.setPrev(null);
    }
	
	public void deleteTail()
	{
		this.tail = this.tail.getPrev();
		this.tail.setNext(null);
    }
	
	public void deleteAt(int position)
	{
        Node temp = head;
        for(int i = 0; i < position; i++)
        {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
    }
	
	public void traverse()
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
	
	private class Node
	{
		private int data;
	    private Node prev;
	    private Node next;

	    public Node(int data)
	    {
	        this.data = data;
	    }

	    public int getData()
		{
			return data;
		}
	    
		public Node getPrev()
		{
			return prev;
		}

		public void setPrev(Node prev)
		{
			this.prev = prev;
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
		CustomDoublyLinkedList cdll = new CustomDoublyLinkedList();
		cdll.insertHead(6);
		cdll.insertHead(4);
		cdll.insertHead(3);
		cdll.insertHead(2);
		cdll.insertHead(1);
		cdll.traverse();
		
		CustomDoublyLinkedList cdll2 = new CustomDoublyLinkedList();
		cdll2.insertTail(1);
		cdll2.insertTail(2);
		cdll2.insertTail(3);
		cdll2.insertTail(4);
		cdll2.insertTail(6);
		cdll2.traverse();
		
		cdll.insertAt(4, 5);
		cdll.traverse();
		
		cdll.deleteHead();
		cdll.traverse();
		
		cdll.deleteTail();
		cdll.traverse();
		
		cdll.deleteAt(2);
		cdll.traverse();
	}
}
