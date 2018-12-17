package com.ocean.programs.liftsimulation;

public class Request {
	private int fromFloorNo;
	private int toFloorNo;
	private int liftNo;
	private Direction direction;
	private RequestedFrom requestedFrom;
	
	public int getFromFloorNo() {
		return fromFloorNo;
	}
	public void setFromFloorNo(int fromFloorNo) {
		this.fromFloorNo = fromFloorNo;
	}
	public int getToFloorNo() {
		return toFloorNo;
	}
	public void setToFloorNo(int toFloorNo) {
		this.toFloorNo = toFloorNo;
	}
	public int getLiftNo() {
		return liftNo;
	}
	public void setLiftNo(int liftNo) {
		this.liftNo = liftNo;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public RequestedFrom getRequestedFrom() {
		return requestedFrom;
	}
	public void setRequestedFrom(RequestedFrom requestedFrom) {
		this.requestedFrom = requestedFrom;
	}
	@Override
	public String toString() {
		return "Request [fromFloorNo=" + fromFloorNo + ", toFloorNo=" + toFloorNo + ", liftNo=" + liftNo
				+ ", direction=" + direction + ", requestedFrom=" + requestedFrom + "]";
	}
}
