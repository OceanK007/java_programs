package com.ocean.programs.design.pattern.creational;

/**
•	What is factory?
	o	A component responsible solely  for the wholesale (not piecwise) creation of objects.
	o	A factory method is a static method that creates objects.
	o	A factory can be external or reside inside the object as an inner class.
	o	Hierarchies of factories can be used to create related objects.
•	Why is it required?
	o	Wholesale object creation (non-piecewise, unlike Builder) can be outsourced to:
		1.	A separate function (Factory method).
		2.	That may exist in a separate class (Factory).
		3.	Can create hierarchy of factories with Abstract Factory.
 */
interface Shape
{
	void draw();
}

class Rectangle implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Rectangle's draw() method");
	}
}

class Square implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Square's draw() method");
	}
}

class Circle implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Circle's draw() method");
	}
}

class ShapeFactory
{
	public Shape getShape(String shape)
	{
		if(shape == null)
			return null;
		if(shape.equalsIgnoreCase("circle"))
			return new Circle();
		else if(shape.equalsIgnoreCase("rectangle"))
			return new Rectangle();
		else if(shape.equalsIgnoreCase("square"))
			return new Square();
		
		return null;
	}
}

public class FactoryPatternUsingInterface 
{
	public static void main(String[] args) 
	{
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape rectangle = shapeFactory.getShape("rectangle"); 
		rectangle.draw();
		
		Shape circle = shapeFactory.getShape("circle"); 
		circle.draw();
		
		Shape square = shapeFactory.getShape("square"); 
		square.draw();
	}
}