package com.ocean.programs.design.pattern.creational;

import java.util.HashMap;
import java.util.Map;

public class PrototypePattern 
{
	public static void main(String[] args) 
	{
		ColorStore.getColor("blue").addColor(); 
        ColorStore.getColor("black").addColor(); 
        ColorStore.getColor("black").addColor(); 
        ColorStore.getColor("blue").addColor(); 
	}
}

abstract class Color2 implements Cloneable 
{ 
    protected String colorName; 
       
    abstract void addColor(); 
       
    // It's shallow copy not deep copy. (Use it when only shallow copy is required)
    // Use copy constructor of copy through serialization
    @Override
    public Object clone()  
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
} 
  
class blueColor extends Color2 
{ 
    public blueColor()  
    { 
        this.colorName = "blue"; 
    } 
   
    @Override
    void addColor()  
    { 
        System.out.println("Blue color added"); 
    } 
      
} 
  
class blackColor extends Color2{ 
   
    public blackColor() 
    { 
        this.colorName = "black"; 
    } 
   
    @Override
    void addColor()  
    { 
        System.out.println("Black color added"); 
    } 
} 
   
class ColorStore 
{ 
    private static Map<String, Color2> colorMap = new HashMap<String, Color2>();  
       
    static 
    { 
        colorMap.put("blue", new blueColor()); 
        colorMap.put("black", new blackColor()); 
    } 
       
    public static Color2 getColor(String colorName) 
    { 
        return (Color2) colorMap.get(colorName).clone(); 
    } 
} 