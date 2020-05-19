package com.ocean.programs.datastructure.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class HR_TopView
{

	public static class NodeObj
	{
		public Node node;
		public int distance;

		NodeObj(Node node, int distance)
		{
			this.node = node;
			this.distance = distance;
		}
	}
	
	/*class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	// Video: https://www.youtube.com/watch?v=LtO96Ici8kc&t=1079s
	// Similar like Vertical Order Traversal
	public static void topView(Node root) 
    {   
       if(root == null)
           return;
       else
       {
           Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();    // Automatically sort with key
           Queue<NodeObj> queue = new LinkedList<NodeObj>();
           queue.add(new NodeObj(root, 0));
           
           while(!queue.isEmpty())
           {
               NodeObj n = queue.poll();
               if(!sortedMap.containsKey(n.distance))
               {
                   sortedMap.put(n.distance, n.node.data);
               }
               
               if(n.node.left != null)
               {
                   queue.add(new NodeObj(n.node.left, n.distance-1));
               }
               
               if(n.node.right != null) 
               {
                   queue.add(new NodeObj(n.node.right, n.distance+1));
               }
           }
           
           Iterator<java.util.Map.Entry<Integer, Integer>> i = sortedMap.entrySet().iterator();
           while(i.hasNext())
           {
               java.util.Map.Entry<Integer, Integer> eset = i.next();
               System.out.print(eset.getValue() + " ");
           }
       }
    }

	public static Node insert(Node root, int data)
	{
		if (root == null)
		{
			return new Node(data);
		}
		else
		{
			Node cur;
			if (data <= root.data)
			{
				cur = insert(root.left, data);
				root.left = cur;
			}
			else
			{
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0)
		{
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}
}