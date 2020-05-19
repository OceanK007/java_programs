package com.ocean.programs.datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class HR_InsertNodeInSortedDoublyLinkedList
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

		public void insertNode(int nodeData)
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
		}
	}

	static void printLinkedList(DoublyLinkedListNode head, String separator)
	{
		// Using Recursion
		/*System.out.print(head.data + separator);
		if (head.next != null)
		{
			printLinkedList(head.next);
		}*/
		
		// Using iteration
		while(head != null)
		{
			System.out.print(head.data + separator);
			head = head.next;
		}
	}

    // Complete the sortedInsert function below.
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) 
    {
        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode n = new DoublyLinkedListNode(data);

        if(head == null)
        {
            return n;
        }
        
        while(temp != null)
        {
            if(temp.data < data && temp.next == null)    // Means element will be inserted at end
            {
                n.prev = temp;
                temp.next = n;
                break;
            }
            else if(temp.data > data || temp.data == data)
            {
                n.next = temp;
                n.prev = temp.prev;
                
                if(temp.prev != null)    // Means element will be inserted at start
                {
                    temp.prev.next = n;
                    temp.prev = n;
                }
                else    
                {
                    temp.prev = n;
                    head = n;
                }
                
                break;
            }
            
            temp = temp.next;
        }

        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++)
		{
			DoublyLinkedList llist = new DoublyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++)
			{
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			int data = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

			printLinkedList(llist1, " ");
		}

		scanner.close();
	}
}