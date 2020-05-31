package com.ocean.programs.datastructure.tree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HR_SwapNodesBasedOnDepths
{
	static class Node
	{
		int data;
		int depth;
		Node left, right;
		
		Node(int data, int depth)
		{
			this.data = data;
			this.depth = depth;
		}
	}

	/* Complete the swapNodes function below. */
	static int[][] swapNodes(int[][] indexes, int[] queries)
	{
		int[][] result = new int[queries.length][indexes.length];
		
		Node root = new Node(1,1);	// As root node will be with data 1 and depth 1
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		// Forming Binary Tree
		for(int i=0;i<indexes.length;i++)
		{
			Node currNode = queue.poll();
			int leftNode = indexes[i][0];
			int rightNode = indexes[i][1];
			
			currNode.left = leftNode == -1 ? null : new Node(leftNode,currNode.depth+1);
			currNode.right = rightNode == -1 ? null : new Node(rightNode,currNode.depth+1);
			
			if(currNode.left != null)
				queue.add(currNode.left);
			if(currNode.right != null)
				queue.add(currNode.right);
		}
		
		// Swapping Nodes
		for(int i=0;i<queries.length;i++)
		{
			swap_nodes(root, queries[i]);
			Integer[] inOrder = inOrderTraversal(root, new LinkedList<Integer>());
			for(int j=0;j<inOrder.length;j++)
			{
				result[i][j] = inOrder[j];
			}
		}
		
		return result;
	}
	
	// Solution1: Using iteration
	public static void swap_nodes(Node root, int depth)
	{
		// If depth is 1 then it will be applicable for depths: 1, 2*1, 3*1, ....
		// If depth is 2 then it will be applicable for depths: 2, 2*2, 3*2, ....
		// If depth is 3 then it will be applicable for depths: 3, 2*3, 3*3, ....
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Node currNode = queue.poll();
			
			if(currNode.depth % depth == 0)
			{
				Node temp = currNode.left;
				currNode.left = currNode.right;
				currNode.right = temp;
			}
			
			if(currNode.left != null) queue.add(currNode.left);
			if(currNode.right != null) queue.add(currNode.right);
		}
	}
	
	// Solution1: Using recursion
	/*public static void swap_nodes(Node root, int depth)
	{
		// If depth is 1 then it will be applicable for depths: 1, 2*1, 3*1, ....
		// If depth is 2 then it will be applicable for depths: 2, 2*2, 3*2, ....
		// If depth is 3 then it will be applicable for depths: 3, 2*3, 3*3, ....
		
		if(root != null)
		{
			if(root.depth % depth == 0)
			{
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
			swap_nodes(root.left, depth);
			swap_nodes(root.right, depth);
		}
	}*/
	
	public static Integer[] inOrderTraversal(Node root, List<Integer> list)
	{
		if(root != null)
		{
			inOrderTraversal(root.left, list);
			list.add(root.data);
			inOrderTraversal(root.right, list);
		}
		
		return list.toArray(new Integer[0]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++)
		{
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++)
			{
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++)
		{
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++)
		{
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++)
			{
				System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

				if (resultColumnItr != result[resultRowItr].length - 1)
				{
					System.out.print(" ");
				}
			}

			if (resultRowItr != result.length - 1)
			{
				System.out.println();
			}
		}

	}
}

/*
INPUT:
11
2 3
4 -1
5 -1
6 -1
7 8
-1 9
-1 -1
10 11
-1 -1
-1 -1
-1 -1
2
2
4

OUTPUT:
2 9 6 4 1 3 7 5 11 8 10
2 6 9 4 1 3 7 5 10 8 11
*/