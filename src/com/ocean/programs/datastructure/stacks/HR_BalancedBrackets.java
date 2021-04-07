package com.ocean.programs.datastructure.stacks;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class HR_BalancedBrackets {

    // Solution1: without stack
    /*static String isBalanced(String s) 
    {
        String result = "YES";

        if(s.length() %2 != 0) return "NO";

        int length = s.length();
        for(int i=0;i<length/2;i++)
        {
            if(s.indexOf("()") != -1)
                s = s.replace("()", "");
            else if(s.indexOf("[]") != -1)
                s = s.replace("[]", "");
            else if(s.indexOf("{}") != -1)
                s = s.replace("{}", "");
            if(s.equals("")) break;
        }

        if(s.length() > 0) result = "NO";

        return result;
    }*/
    
    // Solution2: with stack
    /*static String isBalanced(String s) 
    {
		Stack<Character> stack = new Stack<>();
		char upperElement = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (!stack.isEmpty())
			{
				upperElement = stack.peek();
			}
			stack.push(s.charAt(i));
			if (!stack.isEmpty() && stack.size() > 1)
			{
				if ((upperElement == '[' && stack.peek() == ']') || (upperElement == '{' && stack.peek() == '}') || (upperElement == '(' && stack.peek() == ')'))
				{
					stack.pop();
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
    }*/
	
	// Solution3: with stack
	static String isBalanced(String s)
	{
		if (s == null || s.length() == 0) return "YES";
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
				stack.pop();
			else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
				stack.pop();
			else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
				stack.pop();
			else
				return "NO";

		}
		return stack.empty() ? "YES" : "NO";
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }


        scanner.close();
    }
}

/*
 INPUT:
 3
{[()]}
{[(])}
{{[[(())]]}}

OUTPUT:
YES
NO
YES
 */
