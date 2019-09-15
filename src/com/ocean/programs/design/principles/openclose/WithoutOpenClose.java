package com.ocean.programs.design.principles.openclose;

import java.util.List;
import java.util.stream.Stream;

public class WithoutOpenClose
{	
	public static void main(String[] args) 
	{
		Product2 apple = new Product2("Apple", Color2.GREEN, Size2.SMALL);
		Product2 tree = new Product2("Tree", Color2.GREEN, Size2.LARGE);
		Product2 house = new Product2("House", Color2.BLUE, Size2.LARGE);
		
		List<Product2> Product2s = List.of(apple, tree, house);
		
		Product2Filter pf = new Product2Filter();
		System.out.println("Green Product2s: ");
		pf.filterByColor2(Product2s, Color2.GREEN).forEach(p -> System.out.println(" - "+p.name +" is green"));
	}
}

enum Color2
{
	RED, GREEN, BLUE
}

enum Size2
{
	SMALL, MEDIUM, LARGE, HUGE
}

class Product2
{
	public String name;
	public Color2 Color2;
	public Size2 Size2;
	
	public Product2(String name, Color2 Color2, Size2 Size2) 
	{
		this.name = name;
		this.Color2 = Color2;
		this.Size2 = Size2;
	}
}

// Now if you have to make one more filter for newly added property then have to change it
class Product2Filter
{
	public Stream<Product2> filterByColor2(List<Product2> Product2s, Color2 Color2)
	{
		return Product2s.stream().filter(p -> p.Color2 == Color2);
	}
	
	public Stream<Product2> filterBySize2(List<Product2> Product2s, Size2 Size2)
	{
		return Product2s.stream().filter(p -> p.Size2 == Size2);
	}
	
	public Stream<Product2> filterBySize2AndColor2(List<Product2> Product2s, Size2 Size2, Color2 Color2)
	{
		return Product2s.stream().filter(p -> p.Size2 == Size2 && p.Color2 == Color2);
	}
}
