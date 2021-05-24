package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.utils.*;
import entities.*;

public class Main {
	public static void main(String[] args) throws ParseException {
		System.out.println("****************************OPERATIONS PERFORMED*****************************************");
		System.out.println(
				"1.Add a trip entry\n 2.List the trip entries\n 3.Total cost of single trip\n 4.Cost for trip stay in hotel\n 5.List trips based on type of location\n 6.List trips based on transport\n 7.List direct friend in a trip\n 8.List friends of friends in a trip\n 9.List the trip with given date range\n 10.List the activities and total activities cost in a trip");
		System.out.println("If you want to close the please type as 'exit'");
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

		Scanner sc = new Scanner(System.in);
		String operation;
		int condition = 1;

		while (condition == 1) {
			operation = sc.nextLine();
			switch (operation) {
				case "0":
					if (person == null) {
						person = new Person();
					}
					personList.add(person.personDetails());
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;
				case "1":
					if (tour == null) {
						tour = new Tour();
					}
					tourList.add(tour.tourDetails());
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "2":
					if (printEntries == null) {
						printEntries = new PrintEntries();
					}
					printEntries.printTourEntries(tourList);
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "3":
					if (costFinder == null) {
						costFinder = new CostFinder();
					}
					costFinder.costOfSingleTour(tourList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "4":
					if (costFinder == null) {
						costFinder = new CostFinder();
					}
					costFinder.costOfTourStay(tourList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "5":
					if (tourLocation == null) {
						tourLocation = new BasedOnLocation();
					}

					tourLocation.toursBasedOnLocation(tourList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "6":
					if (tourTransport == null) {
						tourTransport = new BasedOnTransport();
					}
					tourTransport.tourBasedOnTransport(tourList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "7":
					if (connections == null) {
						connections = new Connections();
					}
					connections.directConnections(tourList, personList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "8":
					if (connections == null) {
						connections = new Connections();
					}
					connections.indirectConnections(tourList, personList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "9":
					if (toursOnDateRange == null) {
						toursOnDateRange = new ToursOnDateRange();
					}
					toursOnDateRange.toursBasedOnDateRange(tourList);
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "10":
					System.out.println("ACTIVITIES AND TOTAL ACTIVITIES COST IN A TOUR");
					break;

				case "exit":
					condition = 0;
					break;

				default:
					System.out.println("Please enter a valid input from 0 to 12");
					break;
			}
		}
	}

}
