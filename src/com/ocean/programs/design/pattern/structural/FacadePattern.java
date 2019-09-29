package com.ocean.programs.design.pattern.structural;

/**
Facade is a part of Gang of Four design pattern and it is categorized under Structural design patterns.

As the name suggests, it means the face of the building. The people walking past the road can only see this glass face of the building. 
They do not know anything about it, the wiring, the pipes and other complexities. It hides all the complexities of the building and displays a friendly face.

In Java, the interface JDBC can be called a facade because, we as users or clients create connection using the “java.sql.Connection” interface, the implementation of which we are not concerned about. The implementation is left to the vendor of driver.

Another good example can be the startup of a computer. When a computer starts up, it involves the work of cpu, memory, hard drive, etc. 
To make it easy to use for users, we can add a facade which wrap the complexity of the task, and provide one simple interface instead.

Same goes for the Facade Design Pattern. It hides the complexities of the system and provides an interface to the client from where the client can access the system.


When Should this pattern be used?
Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
**/
public class FacadePattern 
{
	public static void main(String[] args) 
	{
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();	
	}
}

interface Shape 
{
	void draw();
}

class Rectangle implements Shape 
{
	@Override
	public void draw() 
	{
		System.out.println("Rectangle::draw()");
	}
}

class Square implements Shape 
{
	@Override
	public void draw() 
	{
		System.out.println("Square::draw()");
	}
}

class Circle implements Shape 
{
	@Override
	public void draw() 
	{
		System.out.println("Circle::draw()");
	}
}

class ShapeMaker 
{
	public void drawCircle()
	{
		Shape circle = new Circle();
	    circle.draw();
	}
	
	public void drawRectangle()
	{
		Shape rectangle = new Rectangle();
	    rectangle.draw();
	}
	
	public void drawSquare()
	{
		Shape square = new Square();
	    square.draw();
	}
}