package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.*;
import utils.DateFormatter;
import utils.UUIDGenerator;

public class Tour {
	Scanner sc = new Scanner(System.in);

	public TourEntity tourDetails() throws ParseException {
		TourEntity tourData = new TourEntity();

		List<JourneyDetailsEntity> journeyList = new ArrayList<JourneyDetailsEntity>();
		List<ResortEntity> resortList = new ArrayList<ResortEntity>();
		List<ActivityEntity> activityList = new ArrayList<ActivityEntity>();
		List<ConnectionEntity> connectionList = new ArrayList<ConnectionEntity>();

		JourneyDetails journeyDetailsData = new JourneyDetails();
		Resort resortDetailsData = new Resort();
		Activity tourActivities = new Activity();
		Connection connectionsMade = new Connection();

		System.out.println("******PLEASE ENTER THE TOUR DETAILS**********");

		System.out.println("Please Enter the person id");
		tourData.setPersonId(sc.nextLine());

		UUIDGenerator id = new UUIDGenerator();
		String tourId = id.uuid();
		tourData.setTourId(tourId);

		System.out.println("Tour Start Date in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date tourStartDate = dateObj.dateFormatter(sc.nextLine());
		tourData.setTourStartDate(tourStartDate);

		System.out.println("Tour End Date in \"yyyy-MM-dd HH:mm:ss format:");
		Date tourEndDate = dateObj.dateFormatter(sc.nextLine());
		tourData.setTourEndDate(tourEndDate);

		System.out.println("Origin:");
		tourData.setOrigin(sc.nextLine());

		System.out.println("Destination:");
		tourData.setDestination(sc.nextLine());

		System.out.println("Type of location: ");
		tourData.setTypeOfLocation(sc.nextLine());

		System.out.println("For your information TOUR ID is: " + tourId);

		System.out.println("How many journey details do you need to add");
		int count = Integer.parseInt(sc.nextLine());
		int index = 0;
		while (index < count) {
			journeyList.add(journeyDetailsData.journeyDetails());
			index++;
		}

		System.out.println("How many resort entries do you need to add");
		count = Integer.parseInt(sc.nextLine());
		index = 0;
		while (index < count) {
			resortList.add(resortDetailsData.resortDetails());
			index++;
		}

		System.out.println("How many activity entries do you need to add");
		count = Integer.parseInt(sc.nextLine());
		index = 0;
		while (index < count) {
			activityList.add(tourActivities.activities());
			index++;
		}

		System.out.println("How many connections do you need to add");
		count = Integer.parseInt(sc.nextLine());
		index = 0;
		while (index < count) {
			connectionList.add(connectionsMade.connections());
			index++;
		}

		tourData.setJourneyDetails(journeyList);
		tourData.setResort(resortList);
		tourData.setActivities(activityList);
		tourData.setConnections(connectionList);

		System.out.println("**********************************************************");
		System.out.println("\n");

		return tourData;
		// tourList.add(tourData);
	}

}
