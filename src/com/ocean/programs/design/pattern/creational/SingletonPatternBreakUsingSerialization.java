package com.ocean.programs.design.pattern.creational;

//Java code to explain effect of Serilization on singleton classes
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonClass3 implements Serializable 
{
	 // public instance initialized when loading the class
	 public static SingletonClass3 instance = new SingletonClass3();
	  
	 private SingletonClass3() 
	 {
	     // private constructor
	 }
}

public class SingletonPatternBreakUsingSerialization 
{

	 public static void main(String[] args) 
	 {
	     try
	     {
	         SingletonClass3 instance1 = SingletonClass3.instance;
	         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.text"));
	         out.writeObject(instance1);
	         out.close();
	  
	         // deserialize from file to object
	         ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.text"));
	         SingletonClass3 instance2 = (SingletonClass3) in.readObject();
	         in.close();
	  
	         System.out.println("instance1 hashCode: "+ instance1.hashCode());
	         System.out.println("instance2 hashCode: "+ instance2.hashCode());
	     } 
	      
	     catch (Exception e) 
	     {
	         e.printStackTrace();
	     }
	 }
}