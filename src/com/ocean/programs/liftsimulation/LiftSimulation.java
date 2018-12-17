package com.ocean.programs.liftsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The objective of this exercise is to create a lift simulation program, ideal solution will be capable of working with multiple lifts, however the solution should support at least two lifts.
 * 
 * The central part of this problem should be an engine which will take the user requests and process them. The lift engine should listen to console for reading the requests. There will be two types of requests.
 * 
 * 		- One which user within the lift enters. This is the request which has to be taken by the same lift. The format of this request would be:
 * 				IN,1,10
 * 		  Where
 * 			- IN indicates that the request is coming from inside
 * 			- 1 is LIFT number, so this request should be processed by first lift.
 * 			- 10 is the floor number user wants to go to
 * 
 * 		- The other is the one which is entered by the user waiting in the lift lobby. This can be taken by any lift
 * 				OUT,UP,4
 * 		  Where
 * 			- OUT indicates that user is outside the lift.
 * 			- UP indicates that user wants to go up.
 * 			- 4 indicates that user on the 4th floor.
 *  
 *  Number of floors that lift needs to cover and number of lifts should be provided to program as command line arguments.
 *  
 *  Lifts need to move up/down to process the requests. Output of the program will be the pattern in which lifts serve the requests. Output should be displayed on the console.
 *  
 *  There should be a line on the console as lift crosses a floor. Something like: Lift 1 crossed 4th floor.
 *  
 *  There should be a line non the console as lift stops on a floor to process a request. Something like: Lift 1 stopped on 4th floor to serve request (OUT,UP,4).
 *  
 *  We are assuming that a lift moves with uniform speed (no acceleration) and it takes 10 secs to cross a floor and additional 20 secs if it has to stop on that floor.
 *  
 *  The solution should be accompanied by a status-cum-design document and you need to provide full coverage for JUints.
 *  
**/

public class LiftSimulation 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter no. of floors: ");
		int noOfFloors = scanner.nextInt();
		System.out.print("Enter no. of lifts: ");
		int noOfLifts = scanner.nextInt();
				
		System.out.println("**********************************************************");
		System.out.println("You are in a "+noOfFloors+" storied building with having "+noOfLifts+" elevators");
		System.out.println("**********************************************************");
		
		System.out.println("Request format (From lift lobby):");
		System.out.println("\t OUT, (UP/DOWN), CurrentFloor");
		System.out.println("\t Example: OUT, UP, 4");
		System.out.println("Request format (From inside lift):");
		System.out.println("\t IN, LiftNumber, DestinationFloor");
		System.out.println("\t Example: IN, 1, 10");
		System.out.println("");
		
		System.out.println("Type EXIT to exit sending request");
		// Skipping next line
		scanner.nextLine();
				
		Building building = new Building();
		building.setTotalFloors(noOfFloors);
		building.setTotalLifts(noOfLifts);
		
		// Request Array
		List<Request> requestList = new LinkedList<Request>();
		
		// Creating a thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(new CheckRequests(requestList, building));
		
		while(true) 
		{
			System.out.print("Enter request: ");
			
			String requestString = scanner.nextLine().trim();
			if(requestString.equalsIgnoreCase("exit"))
			{
				System.out.println("Thank you for using lift simulator.");
				executorService.shutdown();
				break;
			}
			else 
			{
				System.out.println(requestString);
				String[] stringArray = requestString.split(",");
				
				Request request = new Request();		
				
				String requestedFrom = stringArray[0].trim();
				
				//System.out.println("type:"+stringArray[2].getClass().getName());
				
				if(requestedFrom.equalsIgnoreCase("out")) 
				{
					request.setRequestedFrom(RequestedFrom.OUT);
					request.setDirection(stringArray[1].trim().equalsIgnoreCase("up") ? Direction.UP : Direction.DOWN);
					request.setFromFloorNo(Integer.parseInt(stringArray[2].trim()));
				}
				else 
				{
					request.setRequestedFrom(RequestedFrom.IN);
					request.setLiftNo(Integer.parseInt(stringArray[1].trim()));
					request.setToFloorNo(Integer.parseInt(stringArray[2].trim()));
				}
				
				//System.out.println(request);
				requestList.add(request);
								
//				ServeRequest serveRequest = new ServeRequest(request);
//				Future<Request> future = executorService.submit(serveRequest);
//				futureList.add(future);
			}
		}
	}	
}

class CheckRequests implements Callable<List<Request>>
{
	List<Request> requestList;
	Building building;
	
	CheckRequests(List<Request> requestList, Building building)
	{
		this.requestList = requestList;
		this.building = building;
	}
	
	@Override
	public List<Request> call() throws Exception 
	{
		// Creating thread pool 
		ExecutorService executorService = Executors.newFixedThreadPool(building.getTotalLifts());
		List<Future<Request>> futureList = new ArrayList<>();
		
		while(true) 
		{
			if(requestList.size() == 0)
			{
				Thread.sleep(1000);
			}
			else
			{
				System.out.println("requestList.size(): "+requestList.size());
				Thread.sleep(5000);
			}
		}
	}	
}

class ServeRequest implements Callable<Request>
{
	private Request request;
	
	public ServeRequest(Request request) {
		this.request = request;
	}
	
	@Override
	public Request call() throws Exception 
	{
		Thread.sleep(1000);
		System.out.println("Inside call(): "+Thread.currentThread().getName());
		return null;
	}	
}
