package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import controller.inputmodel.*;
import controller.utils.*;
import entities.*;

public class Main {
	public static void main(String[] args) throws ParseException {
		System.out
				.println("*********************************WELCOME**************************************************");
		System.out
				.println("******************************TRACK MY TOUR***********************************************");
		System.out.println("****************************OPERATIONS PERFORMED*****************************************");
		System.out.println(
				"1.Add Person details \n 2.Add a trip entry\n 3.List the trip entries\n 4.Total cost of single trip\n 5.Cost for trip stay in hotel\n 6.List trips based on type of location\n 7.List trips based on transport\n 8.List direct friend in a trip\n 9.List friends of friends in a trip\n 10.List the trip with given date range\n 11.List the activities and total activities cost in a trip");
		System.out.println("If you want to close then please type as 'exit'");
		System.out.println("Before adding tour details please enter the person details to know your ID");
		System.out.println("*****************************************************************************************");

		List<PersonEntity> personList = new ArrayList<PersonEntity>();
		List<TourEntity> tourList = new ArrayList<TourEntity>();

		Tour tour = null;
		Person person = null;

		PrintEntries printEntries = null;
		CostFinder costFinder = null;
		BasedOnLocation tourLocation = null;
		BasedOnTransport tourTransport = null;
		Connections connections = null;
		ToursOnDateRange toursOnDateRange = null;
		Activities listActivities = null;

		FunctionalityInputModel inputModel = new FunctionalityInputModel();
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
					if (person == null) {
						person = new Person();
					}
					personList.add(person.personDetails());
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;
				}
				case "2": {
					// ADD TOUR ENTRIES
					if (tour == null) {
						tour = new Tour();
					}

					boolean isPersonListEmpty = isListEmpty.checkIsPersonListEmpty(personList);
					if (isPersonListEmpty == true) {
						System.out.println(
								"Please enter the person details first to get the respective person id and enter the tour details!!");
						System.out.println("\n");
						System.out.println("If you want to perform any operation again please press no from 1 to 11");
						break;
					}

					tourList.add(tour.tourDetails(personList));
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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

					printEntries.printTourEntries(tourList);
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					int totalCostOfTour = costFinder.costOfSingleTour(tourList, tourId);
					printDetails.printTotalCostOfTour(totalCostOfTour);

					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					System.out.println("\n");
					break;
				}
				case "5": {
					// GET COST OF YOUR SINGLE TOUR STAY
					if (costFinder == null) {
						costFinder = new CostFinder();
					}

					boolean isTourListEmpty = isListEmpty.checkIsTourListEmpty(tourList);
					if (isTourListEmpty == true) {
						printDetails.printCommonTourListSOP();
						break;
					}

					String tourIdForStay = inputModel.costOfTourStay(tourList);
					int costForStay = costFinder.costOfTourStay(tourList, tourIdForStay);
					printDetails.printCostOfTourStay(costForStay);

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					List<TourEntity> tourBasedOnLocationList = tourLocation.toursBasedOnLocation(tourList, location);
					if (tourBasedOnLocationList.size() != 0) {
						for (TourEntity tourEntity : tourBasedOnLocationList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					List<TourEntity> tourBasedOnTransportList = tourTransport.tourBasedOnTransport(tourList,
							modeOfTransport);
					if (tourBasedOnTransportList.size() != 0) {
						for (TourEntity tourEntity : tourBasedOnTransportList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					List<String> directConnectionNameList = connections.directConnections(tourList, personList,
							tourIdForDirectConnection);
					if (directConnectionNameList.size() != 0) {
						printDetails.printDirectConnections(directConnectionNameList);
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					if (indirectConnectionNameList.size() != 0) {
						printDetails.printIndirectConnections(indirectConnectionNameList);
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
						System.out.println("If you want to perform any operation again please press no from 1 to 11");
						System.out.println("\n");
						break;
					}
					List<TourEntity> toursOnDateRangeList = toursOnDateRange.toursBasedOnDateRange(tourList, date);
					if (toursOnDateRangeList.size() != 0) {
						for (TourEntity tourEntity : toursOnDateRangeList) {
							printDetails.printTourDetails(tourEntity);
						}
					}

					System.out.println("If you want to perform any operation again please press no from 1 to 11");
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
					List<String> activities = listActivities.ListOfActivities(tourList, tourIdForActivities);
					if (activities.size() != 0) {
						printDetails.printActivities(activities);
						int totalActivityCost = costFinder.costOfActivities(tourList, tourIdForActivities);
						printDetails.costOfActivities(totalActivityCost);
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;
				}
				case "exit":
					condition = 0;
					break;

				default:
					System.out.println("Please enter a valid input from 0 to 11");
					break;
			}
		}
		sc.close();
		System.out.println("***********************THANK YOU FOR USING MY APPLICATION*************************");
	}

}
