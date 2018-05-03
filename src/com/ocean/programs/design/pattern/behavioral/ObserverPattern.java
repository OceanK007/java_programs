package com.ocean.programs.design.pattern.behavioral;

import java.util.ArrayList;

/**
Observer pattern:

To understand observer pattern, first you need to understand the subject and observer objects.

The relation between subject and observer can easily be understood as an analogy to magazine subscription.

A magazine publisher(subject) is in the business and publishes magazines (data).
If you(user of data/observer) are interested in the magazine you subscribe(register), and if a new edition is published it gets delivered to you.
If you unsubscribe(unregister) you stop getting new editions.
Publisher doesn’t know who you are and how you use the magazine, it just delivers it to you because you are a subscriber(loose coupling).


Definition:

The Observer Pattern defines a one to many dependency between objects so that one object changes state, all of its dependents are notified and updated automatically.

Explanation:

One to many dependency is between Subject(One) and Observer(Many).
There is dependency as Observers themselves don’t have access to data. They are dependent on Subject to provide them data.

**/

public class ObserverPattern 
{
	public static void main(String[] args) 
	{
		AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
		
		CricketData cricketData = new CricketData();
		cricketData.registerObserver(averageScoreDisplay);
		cricketData.registerObserver(currentScoreDisplay);
		
		// In real app you will have to call this function when data changes
		System.out.println("------ Adding data: all observers will get notifications");
		cricketData.dataChanged(90, 2, 10.2F);
		System.out.println("------ Notifying all observers");
		cricketData.notifyObservers();
		
		System.out.println("------ Removing averageScoreDisplay observer");
		cricketData.unregisterObserver(averageScoreDisplay);
		
		System.out.println("------ Notifying all observers");
		cricketData.dataChanged(200, 5, 30);
	}
}

interface Observer 
{
	public void update(int runs, int wickets, float overs);
}

class CurrentScoreDisplay implements Observer
{
    public void update(int runs, int wickets, float overs)
    {
        System.out.println("\nCurrent Score Display:\n" + "Runs: " + runs + "\nWickets:" + wickets + "\nOvers: " + overs );
    }
}

class AverageScoreDisplay implements Observer
{
	@Override
	public void update(int runs, int wickets, float overs) 
	{
		float runRate = (float)runs/overs;
		int predictedScore = (int)(runRate * 50);
		
		System.out.println("Average Score Display: \n" + "Run Rate: " + runRate + "\nPredictedScore: " + predictedScore);
	}
}

interface Subject
{
	public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}

class CricketData implements Subject
{
	int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList = new ArrayList<>();		// One to many dependency is between Subject(One) and Observer(Many).

    @Override
	public void registerObserver(Observer o) 
	{
		observerList.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) 
	{
		 observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void notifyObservers() 
	{
		for(Observer observer : observerList)
		{
			observer.update(runs, wickets, overs);
		}
	}

	// This is just a method to change data (input)
	public void dataChanged(int runs, int wickets, float overs) 
	{
		this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		
		notifyObservers();
	}
}
