package com.ocean.programs.tricky;

public class StringImmutability 
{
	public static void main(String[] args) 
	{
		String m = "Ocean";
		m = m + "Life";
		System.out.println("String: "+m);		// OceanLife
		
		String n = "Ocean";
		n.concat("Life");
		System.out.println("String: "+n);		// Ocean
		
		String v = "Ocean";
		v = v.concat("Life");
		System.out.println("String: "+v);		// OceanLife
		
		String s1 = "Ocean";
		concatString(s1);  // s1 is not changed
        System.out.println("String: " + s1);	// Ocean
        
        Integer i = 5;
        addFour(i); 
        System.out.println("Integer: "+i);		// 5
        
        StringBuilder s2 = new StringBuilder("Ocean");
        concatByStringBuilder(s2); // s2 is changed
        System.out.println("StringBuilder: " + s2);		// OceanLife
	}
	
    public static void concatString(String s1)
    {
    	// Here s1 will be a different variable created in stack, 
    	// which is holding latest string address 
        s1 = s1 + "Life";
    }
    
    public static void addFour(Integer i)
    {
    	i = i+4;
    }
    
    public static void concatByStringBuilder(StringBuilder s2)
    {
    	s2.append("Life");
    }
}
