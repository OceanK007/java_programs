package com.ocean.programs.logical;

/** Given a Binary Tree,  print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance from root. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
Examples:
                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14
For the above tree the output should be 5, 10, 3, 14, 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.
                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14
For the above tree the output should be 5, 10, 4, 14, 25.
 
Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, pointer to left child and pointer to right child. The input can be taken as command line or hardcoded in the program itself.
 
Output:
The function should print nodes in bottom view of Binary Tree.  Your code should not print a newline, it is added by the caller code that runs your function.
 
Example:

Input:
2 (2 nodes with the format Parent, Child (L,R))
1 2 R 1 3 L –     1 is the root, 2 is right to 1,         1 is the root, 3 is left to 1
Output:
3 1 2

Input
4  (4 nodes with the format Parent, Child (L,R)) 
10 20 L 10 30 R 20 40 L 20 60 R
Output
40 20 60 30
**/
public class GFG_BottonViewOfBinaryTree 
{

}
