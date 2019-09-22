package com.ocean.programs.string;

import java.util.Scanner;

/**
Sample Input
11			// Total characters
middle-Outz
2			// The number of letters to rotate the alphabet by

Sample Output
okffng-Qwvb

Explanation
Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b
**/
public class HR_CaesarCipher_RotateString 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
    
    static String caesarCipher(String s, int k) 
    {
        int a=97;
        int z=122;
        int A=65;
        int Z=90;
        
        if(k > 26)
    		k = k %26;
        
        StringBuilder sb = new StringBuilder();
                
        for(int i=0;i<s.length();i++)
        {
            int ascii = (int) s.charAt(i);
            char text = s.charAt(i);
            
            if(ascii >= 97 && ascii <=122)
            {
                if(ascii+k > 122)
                {
                    sb.append((char) ((int) (96+(ascii+k-122))));
                }
                else
                {
                    sb.append((char) (ascii+k));
                }
            }
            else if(ascii >= 65 && ascii <=90)
            {
                if(ascii+k > 90)
                {
                    sb.append((char) ((int) (64+(ascii+k-90))));
                }
                else
                {
                    sb.append((char) (ascii+k));
                }
            }
            else
                sb.append(text);
        }
        return sb.toString();
    }
}
