package entities;

import java.util.Date;
import java.util.List;

public class TourEntity {
	String personId;
	String tourId;
	String origin;
	String destination;
	Date tourStartDate;
	Date tourEndDate;
	String typeOfLocation;

	List<JourneyDetailsEntity> journeyDetails;
	List<ResortEntity> resort;
	List<ActivityEntity> activities;
	List<ConnectionEntity> connections;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getTourId() {
		return tourId;
	}

	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTourStartDate() {
		return tourStartDate;
	}

	public void setTourStartDate(Date tourStartDate) {
		this.tourStartDate = tourStartDate;
	}

	public Date getTourEndDate() {
		return tourEndDate;
	}

	public void setTourEndDate(Date tourEndDate) {
		this.tourEndDate = tourEndDate;
	}

	public String getTypeOfLocation() {
		return this.typeOfLocation;
	}

	public void setTypeOfLocation(String typeOfLocation) {
		this.typeOfLocation = typeOfLocation;
	}

	public List<JourneyDetailsEntity> getJourneyDetails() {
		return journeyDetails;
	}

	public void setJourneyDetails(List<JourneyDetailsEntity> journeyDetails) {
		this.journeyDetails = journeyDetails;
	}

	public List<ResortEntity> getResort() {
		return resort;
	}

	public void setResort(List<ResortEntity> resort) {
		this.resort = resort;
	}

	public List<ActivityEntity> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityEntity> activities) {
		this.activities = activities;
	}

	public List<ConnectionEntity> getConnections() {
		return connections;
	}

	public void setConnections(List<ConnectionEntity> connections) {
		this.connections = connections;
	}
}
