package com.ocean.programs.datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class HR_DeleteDuplicateValueNodesFromSortedLinkedList
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

	static void printLinkedList(SinglyLinkedListNode head, String separator)
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

	// Complete the removeDuplicates function below.
	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head)
	{
		SinglyLinkedListNode result = head;

		while (result != null && result.next != null)
		{
			if (result.data == result.next.data)
			{
				result.next = result.next.next;
				continue;
			}
			result = result.next;
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
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++)
			{
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

			printLinkedList(llist1, " ");
		}

		scanner.close();
	}
}
