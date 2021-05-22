package entities;

import java.util.Date;

public class RoomEntity {
	private String roomId;
	private String resortId;
	private Date roomFromDate;
	private Date roomToDate;
	private String roomType;
	private Integer costPerDay;
	private long totalCost;
	private long noOfNights;
	private String roomNo;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getResortId() {
		return resortId;
	}

	public void setResortId(String resortId) {
		this.resortId = resortId;
	}

	public Date getRoomFromDate() {
		return roomFromDate;
	}

	public void setRoomFromDate(Date roomFromDate) {
		this.roomFromDate = roomFromDate;
	}

	public Date getRoomToDate() {
		return roomToDate;
	}

	public void setRoomToDate(Date roomToDate) {
		this.roomToDate = roomToDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(Integer costPerDay) {
		this.costPerDay = costPerDay;
	}

	public long getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public long getNoOfNights() {
		return this.noOfNights;
	}

	public void setNoOfNights(long noOfNights) {
		this.noOfNights = noOfNights;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

}
