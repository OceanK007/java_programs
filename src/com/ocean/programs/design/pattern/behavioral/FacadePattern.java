package com.ocean.programs.design.pattern.behavioral;

/**
Facade is a part of Gang of Four design pattern and it is categorized under Structural design patterns.

As the name suggests, it means the face of the building. The people walking past the road can only see this glass face of the building. 
They do not know anything about it, the wiring, the pipes and other complexities. It hides all the complexities of the building and displays a friendly face.

n Java, the interface JDBC can be called a facade because, we as users or clients create connection using the “java.sql.Connection” interface, the implementation of which we are not concerned about. The implementation is left to the vendor of driver.

Another good example can be the startup of a computer. When a computer starts up, it involves the work of cpu, memory, hard drive, etc. 
To make it easy to use for users, we can add a facade which wrap the complexity of the task, and provide one simple interface instead.

Same goes for the Facade Design Pattern. It hides the complexities of the system and provides an interface to the client from where the client can access the system.


When Should this pattern be used?
The facade pattern is appropriate when you have a complex system that you want to expose to clients in a simplified way, 
or you want to make an external communication layer over an existing system which is incompatible with the system. 
Facade deals with interfaces, not implementation. Its purpose is to hide internal complexity behind a single interface that appears simple on the outside.
**/
public class FacadePattern 
{
	public static void main(String[] args) 
	{
		HotelKeeper hotelKeeper = new HotelKeeper();
		
		VegMenu vegMenu = hotelKeeper.getVegMenu();
		NonVegMenu nonVegMenu = hotelKeeper.getNonVegMenu();
		VegNonVegMenu vegNonVegMenu = hotelKeeper.getVegNonVegMenu();
	}
}

class Menu
{
	
}

class VegMenu extends Menu
{
	
}

class NonVegMenu extends Menu
{
	
}

class VegNonVegMenu extends Menu
{
	
}

interface Hotel 
{
	public Menu getMenu();
}

class NonVegRestaurant implements Hotel
{
	@Override
	public Menu getMenu()
	{
		System.out.println("Non Veg Menu");
		return new NonVegMenu();
	}
}

class VegRestaurant implements Hotel
{
	@Override
	public Menu getMenu()
	{
		System.out.println("Veg Menu");
		return new VegMenu();
	}
}

class VegNonVegRestaurant implements Hotel
{
	@Override
	public Menu getMenu()
	{
		System.out.println("Veg Non Veg Menu");
		return new VegNonVegMenu();
	}
}

class HotelKeeper	// It will hide the complexity
{
	public VegMenu getVegMenu()
	{
		VegRestaurant vr = new VegRestaurant();
		VegMenu vmenu = (VegMenu) vr.getMenu();
		return vmenu;
	}
	
	public NonVegMenu getNonVegMenu()
	{
		NonVegRestaurant nvr = new NonVegRestaurant();
		NonVegMenu nonVegMenu = (NonVegMenu) nvr.getMenu();
		return nonVegMenu;
	}
	
	public VegNonVegMenu getVegNonVegMenu()
	{
		VegNonVegRestaurant vnvr = new VegNonVegRestaurant();
		VegNonVegMenu vegNonVegMenu = (VegNonVegMenu) vnvr.getMenu();
		return vegNonVegMenu;
	}
}