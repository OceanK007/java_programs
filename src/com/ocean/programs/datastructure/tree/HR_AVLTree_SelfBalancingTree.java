package com.ocean.programs.datastructure.tree;

public class HR_AVLTree_SelfBalancingTree
{
	static class Node
	{
		public int val;
		public int ht;
		public Node left;
		public Node right;
	}
	
	static Node insert(Node node, int val)
	{   
		// START: INSERT IN BST //
		if (node == null) 
		{
			node = new Node();
            node.val = val;
            return node;
		}
		
		if (val > node.val)
		{
			node.right = insert(node.right, val);
		}
		else
		{
			node.left = insert(node.left, val);
		}
		// END: INSERT IN BST //
		
		// Setting Height
		node.ht = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		
		// Balance Factor
		int bal = getHeight(node.left) - getHeight(node.right);
		
		// Perform rotations
		// Left Left Case
		if (bal > 1 && val < node.left.val)
		{
			return rightRotate(node);
		}
		// Right Right Case
		if (bal < -1 && val > node.right.val)
		{
			return leftRotate(node);
		}
		// Left Right Case
		if (bal > 1 && val > node.left.val)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// Right Left Case
		if (bal < -1 && val < node.right.val)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	static Node leftRotate(Node node)
	{
		if (node == null) return null;
		
		// Check the diagram for better understanding
		Node temp = node.right;	// Taking right part in a temp variable
		node.right = temp.left;	// Left part of 'temp' will be assigned to right part of 'node'
		
		temp.left = node;	// Left part of 'temp' will be 'node' now
		
		node.ht = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		temp.ht = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
		
		// Return new node 'temp'
		return temp;
	}

	static Node rightRotate(Node node)
	{
		if (node == null) return null;
		
		// Check the diagram for better understanding
		Node temp = node.left;	// Taking left part in a temp variable
		node.left = temp.right;	// Right part of 'temp' will be assigned to left part of 'node'
		
		temp.right = node;	// Right part of 'temp' will be 'node' now
		
		node.ht = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		temp.ht = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1; 
		
		// Return new node 'temp'
		return temp;
	}

	static int getHeight(Node root)
	{
		if (root == null) return -1;
		return root.ht;
	}
	
    public static void inOrder(Node root) 
    {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
	
	public static void main(String[] args)
	{
		Node root = insert(null,10);
		root = insert(root,20);
		root = insert(root,30);
		root = insert(root,40);
		root = insert(root,50);
		root = insert(root,25);
		
		/* BST
		 	10
		 	  \
		 	  20
		 	    \
		 	    25
		 	      \
		 	      30
		 	        \
		 	        40
		 	          \
		 	          50
		 	          
		 AVL Tree would be 
		        30 
		       /  \ 
		     20   40 
		    /  \     \ 
		   10  25    50 
	   */
		
		// Inorder traversal will be: 10,20,25,30,40,50
		inOrder(root);
	}
}