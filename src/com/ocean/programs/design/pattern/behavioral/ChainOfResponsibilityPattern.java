package com.ocean.programs.design.pattern.behavioral;

/** 
Chain of responsibility pattern is used to achieve loose coupling in 
software design where a request from client is passed to a chain of objects 
to process them. Later, the object in the chain will decide themselves who 
will be processing the request and whether the request is required to be 
sent to the next object in the chain or not.

This pattern is recommended when multiple objects can handle a request and 
the handler doesn’t have to be a specific object. Also, handler is determined at runtime. 
Please note that that a request not handled at all by any handler is a valid use case.

Where and When Chain of Responsibility pattern is applicable :

> When you want to decouple a request’s sender and receiver
> Multiple objects, determined at runtime, are candidates to handle a request
> When you don’t want to specify handlers explicitly in your code
> When you want to issue a request to one of several objects without specifying the receiver explicitly.
**/
public class ChainOfResponsibilityPattern 
{
	public static void main(String[] args) 
	{
        //configure Chain of Responsibility
        Chain c1 = new NegativeProcessor();
        Chain c2 = new ZeroProcessor();
        Chain c3 = new PositiveProcessor();
        c1.setNext(c2);
        c2.setNext(c3);
 
        //calling chain of responsibility
        c1.process(90);
        c1.process(-50);
        c1.process(0);
        c1.process(91);
    }
}

interface Chain
{
    public abstract void setNext(Chain nextInChain);
    public abstract void process(Integer request);
}
  
class NegativeProcessor implements Chain
{
    private Chain nextInChain;
 
    public void setNext(Chain c)
    {
        nextInChain = c;
    }
 
    public void process(Integer request)
    {
        if (request.intValue() < 0)
        {
            System.out.println("NegativeProcessor : " + request.intValue());
        }
        else
        {
            nextInChain.process(request);
        }
    }
}
 
class ZeroProcessor implements Chain
{
    private Chain nextInChain;
 
    public void setNext(Chain c)
    {
        nextInChain = c;
    }
 
    public void process(Integer request)
    {
        if (request.intValue() == 0)
        {
            System.out.println("ZeroProcessor : " + request.intValue());
        }
        else
        {
            nextInChain.process(request);
        }
    }
}
 
class PositiveProcessor implements Chain
{
    private Chain nextInChain;
 
    public void setNext(Chain c)
    {
        nextInChain = c;
    }
 
    public void process(Integer request)
    {
        if (request.intValue() > 0)
        {
            System.out.println("PositiveProcessor : " + request.intValue());
        }
        else
        {
            nextInChain.process(request);
        }
    }
}