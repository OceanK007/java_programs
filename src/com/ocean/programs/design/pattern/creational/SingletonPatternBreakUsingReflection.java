package com.ocean.programs.design.pattern.creational;

import java.lang.reflect.Constructor;

//Singleton class
class SingletonClass 
{
	 // public instance initialized when loading the class
	 public static SingletonClass instance = new SingletonClass();
	  
	 private SingletonClass() 
	 {
	     // private constructor
	 }
}

public class SingletonPatternBreakUsingReflection 
{
	 public static void main(String[] args)
	 {
	     SingletonClass2 instance1 = SingletonClass2.instance;
	     SingletonClass2 instance2 = null;
	     try
	     {
	         Constructor[] constructors = SingletonClass2.class.getDeclaredConstructors();
	         for (Constructor constructor : constructors) 
	         {
	             // Below code will destroy the singleton pattern
	             constructor.setAccessible(true);
	             instance2 = (SingletonClass2) constructor.newInstance();
	             break;
	         }
	     }
	     catch (Exception e) 
	     {
	         e.printStackTrace();
	     }
	      
	     System.out.println("instance1.hashCode(): "+ instance1.hashCode());
	     System.out.println("instance2.hashCode(): "+ instance2.hashCode());
	 }
}