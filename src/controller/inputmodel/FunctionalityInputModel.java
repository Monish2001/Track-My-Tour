package controller.inputmodel;

import entities.*;
import java.util.List;
import java.util.Scanner;
import controller.utils.*;

public class FunctionalityInputModel {
    Scanner sc = new Scanner(System.in);
    PrintDetails printDetails = new PrintDetails();

    public String activities(List<TourEntity> tourList) {
        System.out.println("List of activities in a tour");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");

        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourId = sc.nextLine();
        return tourId;
    }

    public String costOfSingleTour(List<TourEntity> tourList) {
        System.out.println("Total cost of a single trip");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");

        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourId = sc.nextLine();
        return tourId;
    }

    public String costOfTourStay(List<TourEntity> tourList) {
        System.out.println("Cost for a single trip stay in hotel");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourId = sc.nextLine();
        return tourId;
    }

    public String toursBasedOnLocation() {
        System.out.println("Trips based on type of location");
        System.out.println("Please enter the type of location");
        String typeOfLocation = sc.nextLine().toLowerCase().trim();
        return typeOfLocation;
    }

    public String toursBasedOnTransport() {
        System.out.println("List trips based on transport");
        System.out.println("Please enter the type of transport");
        String modeOfTransport = sc.nextLine().toLowerCase();
        return modeOfTransport;
    }

    public String directConnections(List<TourEntity> tourList) {
        System.out.println("DIRECT FRIEND IN A TRIP");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourIdForDirectFriends = sc.nextLine();
        return tourIdForDirectFriends;
    }

    public String inDirectConnections(List<TourEntity> tourList) {
        System.out.println("FRIENDS OF FRIENDS IN A TOUR");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourIdForIndirectConnections = sc.nextLine();
        return tourIdForIndirectConnections;
    }

    public String[] toursOnDateRange() {
        System.out.println("TRIPS WITH THE GIVEN DATE RANGE");
        System.out.println("Please enter the date range");
        System.out.println("Start Date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        String startDate = sc.nextLine();
        System.out.println("End date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        String endDate = sc.nextLine();
        String[] date = { startDate, endDate };
        return date;
    }
}