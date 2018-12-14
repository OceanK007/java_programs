package com.ocean.programs.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;

/** 
Proxy means ‘in place of’, representing’ or ‘in place of’ or ‘on behalf of’ are literal meanings of proxy and that directly explains Proxy Design Pattern.
Proxies are also called surrogates, handles, and wrappers.

A real world example can be a cheque or credit card is a proxy for what is in our bank account. It can be used in place of cash, and provides a means of accessing that cash when required. 
And that’s exactly what the Proxy pattern does – “Controls and manage access to the object they are protecting“.

Benefits:
One of the advantages of Proxy pattern is security.
This pattern avoids duplication of objects which might be huge size and memory intensive. This in turn increases the performance of the application.
The remote proxy also ensures about security by installing the local code proxy (stub) in the client machine and then accessing the server with help of the remote code.


Drawbacks/Consequences:
This pattern introduces another layer of abstraction which sometimes may be an issue if the RealSubject code is accessed by some of the clients directly and some of them might access the Proxy classes. This might cause disparate behaviour.
**/
public class ProxyPattern 
{
	public static void main(String[] args) throws Exception 
	{
		Internet internet = new ProxyInternet();
		internet.connectTo("geeksforgeeks.org");
		internet.connectTo("abc.com");
	}
}

interface Internet
{
	public void connectTo(String serverHost) throws Exception;
}

class RealInternet implements Internet
{
	@Override
	public void connectTo(String serverHost) throws Exception
	{
		System.out.println("Connecting to: "+serverHost);
	}
}

class ProxyInternet implements Internet
{
	private Internet internet = new RealInternet();
	private static List<String> bannedSites;
	
	static
	{
		bannedSites = new ArrayList<>();
		bannedSites.add("abc.com");
		bannedSites.add("ijk.com");
		bannedSites.add("def.com");
		bannedSites.add("xyz.com");
	}
	
	@Override
	public void connectTo(String serverHost) throws Exception 
	{
		if(bannedSites.contains(serverHost.toLowerCase()))
		{
			throw new Exception("Access Denied");
		}
		
		internet.connectTo(serverHost);
	}
}


//class ProxyInternet extends RealInternet
//{
//	private static List<String> bannedSites;
//	
//	static
//	{
//		bannedSites = new ArrayList<>();
//		bannedSites.add("abc.com");
//		bannedSites.add("ijk.com");
//		bannedSites.add("def.com");
//		bannedSites.add("xyz.com");
//	}
//	
//	@Override
//	public void connectTo(String serverHost) throws Exception
//	{
//		if(bannedSites.contains(serverHost.toLowerCase()))
//		{
//			throw new Exception("Access Denied");
//		}
//		
//		super.connectTo(serverHost);
//	}
//}