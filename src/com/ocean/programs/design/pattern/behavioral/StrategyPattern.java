package com.ocean.programs.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/** Strategy pattern is used when we have multiple algorithm for a specific task and client 
 * decides the actual implementation to be used at runtime.
 * 
 * One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter. 
 * Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.
 * 
 * In real life, user has many options for payments like paypal or creditcard.
 * **/
public class StrategyPattern 
{
	public static void main(String[] args) 
	{
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		
		//pay by credit card
		cart.pay(new CreditCardStrategy("OceanLife", "1234567890123456", "123", "12/20"));
	}
}

interface PaymentStrategy 
{
	public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy 
{
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate)
	{
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	
	@Override
	public void pay(int amount) 
	{
		System.out.println(amount +" paid with credit/debit card");
	}
}

class PaypalStrategy implements PaymentStrategy 
{
	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd)
	{
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public void pay(int amount) 
	{
		System.out.println(amount + " paid using Paypal.");
	}
}

class Item 
{
	private String itemCode;
	private int price;
	
	public Item(String itemCode, int price) 
	{
		this.itemCode = itemCode;
		this.price = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getPrice() {
		return price;
	}
}

class ShoppingCart 
{
	List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	public void removeItem(Item item)
	{
		this.items.remove(item);
	}
	
	public void pay(PaymentStrategy paymentMethod)
	{
		int totalAmount = 0;
		for(Item item : items)
		{
			totalAmount += item.getPrice();
		}
		paymentMethod.pay(totalAmount);
	}
}