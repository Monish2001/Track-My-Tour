package entities;

import java.util.Date;
import java.util.List;

public class ResortEntity {
	private String tourid;
	private String resortId;
	private Date fromDate;
	private Date toDate;
	private String resortName;
	private String resortLocation;
	private List<RoomEntity> room;

	public String getTourid() {
		return tourid;
	}

	public void setTourid(String tourid) {
		this.tourid = tourid;
	}

	public String getResortId() {
		return resortId;
	}

	public void setResortId(String resortId) {
		this.resortId = resortId;
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

	public List<RoomEntity> getRoom() {
		return room;
	}

	public void setRoom(List<RoomEntity> room) {
		this.room = room;
	}
}
