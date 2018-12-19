package com.ocean.programs.liftsimulation;

import java.util.Map;

public class Lift {
	private Integer liftNo;
	private Integer fromFloor;
	private Integer toFloor;
	private Integer currentFloor = 1;
	private Integer finalFloor;
	private Map<Integer, Request> requestMap;	// key: floorNo, value: Request object
	private boolean isServing;
	private Direction direction;
	
	public Integer getLiftNo() {
		return liftNo;
	}
	public void setLiftNo(Integer liftNo) {
		this.liftNo = liftNo;
	}
	public Integer getFromFloor() {
		return fromFloor;
	}
	public void setFromFloor(Integer fromFloor) {
		this.fromFloor = fromFloor;
	}
	public Integer getToFloor() {
		return toFloor;
	}
	public void setToFloor(Integer toFloor) {
		this.toFloor = toFloor;
	}
	public Integer getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}
	public Integer getFinalFloor() {
		return finalFloor;
	}
	public void setFinalFloor(Integer finalFloor) {
		this.finalFloor = finalFloor;
	}
	public Map<Integer, Request> getRequestMap() {
		return requestMap;
	}
	public void setRequestMap(Map<Integer, Request> requestMap) {
		this.requestMap = requestMap;
	}
	public boolean isServing() {
		return isServing;
	}
	public void setServing(boolean isServing) {
		this.isServing = isServing;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
