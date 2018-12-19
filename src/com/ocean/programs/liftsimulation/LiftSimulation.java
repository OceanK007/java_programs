package com.ocean.programs.liftsimulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		
//		System.out.println("Request format (From lift lobby):");
//		System.out.println("\t OUT, (UP/DOWN), CurrentFloor");
//		System.out.println("\t Example: OUT, UP, 4");
//		System.out.println("Request format (From inside lift):");
//		System.out.println("\t IN, LiftNumber, DestinationFloor");
//		System.out.println("\t Example: IN, 1, 10");
//		System.out.println("");
		
		//System.out.println("Type EXIT to exit sending request");
		// Skipping next line
		//scanner.nextLine();
				
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
			//System.out.print("Enter request: ");			
			//String requestString = scanner.nextLine().trim();
			
			String requestString = JOptionPane.showInputDialog
			("Request format (From lift lobby): OUT, (UP/DOWN), CurrentFloor\n" +
			 "\t Example: OUT, UP, 4 \n\n"+
			 "\t Request format (From inside lift): IN, LiftNumber, DestinationFloor\n"+ 
			 "\t Example: IN, 1, 10 \n\n"+
					"Enter request: "
			);
			if(requestString == null || requestString.equals(""))
			{
				System.out.println("Thank you for using lift simulator.");
				executorService.shutdown();
				break;
			}
			else 
			{
				System.out.println(requestString);
				String[] stringArray = requestString.trim().split(",");
				
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
	
	
//	public static String showInputDialog() {
//		// a jframe here isn't strictly necessary, but it makes the example a little more real
//	    JFrame frame = new JFrame("InputDialog Example #1");
//	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//	    // prompt the user to enter their name
//	    String requestString = JOptionPane.showInputDialog(frame, "Send request");
//
//	    // get the user's input. note that if they press Cancel, 'name' will be null
//	    System.out.print("Request is: "+ requestString);
//	    
//	    return requestString;
//	}
}

class CheckRequests implements Callable<List<Request>>
{
	List<Request> requestList;
	Building building;
	ExecutorService executorService = null; // Creating thread pool 
	List<Future<Integer>> futureList = new ArrayList<>();
	Map<Integer, Lift> liftMap = new TreeMap<>();	// Key: liftNo, Value: Lift
	Direction directionFromLiftLobby = Direction.UP;
	Integer currentFloorFromLiftLobby;
	
	CheckRequests(List<Request> requestList, Building building)
	{
		this.requestList = requestList;
		this.building = building;
		
		if(executorService == null)
		{
			executorService = Executors.newFixedThreadPool(building.getTotalLifts());
		}
	}
	
	@Override
	public List<Request> call() throws Exception 
	{
		while(true) 
		{
			if(requestList.size() == 0)
			{
				Thread.sleep(1000);
			}
			else
			{
				//System.out.println("requestList.size(): "+requestList.size());
				
				Iterator<Request> itr = requestList.iterator();
				while(itr.hasNext())
				{
					Request req = itr.next();
					processRequest(req);
					itr.remove();
				}
			}
		}
	}	
	
	public void processRequest(Request request) 
	{
		if(request.getLiftNo() == null)	// Request received from lift lobby
		{
			System.out.println("From Lift Lobby");
			directionFromLiftLobby = request.getDirection();	
			currentFloorFromLiftLobby = request.getFromFloorNo();
			System.out.println("Request received from floor: "+currentFloorFromLiftLobby+" for direction: "+directionFromLiftLobby.toString());
		}
		else // Request received from inside lift
		{
			System.out.println("From Inside Lift");
			
			// START: Setting Lift parameters //
			Map<Integer, Request> reqMap = new TreeMap<Integer, Request>();
			reqMap.put(request.getToFloorNo(), request);
			
			Lift lift = new Lift();			
			lift.setLiftNo(request.getLiftNo());
			lift.setFinalFloor(request.getToFloorNo());
			lift.setCurrentFloor(currentFloorFromLiftLobby);
			lift.setDirection(directionFromLiftLobby);
			lift.setRequestMap(reqMap);
			// END: Setting Lift parameters //
			
			if(liftMap.containsKey(request.getLiftNo())) 
			{
				Lift currentLift = liftMap.get(request.getLiftNo());
				Map<Integer,Request> requestMap = currentLift.getRequestMap();
				Integer newFloorRequested = request.getToFloorNo();
				
				if(directionFromLiftLobby.equals(Direction.UP))
				{
					if(currentLift.getCurrentFloor() <= newFloorRequested)
					{
						if(newFloorRequested > currentLift.getFinalFloor())
						{
							currentLift.setFinalFloor(newFloorRequested);
						}
						requestMap.put(request.getToFloorNo(), request);
					}
				}
				else
				{
					if(currentLift.getCurrentFloor() >= newFloorRequested)
					{
						if(newFloorRequested < currentLift.getFinalFloor())
						{
							currentLift.setFinalFloor(newFloorRequested);
						}
						requestMap.put(request.getToFloorNo(), request);
					}
				}
				
								
				//for(Future<Integer> futureElement : futureList) 
				//{
				//	System.out.println(futureElement);
				//}
			}
			else
			{
				liftMap.put(request.getLiftNo(), lift);
				Future<Integer> future = executorService.submit(new LiftThread(request.getLiftNo(), liftMap));
				futureList.add(future);
			}
		}
	}
}

class LiftThread implements Callable<Integer>
{
	private Integer liftNo;
	private Map<Integer, Lift> liftMap;
	
	public LiftThread(Integer liftNo, Map<Integer, Lift> liftMap) {
		this.liftNo = liftNo;
		this.liftMap = liftMap;
	}
	
	@Override
	public Integer call() throws Exception 
	{
		if(liftMap.containsKey(liftNo))
		{
			Lift lift = liftMap.get(liftNo);
			Map<Integer,Request> requestMap = lift.getRequestMap();
			
			//System.out.println("lift.getFinalFloor(): "+lift.getFinalFloor());
			//System.out.println("lift.getCurrentFloor(): "+lift.getCurrentFloor());
				
			while(true) 
			{
				//System.out.println("lift.getCurrentFloor(): "+lift.getCurrentFloor());
				//System.out.println("lift.getFinalFloor(): "+lift.getFinalFloor());
				
				if(lift.getCurrentFloor().equals(lift.getFinalFloor()))
				{
					requestMap.clear();
					liftMap.remove(liftNo);
					break;
				}
				
				for(int i=lift.getCurrentFloor();i<=lift.getFinalFloor();i++)
				{
					lift.setCurrentFloor(i);
					
					//System.out.println("Size: "+requestMap.size());
					
					Thread.sleep(2000); 	// 10 seconds to cross each floor
					
					if(requestMap.containsKey(new Integer(i)))	// Means have a request for this floor
					{
						Request request = requestMap.get(new Integer(i));
						System.out.println("Lift "+liftNo+" stopped on "+(i)+" floor to serve request ("+request.getRequestedFrom()+","+liftNo+","+request.getToFloorNo()+")");
						Thread.sleep(2000); 	// 20 seconds to serve the floor request
					}
					else
					{						
						System.out.println("Lift "+liftNo+" crossed floor: "+(i));
					}		
					
				}				
			}
						
			//System.out.println("Size: "+requestMap.size());
		}
		
		//System.out.println("Inside call(): "+Thread.currentThread().getName());
		return liftNo;
	}	
}
