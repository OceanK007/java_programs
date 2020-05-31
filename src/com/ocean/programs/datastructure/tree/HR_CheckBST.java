package com.ocean.programs.datastructure.tree;

public class HR_CheckBST
{
	// Check if a binary tree is a binary search tree or not.
    // The data value of every node in a node's left subtree is less than the data value of that node.
    // The data value of every node in a node's right subtree is greater than the data value of that node.
    // To check: Inorder traversal is always in ascending order.
    public static int minValue = Integer.MIN_VALUE; // You can use node or data 
    public static boolean checkBST(Node root)
    {
    	if(root == null) return true;

        if(checkBST(root.left) == false) return false;            
        if(minValue >= root.data) return false;
        minValue = root.data;
        return checkBST(root.right);
    }
    
    public static void main(String args[]) 
    { 
    	Node node = new Node(4); 
        node.left = new Node(2); 
        node.right = new Node(5); 
        node.left.left = new Node(1); 
        node.left.right = new Node(3); 
  
        if (HR_CheckBST.checkBST(node)) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 
}
