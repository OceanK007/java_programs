package com.ocean.programs.datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class HR_ReverseALinkedList
{

	static class SinglyLinkedListNode
	{
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData)
		{
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList
	{
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList()
		{
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData)
		{
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null)
			{
				this.head = node;
			}
			else
			{
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	static void printLinkedList(SinglyLinkedListNode head)
	{
		// Using Recursion
		/*System.out.println(head.data);
		if (head.next != null)
		{
			printLinkedList(head.next);
		}*/
		
		// Using iteration
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}

	// Using iteration
	// Video: https://www.youtube.com/watch?v=jY-EUKXYT20
	static SinglyLinkedListNode reverse(SinglyLinkedListNode head)
	{
		if (head == null)
			return head;

		SinglyLinkedListNode temp = head;    // To void any alteration in head node
		SinglyLinkedListNode result = null;

		while (temp != null)
		{
			SinglyLinkedListNode next = temp.next;    // Keeping the reference of next nodes
			temp.next = result;
			result = temp;
			temp = next;    // for while loop termination
		}

		return result;
	}

	// Using recursion
	// Video: https://www.youtube.com/watch?v=4mm39dVLlZ0
	/*static SinglyLinkedListNode reverseLinkedList(SinglyLinkedListNode head)
    {
        if (head == null || head.next == null) 
        {  
            return head;  
        }

        SinglyLinkedListNode remaining = reverse(head.next);

        head.next.next = head; 

        head.next = null;  

        return remaining; 
    }*/

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++)
		{
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++)
			{
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			SinglyLinkedListNode llist1 = reverse(llist.head);
			
			printLinkedList(llist1);

		}

		scanner.close();
	}
}
