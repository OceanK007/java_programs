package com.ocean.programs.design.pattern.creational;

/** A factory that creates other factories, and these factories in turn create objects 
 * derived from base classes. You do this because you often don't just want to create a single 
 * object (as with Factory method) - rather, you want to create a collection of related objects.**/
interface Shape2
{
	void draw();
}

class Rectangle2 implements Shape2
{
	@Override
	public void draw()
	{
		System.out.println("Rectangle2");
	}
}

class Square2 implements Shape2
{
	@Override
	public void draw()
	{
		System.out.println("Square2");
	}
}

interface Color
{
	void fill();
}

class Red implements Color
{
	@Override
	public void fill() 
	{
		System.out.println("Red");
	}
}

class Green implements Color
{
	@Override
	public void fill() 
	{
		System.out.println("Green");
	}
}

//################## Abstract Factory #####################//
interface AbstractFactory
{
	Shape2 getShape(String shape);
	Color getColor(String color);
}

class ShapeFactory2 implements AbstractFactory		// Factory Pattern for Shape
{
	@Override
	public Shape2 getShape(String shape)
	{
		if(shape == null)
			return null;
		if(shape.equalsIgnoreCase("Rectangle"))
			return new Rectangle2();
		else if(shape.equalsIgnoreCase("Square"))
			return new Square2();
		
		return null;
	}

	@Override
	public Color getColor(String color) 
	{
		return null;
	}
}

class ColorFactory implements AbstractFactory	// Factory Pattern for Color
{
	@Override
	public Shape2 getShape(String shape)
	{
		return null;
	}

	@Override
	public Color getColor(String color) 
	{
		if(color == null)
			return null;
		if(color.equalsIgnoreCase("Red"))
			return new Red();
		else if(color.equalsIgnoreCase("Green"))
			return new Green();
		
		return null;
	}
}

//################## Factory Creator #####################//
class FactoryCreator
{
	static AbstractFactory getFactory(String factoryChoice)
	{
		if(factoryChoice.equalsIgnoreCase("Shape"))
		{
	         return new ShapeFactory2();
	         
	    }
		else if(factoryChoice.equalsIgnoreCase("Color"))
		{
	         return new ColorFactory();
	    }
	      
	    return null;
	}
}

//################## Main Class #####################//
public class AbstractFactoryPattern 
{
	public static void main(String[] args) 
	{
		AbstractFactory shapeFactory = FactoryCreator.getFactory("Shape");
		Shape2 rectangle = shapeFactory.getShape("Rectangle");
		rectangle.draw();
		Shape2 square = shapeFactory.getShape("Square");
		square.draw();
		
		AbstractFactory colorFactory = FactoryCreator.getFactory("Color");
		Color red = colorFactory.getColor("Red");
		red.fill();
		Color green = colorFactory.getColor("Green");
		green.fill();
		
	}
}