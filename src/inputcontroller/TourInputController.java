package inputcontroller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.*;
import controller.InputValueCheck;
import utils.InputValidation;
import utils.UUIDGenerator;

public class TourInputController {
	Scanner sc = new Scanner(System.in);

	public Tour tourDetails(List<classes.Person> personList) throws ParseException {
		Tour tourData = new Tour();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		List<JourneyDetails> journeyList = new ArrayList<JourneyDetails>();
		List<Resort> resortList = new ArrayList<Resort>();
		List<Activity> activityList = new ArrayList<Activity>();
		List<Connection> connectionList = new ArrayList<Connection>();

		JourneyDetailsInputController journeyDetailsInputControllerData = new JourneyDetailsInputController();
		ResortInputController resortInputController = new ResortInputController();
		ActivityInputController tourActivities = new ActivityInputController();
		ConnectionInputController connectionsMade = new ConnectionInputController();
		PersonInputController personInputController = new PersonInputController();

		System.out.println("****************PLEASE ENTER THE TOUR DETAILS****************");

		System.out.println("Please Enter the person id");
		// String personId = valueCheck.uuidCheck();
		String personId = valueCheck.doesPersonExists(personList);
		tourData.setPersonId(personId);

		UUIDGenerator id = new UUIDGenerator();
		String tourId = id.uuid();
		tourData.setTourId(tourId);

		// System.out.println("Tour Start Date in \"yyyy-MM-dd HH:mm:ss format:");

		Date[] dates = valueCheck.dateRangeCheck();
		Date tourStartDate = dates[0];
		Date tourEndDate = dates[1];
		// Date tourStartDate = valueCheck.dateCheck();
		tourData.setTourStartDate(tourStartDate);

		// System.out.println("Tour End Date in \"yyyy-MM-dd HH:mm:ss format:");
		// Date tourEndDate = valueCheck.dateCheck();
		tourData.setTourEndDate(tourEndDate);

		System.out.println("Origin:");
		tourData.setOrigin(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Destination:");
		tourData.setDestination(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Type of location: ");
		tourData.setTypeOfLocation(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("For your information TOUR ID is: " + tourId);

		System.out.println("****************PLEASE ENTER THE JOURNEY DETAILS****************");
		System.out.println("How many journey details do you need to add");
		int totalJourneyCount = Integer.parseInt(validateString.intValidator(sc.nextLine()));
		int journeyAdded = 0;
		while (journeyAdded < totalJourneyCount) {
			JourneyDetails journey = journeyDetailsInputControllerData.journeyDetails(tourId);
			journeyList.add(journey);
			journeyAdded++;
		}
		System.out.println("*****************************************************************");

		System.out.println("****************PLEASE ENTER THE RESORT DETAILS****************");
		System.out.println("How many resort entries do you need to add");
		int totalResortCount = Integer.parseInt(valueCheck.intCheck());
		int resortsAdded = 0;
		while (resortsAdded < totalResortCount) {
			Resort resort = resortInputController.resortDetails(tourId);
			resortList.add(resort);
			resortsAdded++;
		}
		System.out.println("*****************************************************************");

		System.out.println("****************PLEASE ENTER THE TOUR ACTIVITIES****************");
		System.out.println("How many activity entries do you need to add");
		int totalActivitiesCount = Integer.parseInt(valueCheck.intCheck());
		int activitiesAdded = 0;
		while (activitiesAdded < totalActivitiesCount) {
			Activity activity = tourActivities.activities(tourId);
			activityList.add(activity);
			activitiesAdded++;
		}
		System.out.println("*****************************************************************");

		System.out.println("BEFORE ADDING CONNECTIONS PLEASE ENTER THE PERSON DETAILS TO WHOM YOU HAVE CONNECTED");
		System.out.println("How many person details do you need to add");
		int totalPersonCount = Integer.parseInt(valueCheck.intCheck());
		int personsAdded = 0;
		while (personsAdded < totalPersonCount) {
			Person person = personInputController.personDetails();
			personList.add(person);
			personsAdded++;
		}
		System.out.println("*****************************************************************");

		System.out.println("****************PLEASE ENTER CONNECTIONS MADE IN A TOUR****************");
		System.out.println("How many connections do you need to add");
		int totalConnectionsCount = Integer.parseInt(valueCheck.intCheck());
		int connectionsAdded = 0;
		while (connectionsAdded < totalConnectionsCount) {
			Connection connection = connectionsMade.connections(tourId, personId, personList);
			connectionList.add(connection);
			connectionsAdded++;
		}
		System.out.println("*****************************************************************");

		tourData.setJourneyDetails(journeyList);
		tourData.setResort(resortList);
		tourData.setActivities(activityList);
		tourData.setConnections(connectionList);

		System.out.println("\n");

		return tourData;
		// tourList.add(tourData);
	}

}
