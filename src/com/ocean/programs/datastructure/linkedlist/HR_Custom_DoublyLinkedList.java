package com.ocean.programs.datastructure.linkedlist;

public class HR_Custom_DoublyLinkedList
{
	static class DoublyLinkedListNode
	{
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData)
		{
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}
	
	static class DoublyLinkedList
	{
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList()
		{
			this.head = null;
			this.tail = null;
		}

		/*public void insertNode(int nodeData)
		{
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null)
			{
				this.head = node;
			}
			else
			{
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}*/
		
		public void insertNode(int nodeData)	
		{
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null)
			{
				this.head = node;
				this.tail = node;
			}
			else
			{
				this.tail.next = node;	// Any update in this.tail.next will update in this.head as well
				this.tail = node;
			}
		}
	}
	
	// Rest all same like SinglyLinkedList
}