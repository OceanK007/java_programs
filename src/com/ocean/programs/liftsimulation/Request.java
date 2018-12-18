package com.ocean.programs.liftsimulation;

public class Request {
	private Integer fromFloorNo;
	private Integer toFloorNo;
	private Integer liftNo;
	private Direction direction;
	private RequestedFrom requestedFrom;
	
	public Integer getFromFloorNo() {
		return fromFloorNo;
	}
	public void setFromFloorNo(Integer fromFloorNo) {
		this.fromFloorNo = fromFloorNo;
	}
	public Integer getToFloorNo() {
		return toFloorNo;
	}
	public void setToFloorNo(Integer toFloorNo) {
		this.toFloorNo = toFloorNo;
	}
	public Integer getLiftNo() {
		return liftNo;
	}
	public void setLiftNo(Integer liftNo) {
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
