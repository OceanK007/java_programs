package com.ocean.programs.datastructure.linkedlist;

import java.util.Scanner;

public class HR_Custom_SinglyLinkedList
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

		/*public void insertNode(int nodeData)
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
		}*/
		
		// This is basically the version of insertNodeAtTail if you don't have this.tail
		public void insertNode(int nodeData)	
		{
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

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
	
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) 
    {
        if(head == null)
        {
            head = new SinglyLinkedListNode(data);
        }
        else
        {
            SinglyLinkedListNode temp = head;
            while(true)
            {
                if(temp.next == null)
                {
                    temp.next = new SinglyLinkedListNode(data);
                    break;
                }
                
                temp = temp.next;
            }
        }
        
        return head;
    }
	
	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) 
	{
        if (head == null)
        {
            head = new SinglyLinkedListNode(data);
        }
        else
        {
            SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
            temp.next = head;
            return temp;
        }

        return head;
    }
	
	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position)
    {
        if (position == 0)
        {
            SinglyLinkedListNode top = new SinglyLinkedListNode(data);
            top.next = head;
            return top;
        }
        else
        {
            SinglyLinkedListNode result = head;
            int i = 1;
            while (true)
            {
                if(i == position)
                {
                    SinglyLinkedListNode in = new SinglyLinkedListNode(data);
                    in.next = result.next;
                    result.next = in;
                    
                    break;
                }
                
                result = result.next;
                i++;
            }
            
            return head;
        }
    }
	
	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) 
    {
        if(position == 0)
        {
            head = head.next;
            return head;
        }
        else
        {
            SinglyLinkedListNode temp = head;
            int i =1;
            
            while(true)
            {
                if(i == position)
                {
                    temp.next = temp.next.next;
                    break;
                }
                
                temp = temp.next;
                i++;
            }
            
            return head;
        }
    }
	
	static void reversePrint(SinglyLinkedListNode head) 
    {
        /*if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);*/

        // OR

        if (head != null) 
        {
            reversePrint(head.next);
            System.out.println(head.data); 
        }
    }
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
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

		printLinkedList(llist.head, ",");

		scanner.close();
	}
	
	// For insertNodeAtTail, insertNodeAtHead & 
	/*public static void main(String[] args) throws IOException 
	{
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) 
        {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);
            //SinglyLinkedListNode llist_head2 = insertNodeAtHead(llist.head, llistItem);
            //SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

            llist.head = llist_head;
        }

        printLinkedList(llist.head, " ");
        
        scanner.close();
    }*/
}
