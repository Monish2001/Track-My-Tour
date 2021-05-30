package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.PersonNameFinder;

public class Tour {
	String personId;
	String tourId;
	String tourCode;
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

	public String getTourCode() {
		return this.tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
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

	public Integer costOfTourStay(Tour tour) {
		Integer costForTripStay = 0;
		Resort resortObj = new Resort();
		List<Resort> resortList = tour.getResort();
		int resortListSize = resortList.size();
		if (resortListSize == 0) {
			System.out.println("There is no resort entries in this tour!!");
			return costForTripStay;
		} else {
			for (int resort = 0; resort < resortListSize; resort++) {
				costForTripStay += resortObj.totalCostOfStay(resortList.get(resort));
			}
		}
		return costForTripStay;
	}

	public Integer costOfTourActivities(Tour tour) {
		Integer totalActivityCost = 0;
		List<Activity> activitiesList = tour.getActivities();
		int activitiesListSize = activitiesList.size();
		if (activitiesListSize == 0) {
			System.out.println("There is no activities made in this tour!!");
			return totalActivityCost;
		} else {
			for (int activities = 0; activities < tour.getActivities().size(); activities++) {
				Activity activity = activitiesList.get(activities);
				totalActivityCost += activity.getCost();
			}
		}
		return totalActivityCost;
	}

	public Integer totalCostOfTour(Tour tour) {
		Tour currentClassObj = new Tour();
		Integer totalCost = 0;
		totalCost += currentClassObj.costOfTourActivities(tour);
		totalCost += currentClassObj.costOfTourStay(tour);
		return totalCost;
	}

	PersonNameFinder personNameFinder = new PersonNameFinder();

	public List<String> directConnectionOfTour(Tour tour, List<Person> personList) {
		List<String> connectionNameList = new ArrayList<String>();
		if (tour.getConnections().size() == 0) {
			System.out.println("No connections made in this tour!!");
			return connectionNameList;
		} else {
			String personId = tour.getConnections().get(0).getPersonId();
			String personName = personNameFinder.getPersonName(personId, personList);
			connectionNameList.add(personName);

			for (int connection = 0; connection < tour.getConnections().size(); connection++) {
				Connection connectionVar = tour.getConnections().get(connection);

				if (connectionVar.getIntermediateFriends().equals("0")) {
					String connectedWithPersonId = connectionVar.getConnectedToPersonId();
					String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId, personList);
					connectionNameList.add(connectedPersonName);
				}
			}
		}
		if (connectionNameList.size() == 1) {
			System.out.println("No direct connections made in this tour!!");
		}
		return connectionNameList;
	}

	public List<String> indirectConnectionsOfTour(Tour tour, List<Person> personList) {
		List<String> connectionNameList = new ArrayList<String>();
		if (tour.getConnections().size() == 0) {
			System.out.println("No friends of friends in this tour!!");
			return connectionNameList;
		} else {
			String personId = tour.getConnections().get(0).getPersonId();
			String personName = personNameFinder.getPersonName(personId, personList);
			connectionNameList.add(personName);

			for (int connection = 0; connection < tour.getConnections().size(); connection++) {
				Connection connectionVar = tour.getConnections().get(connection);

				if (!connectionVar.getIntermediateFriends().equals("0")) {
					String connectedWithPersonId = connectionVar.getConnectedToPersonId();
					String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId, personList);
					connectionNameList.add(connectedPersonName);
				}

			}

		}
		if (connectionNameList.size() == 1) {
			System.out.println("No direct connections made in this tour!!");
		}
		return connectionNameList;
	}
}
