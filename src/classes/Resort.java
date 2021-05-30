package classes;

import java.util.Date;
import java.util.List;

public class Resort {
	private String tourid;
	private String tourCode;
	private String resortId;
	private String resortCode;
	private Date fromDate;
	private Date toDate;
	private String resortName;
	private String resortLocation;
	private List<Room> room;

	public String getTourid() {
		return tourid;
	}

	public void setTourid(String tourid) {
		this.tourid = tourid;
	}

	public String getTourCode() {
		return this.tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}

	public String getResortId() {
		return resortId;
	}

	public void setResortId(String resortId) {
		this.resortId = resortId;
	}

	public String getResortCode() {
		return this.resortCode;
	}

	public void setResortCode(String resortCode) {
		this.resortCode = resortCode;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getResortName() {
		return resortName;
	}

	public void setResortName(String resortName) {
		this.resortName = resortName;
	}

	public String getResortLocation() {
		return resortLocation;
	}

	public void setResortLocation(String resortLocation) {
		this.resortLocation = resortLocation;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Integer totalCostOfStay(Resort resortEntity) {
		Integer costForStay = 0;
		for (int room = 0; room < resortEntity.getRoom().size(); room++) {
			Room roomEntity = resortEntity.getRoom().get(room);
			costForStay += roomEntity.getTotalCost();
		}
		return costForStay;
	}

	public Integer totalCostOfRoom(Room room) {
		Integer totalCost = room.getCostPerDay() * room.getNoOfNights();
		return totalCost;
	}
}
