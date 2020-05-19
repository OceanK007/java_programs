package com.ocean.programs.datastructure.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import com.ocean.programs.datastructure.tree.HR_TopView.NodeObj;

class Node 
{
    Node left;
    Node right;
    int data;
    
    Node(int data) 
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class HR_Custom_BinaryTree 
{
    // Solution1: Using recursion
    /*public static void preOrder(Node root) 
    {
        if(root==null)
        {
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }*/
    
    // Solution2: Using Stack
    public static void preOrder(Node root) 
    {
        if(root == null) return ;
        
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        
        while(!stack.isEmpty())
        {
            Node currNode = stack.pop();    // Will pop the last node first
            System.out.print(currNode.data+" ");
            
            // Here adding right node first because in stack it's LIFO
            if(currNode.right != null)
            {
                stack.add(currNode.right);
            }
            if(currNode.left != null)
            {
                stack.add(currNode.left);
            }
        }
    }
    
    // Solution1: Using recursion
    /*public static void postOrder(Node root) 
    {
        if(root==null)
        {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }*/
    
    // Solution2: Using Stack
    public static void postOrder(Node root) 
    {
        if(root == null) return ;
        
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        Node childrenPrintedNode = root;
        
        while(!stack.isEmpty())
        {
            Node currNode = stack.peek();    // Will peek (won't remove) the last node first
            
            if((currNode.left == null && currNode.right == null) ||    // Nodes without children should be printed
            childrenPrintedNode == currNode.left || childrenPrintedNode == currNode.right) // Nodes whose children has already printed    
            {
                System.out.print(currNode.data + " ");
                stack.pop();
                childrenPrintedNode = currNode;
            }
            else
            {
                // Here adding right node first because in stack it's LIFO
                if(currNode.right != null)
                {
                    stack.push(currNode.right);
                }
                if(currNode.left != null)
                {
                    stack.push(currNode.left);
                }
            }
        }
    }
    
    // Solution1: Using recursion
    /*public static void inOrder(Node root) 
    {
        if(root==null)
        {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }*/
    
    // Solution2: Using Stack
    public static void inOrder(Node root) 
    {
        if(root == null) return ;
        
        Node temp = root;    // To avoid any iteration in root node
        Stack<Node> stack = new Stack<Node>();
        
        while(!stack.isEmpty() || temp != null)
        {
            while(temp != null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void levelOrder(Node root) 
    {
        if(root == null) return ;
      
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
      
        while(!queue.isEmpty())
        {
            Node currNode = queue.poll();
          
            System.out.print(currNode.data + " ");
            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }
    }

    // Similar like TopView problem
    public static void verticalOrder(Node root) 
    {   
       if(root == null)
           return;
       else
       {
           Map<Integer, List<Integer>> sortedMap = new TreeMap<Integer, List<Integer>>();    // Automatically sort with key
           Queue<NodeObj> queue = new LinkedList<NodeObj>();
           queue.add(new NodeObj(root, 0));
           
           while(!queue.isEmpty())
           {
               NodeObj n = queue.poll();
               if(!sortedMap.containsKey(n.distance))
               {
            	   List<Integer> list = new LinkedList<Integer>();
            	   list.add(n.node.data);
                   sortedMap.put(n.distance, list);
               }
               else
               {
            	   List<Integer> list = sortedMap.get(n.distance);
            	   list.add(n.node.data);
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
           
           Iterator<Entry<Integer, List<Integer>>> iterator = sortedMap.entrySet().iterator();
           while(iterator.hasNext())
           {
               Entry<Integer, List<Integer>> eset = iterator.next();
               List<Integer> list = eset.getValue();
               for(Integer i : list)
               {
            	   System.out.print(i + " ");
               }
           }
       }
    }
    
    public static int height(Node root) 
    {
        if(root == null)
            return -1;
    
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    
	/*public static Node insert(Node root, int data)
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
	}*/
    
    /*public static Node insert(Node root,int data) 
    {
        if(root == null)
            return new Node(data);
        
        if(data <= root.data)
        {
            if(root.left == null) root.left = new Node(data);
            else root.left = insert(root.left, data);
        }
        if(data > root.data)
        {
            if(root.right == null ) root.right = new Node(data);
            else root.right = insert(root.right, data);
        }

        return root;
    }*/
    
    public static Node insert(Node root,int data) 
    {
        if(root == null)
            return new Node(data);
        
        if(data <= root.data)
        {
            root.left = insert(root.left, data);
        }
        if(data > root.data)
        {
            root.right = insert(root.right, data);
        }

        return root;
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
		preOrder(root);
	}	
}