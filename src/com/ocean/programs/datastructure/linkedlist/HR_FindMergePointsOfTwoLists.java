package com.ocean.programs.datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class HR_FindMergePointsOfTwoLists
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

    // Complete the findMergeNode function below.
    // Solution 1
    /*static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) 
    {   
        int result = 0;
        SinglyLinkedListNode temp1 = head1;

        while(temp1 != null)
        {
            if(result > 0)
                break;
            
            SinglyLinkedListNode temp2 = head2;
            while(temp2 != null)
            {
                if(temp1 == temp2)
                {
                    result = temp1.data;
                    break;
                }

                temp2 = temp2.next;
            }
            
            temp1 = temp1.next;
        }

        return result;
    }*/
    
    // Solution 2 (Best approach)
    /* 
     head1 = 1 -> 2 -> 3 -> 7 -> 8     length = 5     
     head2 = 5 -> 6 -> 7 -> 8          length = 4
     
     head1 = 1 -> 2 -> 3 -> 7 -> 8 -> 5 -> 6 -> 7 -> 8    length = 5+4 = 9
     head2 = 5 -> 6 -> 7 -> 8 -> 1 -> 2 -> 3 -> 7 -> 8    length = 4+5 = 9
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) 
    {   
        SinglyLinkedListNode head1Current = head1;
        SinglyLinkedListNode head2Current = head2;
        
        while(head1Current != head2Current)
        {
            if(head1Current.next == null)
            {
                head1Current = head2;
            }
            else
            {
                head1Current = head1Current.next;
            }
            
            if(head2Current.next == null)
            {
                head2Current = head1;
            }
            else
            {
                head2Current = head2Current.next;
            }
        }
        
        return head1Current.data;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++)
		{
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++)
			{
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++)
			{
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode ptr1 = llist1.head;
			SinglyLinkedListNode ptr2 = llist2.head;

			for (int i = 0; i < llist1Count; i++)
			{
				if (i < index)
				{
					ptr1 = ptr1.next;
				}
			}

			for (int i = 0; i < llist2Count; i++)
			{
				if (i != llist2Count - 1)
				{
					ptr2 = ptr2.next;
				}
			}

			ptr2.next = ptr1;

			int result = findMergeNode(llist1.head, llist2.head);

			System.out.println(result);
		}


		scanner.close();
	}
}
