package classes;

import java.util.Date;
import java.util.List;

public class Tour {
	String personId;
	String tourId;
	String origin;
	String destination;
	Date tourStartDate;
	Date tourEndDate;
	String typeOfLocation;

	List<JourneyDetails> journeyDetails;
	List<Resort> resort;
	List<Activity> activities;
	List<Connection> connections;

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

	public List<JourneyDetails> getJourneyDetails() {
		return journeyDetails;
	}

	public void setJourneyDetails(List<JourneyDetails> journeyDetails) {
		this.journeyDetails = journeyDetails;
	}

	public List<Resort> getResort() {
		return resort;
	}

	public void setResort(List<Resort> resort) {
		this.resort = resort;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}
}
