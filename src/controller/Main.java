package controller;

import java.text.ParseException;
import java.util.ArrayList;
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

		PrintDetails printDetails = new PrintDetails();

		Scanner sc = new Scanner(System.in);
		String operation;
		int condition = 1;

		while (condition == 1) {
			operation = sc.nextLine();
			switch (operation) {
				case "1":
					if (person == null) {
						person = new Person();
					}
					personList.add(person.personDetails());
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					System.out.println("\n");
					break;
				case "2":
					if (tour == null) {
						tour = new Tour();
					}
					tourList.add(tour.tourDetails(personList));
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;

				case "3":
					if (printEntries == null) {
						printEntries = new PrintEntries();
					}
					printEntries.printTourEntries(tourList);
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;

				case "4":
					if (costFinder == null) {
						costFinder = new CostFinder();
					}

					String tourId = inputModel.costOfSingleTour(tourList);
					int totalCostOfTour = costFinder.costOfSingleTour(tourList, tourId);
					printDetails.printTotalCostOfTour(totalCostOfTour);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					System.out.println("\n");
					break;

				case "5":
					if (costFinder == null) {
						costFinder = new CostFinder();
					}
					String tourIdForStay = inputModel.costOfTourStay(tourList);
					int costForStay = costFinder.costOfTourStay(tourList, tourIdForStay);
					printDetails.printCostOfTourStay(costForStay);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					System.out.println("\n");
					break;

				case "6":
					if (tourLocation == null) {
						tourLocation = new BasedOnLocation();
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

				case "7":
					if (tourTransport == null) {
						tourTransport = new BasedOnTransport();
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

				case "8":
					if (connections == null) {
						connections = new Connections();
					}
					String tourIdForDirectConnection = inputModel.directConnections(tourList);
					connections.directConnections(tourList, personList, tourIdForDirectConnection);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;

				case "9":
					if (connections == null) {
						connections = new Connections();
					}
					String tourIdForIndirectConnections = inputModel.inDirectConnections(tourList);
					connections.indirectConnections(tourList, personList, tourIdForIndirectConnections);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					break;

				case "10":
					if (toursOnDateRange == null) {
						toursOnDateRange = new ToursOnDateRange();
					}
					String[] date = inputModel.toursOnDateRange();
					List<TourEntity> toursOnDateRangeList = toursOnDateRange.toursBasedOnDateRange(tourList, date);
					if (toursOnDateRangeList.size() != 0) {
						for (TourEntity tourEntity : toursOnDateRangeList) {
							printDetails.printTourDetails(tourEntity);
						}
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 1 to 11");
					System.out.println("\n");
					break;

				case "11":
					if (listActivities == null) {
						listActivities = new Activities();
					}
					if (costFinder == null) {
						costFinder = new CostFinder();
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
