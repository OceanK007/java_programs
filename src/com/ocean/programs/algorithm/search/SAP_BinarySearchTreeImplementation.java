package com.ocean.programs.algorithm.search;

import java.util.*;

/*
 * Instructions to candidate.
 * Implement the "put" and "contains" methods.
 * Fix the "inOrderTraversal" method.
*/

public class SAP_BinarySearchTreeImplementation 
{
   public static void main(String[] args) 
   { 
	   	final BST searchTree = new BST();

	    searchTree.put(3);
	    searchTree.put(1);
	    searchTree.put(2);
	    searchTree.put(5);
	    
	    if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
	    		&& !searchTree.contains(0) 
	    		&& searchTree.contains(1)
	    		&& searchTree.contains(2)
	    		&& searchTree.contains(3)
	    		&& !searchTree.contains(4)
	    		&& searchTree.contains(5)
	    		&& !searchTree.contains(6)){
	    	System.out.println("Pass");
	    }
	    else 
	    {
	    	System.out.println("Fail");
	    }		
   	}

   	static class BST  
   	{
	
	    private Node root;
	
	    public BST() 
	    {
	      this.root = new Node();
	    }
	
	    public void put(int value) 
	    {
	      put(value, root);
	    }
	    
	    public void put(int value, Node root)
	    {
	    	if(root.val == null)
	    	{
	    		root.val = value;
	    	}
	    	else
		    {
		    	
		    	if(value < root.val)
		    	{
		    		if(root.left == null)
		    		{
		    			root.left = new Node();
		    		}
		    		put(value, root.left);
		    	}
		    	else
		    	{
		    		if(root.right == null)
		    		{
		    			root.right = new Node();
		    		}
		    		put(value, root.right);
		    	}
		    }
	    }
	
	    public boolean contains(int value) 
	    {
	      return contains(value, root);
	    }
	    
	    public boolean contains(int value, Node root)
	    {
	    	if(root == null || root.val == null)
	    	{
	    		return false;
	    	}
	    	if(value == root.val)
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		if(value < root.val)
	    		{
	    			return contains(value, root.left);
	    		}
	    		else
	    		{
	    			return contains(value, root.right);
	    		}
	    	}
	    }
	
	    public List<Integer> inOrderTraversal() 
	    {
	      final ArrayList<Integer> acc = new ArrayList<>();
	      inOrderTraversal(root, acc);
	      System.out.println(acc);
	      return acc;
	    }
	
	    private void inOrderTraversal(Node node, List<Integer> acc) 
	    {
	      if (node == null) 
	      {
	        return;
	      }
	      inOrderTraversal(node.left, acc);
	      acc.add(node.val);
	      inOrderTraversal(node.right, acc);
	    }
	
	    private static class Node 
	    {
	      Integer val;
	      Node left;
	      Node right;
	    }
   	}
}