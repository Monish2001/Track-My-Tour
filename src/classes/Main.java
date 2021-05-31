package classes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.*;
import inputcontroller.ConnectionInputController;
import inputcontroller.FunctionalityInputController;
import inputcontroller.PersonInputController;
import inputcontroller.TourInputController;

public class Main {
	public static void main(String[] args) throws ParseException {
		System.out
				.println("*********************************WELCOME**************************************************");
		System.out
				.println("******************************TRACK MY TOUR***********************************************");
		System.out.println("****************************OPERATIONS PERFORMED*****************************************");
		System.out.println(
				"1.Add Person details \n 2.Add a trip entry\n 3.List the trip entries\n 4.Total cost of single trip\n 5.Cost for trip stay in hotel\n 6.List trips based on type of location\n 7.List trips based on transport\n 8.List direct friend in a trip\n 9.List friends of friends in a trip\n 10.List the trip with given date range\n 11.List the activities and total activities cost in a trip\n 12.Make connections outside the tour\n");
		System.out.println("If you want to close then please type as 'exit'");
		System.out.println("Before adding tour details please enter the person details to know your ID");
		System.out.println("*****************************************************************************************");

		List<Person> personList = new ArrayList<Person>();
		List<Tour> tourList = new ArrayList<Tour>();
		List<Connection> connectionList = new ArrayList<Connection>();

		TourInputController tourInputController = null;
		PersonInputController personInputController = null;
		ConnectionInputController connectionInputController = null;

		PrintEntries printEntries = null;
		CostFinder costFinder = null;
		BasedOnLocation tourLocation = null;
		BasedOnTransport tourTransport = null;
		Connections connections = null;
		ToursOnDateRange toursOnDateRange = null;
		Activities listActivities = null;

		Tour tour = null;

		FunctionalityInputController inputModel = new FunctionalityInputController();
		CheckIsListEmpty isListEmpty = new CheckIsListEmpty();

		PrintDetails printDetails = new PrintDetails();

		Scanner sc = new Scanner(System.in);
		String operation;
		int condition = 1;

		while (condition == 1) {
			operation = sc.nextLine();
			switch (operation) {
				case "1": {
					// ADD PERSON DETAILS
					if (personInputController == null) {
						personInputController = new PersonInputController();
					}
					Person person = personInputController.personDetails();
					personList.add(person);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "2": {
					// ADD TOUR ENTRIES
					if (tourInputController == null) {
						tourInputController = new TourInputController();
					}

					boolean isPersonListEmpty = isListEmpty.checkIsPersonListEmpty(personList);
					if (isPersonListEmpty == true) {
						System.out.println(
								"Please enter the person details first to get the respective person id and enter the tour details!!");
						System.out.println("\n");
						System.out.println("If you want to perform any operation again please press no from 1 to 12");
						break;
					}
					tour = tourInputController.tourDetails(personList, connectionList);
					tourList.add(tour);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "3": {
					// PRINT ADDED TOUR ENTRIES
					if (printEntries == null) {
						printEntries = new PrintEntries();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					printEntries.printTourEntries(tourList, personList);
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "4": {
					// GET TOTAL COST OF A SINGLE TOUR
					if (costFinder == null) {
						costFinder = new CostFinder();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourId = inputModel.costOfSingleTour(tourList);
					Integer totalCostOfTour = costFinder.costOfSingleTour(tourList, tourId);
					if (totalCostOfTour == null) {
						printDetails.printCommonTourListSOP();
						break;
					}
					printDetails.printTotalCostOfTour(totalCostOfTour);

					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					System.out.println("\n");
					break;
				}
				case "5": {
					// GET COST OF YOUR SINGLE TOUR STAY
					if (tour == null) {
						tour = new Tour();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourIdForStay = inputModel.costOfTourStay(tourList);
					Integer costForStay = costFinder.costOfATourStay(tourList, tourIdForStay);
					if (costForStay == null) {
						printDetails.printCommonTourListSOP();
						break;
					}
					printDetails.printCostOfTourStay(costForStay);

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					System.out.println("\n");
					break;
				}
				case "6": {
					// GET TOURS BASED ON YOUR LOCATION
					if (tourLocation == null) {
						tourLocation = new BasedOnLocation();
					}
					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}
					String location = inputModel.toursBasedOnLocation();
					List<classes.Tour> tourBasedOnLocationList = tourLocation.toursBasedOnLocation(tourList, location);
					if (tourBasedOnLocationList.size() != 0) {
						for (classes.Tour tourEntity : tourBasedOnLocationList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "7": {
					// GET TOURS BASED ON THE TRANSPORT
					if (tourTransport == null) {
						tourTransport = new BasedOnTransport();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String modeOfTransport = inputModel.toursBasedOnTransport();
					List<Tour> tourBasedOnTransportList = tourTransport.tourBasedOnTransport(tourList, modeOfTransport);
					if (tourBasedOnTransportList.size() != 0) {
						for (Tour tourEntity : tourBasedOnTransportList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "8": {
					// GET DIRECT CONNECTIONS MADE IN THE TOUR
					if (connections == null) {
						connections = new Connections();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourIdForDirectConnection = inputModel.directConnections(tourList);
					List<String> directConnectionNameList = connections.directConnectionsInATour(tourList, personList,
							tourIdForDirectConnection);
					if (directConnectionNameList.size() > 1) {
						printDetails.printDirectConnections(directConnectionNameList);
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "9": {
					// GET INDIRECT CONNECTIONS MADE IN A TOUR
					if (connections == null) {
						connections = new Connections();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourIdForIndirectConnections = inputModel.inDirectConnections(tourList);
					List<String> indirectConnectionNameList = connections.indirectConnections(tourList, personList,
							tourIdForIndirectConnections);
					if (indirectConnectionNameList.size() > 1) {
						printDetails.printIndirectConnections(indirectConnectionNameList);
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}
				case "10": {
					// GET TOUR LIST BASED ON THE GIVEN DATE INPUT RANGE
					if (toursOnDateRange == null) {
						toursOnDateRange = new ToursOnDateRange();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					Date[] date = inputModel.toursOnDateRange();
					if (date[0] == null || date[1] == null) {
						System.out.println("Invalid input!!");
						System.out.println("If you want to perform any operation again please press no from 1 to 12");
						System.out.println("\n");
						break;
					}
					List<Tour> toursOnDateRangeList = toursOnDateRange.toursBasedOnDateRange(tourList, date);
					if (toursOnDateRangeList.size() != 0) {
						for (Tour tourEntity : toursOnDateRangeList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					System.out.println("\n");
					break;
				}
				case "11": {
					// GET LIST OF ACTIVITIES AND TOTAL COST OF THEIR ACTIVITIES IN A TOUR
					if (listActivities == null) {
						listActivities = new Activities();
					}
					if (costFinder == null) {
						costFinder = new CostFinder();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourIdForActivities = inputModel.activities(tourList);
					List<String> activities = listActivities.listOfActivities(tourList, tourIdForActivities);
					if (activities.size() != 0) {
						printDetails.printActivities(activities);
						Integer totalActivityCost = costFinder.costOfActivities(tourList, tourIdForActivities);
						printDetails.costOfActivities(totalActivityCost);
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;
				}

				case "12":
					System.out.println("Make connections outside the tour!!");
					if (connectionInputController == null) {
						connectionInputController = new ConnectionInputController();
					}

					Connection connection = connectionInputController.connections(null, null, null, personList,
							connectionList);
					connectionList.add(connection);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 12");
					break;

				case "exit":
					condition = 0;
					break;

				default:
					System.out.println("Please enter a valid input from 1 to 12");
					break;
			}
		}
		sc.close();
		System.out.println("***********************THANK YOU FOR USING MY APPLICATION*************************");
	}

}
