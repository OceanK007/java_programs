package com.ocean.programs.design.pattern.behavioral;

/**
	It's used to define a template as skeleton and leaves the details to be implemented by child classes.
	This pattern is used when you have a common behavior and you implement it in parent class and made it final so child classes can't override it.
	But you keep the dynamic behavior to be implemented by child classes.
	
	It helps to avoid code duplication.
**/
public class TemplateDesignPattern 
{
	public static void main(String[] args) 
	{
		OrderProcessTemplate netOrder = new NetOrder(); 
        netOrder.processOrder(true); 
        System.out.println(); 
        OrderProcessTemplate storeOrder = new StoreOrder(); 
        storeOrder.processOrder(true); 
	}
}

abstract class OrderProcessTemplate 
{ 
    public boolean isGift; 
  
    public abstract void doSelect(); 
  
    public abstract void doPayment(); 
  
    public final void giftWrap() 
    { 
        try
        { 
            System.out.println("Gift wrap successfully"); 
        } 
        catch (Exception e) 
        { 
            System.out.println("Gift wrap unsuccessfully"); 
        } 
    } 
  
    public abstract void doDelivery(); 
  
    public final void processOrder(boolean isGift) 
    { 
        doSelect(); 
        doPayment(); 
        if (isGift) { 
            giftWrap(); 
        } 
        doDelivery(); 
    } 
} 
  
  
class NetOrder extends OrderProcessTemplate 
{ 
    @Override
    public void doSelect() 
    { 
        System.out.println("Item added to online shopping cart"); 
        System.out.println("Get gift wrap preference"); 
        System.out.println("Get delivery address."); 
    } 
  
    @Override
    public void doPayment() 
    { 
        System.out.println("Online Payment through Netbanking, card or Paytm"); 
    } 
  
    @Override
    public void doDelivery() 
    { 
        System.out.println("Ship the item through post to delivery address"); 
    } 
  
} 
  
class StoreOrder extends OrderProcessTemplate 
{ 
  
    @Override
    public void doSelect() 
    { 
        System.out.println("Customer chooses the item from shelf."); 
    } 
  
    @Override
    public void doPayment() 
    { 
        System.out.println("Pays at counter through cash/POS"); 
    } 
  
    @Override
    public void doDelivery() 
    { 
        System.out.println("Item deliverd to in delivery counter."); 
    } 
  
} 
