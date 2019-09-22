package com.ocean.programs.design.pattern.structural;

/** It is used so that two unrelated interfaces can work together. 
 * The object that joins these unrelated interface is called an Adapter.
 * Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.
 * 
 * Types:
 * 	 - Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.
 * 	 - Object Adapter – This form uses Java Composition and adapter contains the source object.
 * 
 * Mobile battery needs 3 volts to charge but the normal socket produces 
 * either 120V (US) or 240V (India). So the mobile charger works as an 
 * adapter between mobile charging socket and the wall socket.
 * 
 * Advantages:
 * 	- Helps achieve reusability and flexibility.
 * 	- Client class is not complicated by having to use a different interface and 
 *    can use polymorphism to swap between different implementations of adapters.
 *    
 * Disadvantages:
 * 	- All requests are forwarded, so there is a slight increase in the overhead.
 * 	- Sometimes many adaptations are required along an adapter chain to reach the type which is required.
 * **/
public class AdapterPattern 
{
	public static void main(String[] args) 
	{
		SocketAdapter12Object socketAdapter12Object = new SocketAdapter12Object();
		System.out.println("Socket Adapter Producing Volt: "+socketAdapter12Object.get120Volt());
		
		SocketAdapter12Class socketAdapter12Class = new SocketAdapter12Class();
		System.out.println("Socket Adapter Producing Volt: "+socketAdapter12Class.get120Volt());
	}
}

interface Socket120 
{
	int get120Volt();
}

class Socket120Impl implements Socket120
{
	@Override
	public int get120Volt() 
	{
		return 120;
	}
}

interface Socket12
{
	int get12Volt();
}

class Socket12Impl implements Socket12
{
	@Override
	public int get12Volt() 
	{
		return 12;
	}
}

class SocketAdapter12Object implements Socket120
{
	Socket12 socket12 = new Socket12Impl();

	@Override
	public int get120Volt() 
	{
		return socket12.get12Volt();
	}
}

class SocketAdapter12Class extends Socket12Impl implements Socket120
{
	@Override
	public int get120Volt() 
	{
		return get12Volt();
	}
}

