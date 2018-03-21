package com.ocean.programs.design.pattern.behavioral;

/**
Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances of the same class will not be affected by this, so individual object gets the modified behavior. 

Each component can be used on its own or may be wrapped by a decorator.
Each decorator has an instance variable that holds the reference to component it decorates(HAS-A relationship).
The ConcreteComponent is the object we are going to dynamically decorate.

Advantages:
The decorator pattern can be used to make it possible to extend (decorate) the functionality of a certain object at runtime.
The decorator pattern is an alternative to subclassing. Subclassing adds behavior at compile time, and the change affects all instances of the original class; decorating can provide new behavior at runtime for individual objects.
Decorator offers a pay-as-you-go approach to adding responsibilities. Instead of trying to support all foreseeable features in a complex, customizable class, you can define a simple class and add functionality incrementally with Decorator objects.

Disadvantages:
Decorators can complicate the process of instantiating the component because you not only have to instantiate the component, but wrap it in a number of decorators.
**/

public class DecoratorPattern 
{
	public static void main(String[] args) 
	{
		Pizza pizza = new PeppyPaneer();
		System.out.println(pizza.getDescription()+" Cost: "+pizza.getCost());
		
		Pizza pizza2 = new ChickenFiesta();
		pizza2 = new FreshTomatoTopping(pizza2); 
		pizza2 = new PaneerTopping(pizza2);
		
		System.out.println(pizza2.getDescription()+" Cost: "+pizza2.getCost());
	}
}

interface Pizza
{
	String getDescription();
	int getCost();
}

class PeppyPaneer implements Pizza
{
	@Override
	public String getDescription() 
	{
		return "PeppyPaneer";
	}

	@Override
	public int getCost() 
	{
		return 100;
	}
}

class ChickenFiesta implements Pizza
{
	@Override
	public String getDescription() 
	{
		return "ChickenFiesta";
	}

	@Override
	public int getCost() 
	{
		return 200;
	}
}

interface ToppingDecorator extends Pizza
{
	String getDescription();
}

class FreshTomatoTopping implements ToppingDecorator
{
	Pizza pizza;
	
	public FreshTomatoTopping(Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() 
	{
		return "FreshTomatorTopping Decorator";
	}

	@Override
	public int getCost() 
	{
		return 50+pizza.getCost();
	}
}

class PaneerTopping implements ToppingDecorator
{
	Pizza pizza;
	
	public PaneerTopping(Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() 
	{
		return "PaneerTopping Decorator";
	}

	@Override
	public int getCost() 
	{
		return 70+pizza.getCost();
	}
}