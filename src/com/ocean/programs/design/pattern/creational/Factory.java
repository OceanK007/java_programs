package com.ocean.programs.design.pattern.creational;

import com.ocean.programs.design.pattern.creational.ShapeFactory.Shapes;

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
	enum Shapes
	{
		CIRCLE, RECTANGLE, SQUARE
	}
	
	public Shape getShape(Shapes shape)
	{
		if(shape == null)
			return null;
		if(shape.name().equals(Shapes.CIRCLE.name()))
			return new Circle();
		else if(shape.name().equals(Shapes.RECTANGLE.name()))
			return new Rectangle();
		else if(shape.name().equals(Shapes.SQUARE.name()))
			return new Square();
		
		return null;
	}
}

public class Factory 
{
	public static void main(String[] args) 
	{
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape rectangle = shapeFactory.getShape(Shapes.RECTANGLE); 
		rectangle.draw();
		
		Shape circle = shapeFactory.getShape(Shapes.CIRCLE); 
		circle.draw();
		
		Shape square = shapeFactory.getShape(Shapes.SQUARE); 
		square.draw();
	}
}