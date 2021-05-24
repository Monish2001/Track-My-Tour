package controller.utils;

import java.util.List;

import entities.*;
import java.util.Scanner;

public class BasedOnLocation {
    Scanner sc = new Scanner(System.in);

    /* DISPLAYS THE TOUR DETAILS BASED ON THE GIVEN INPUT LOCATION */
    public void toursBasedOnLocation(List<TourEntity> tourList) {
        System.out.println("Trips based on type of location");
        System.out.println("Please enter the type of location");
        String typeOfLocation = sc.nextLine().toLowerCase();

        // ITERATION OVER EVERY TOURS IN THE TOURLIST AND CHECKING WHETHER THE LOCATION
        // MATCHES
        int tourCountOnLocation = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourDetails = tourList.get(tourVariable);
            if (typeOfLocation.equals(tourDetails.getTypeOfLocation())) {
                System.out.println("*******************************************");
                System.out.println("Tour ID: " + tourDetails.getTourId());
                System.out.println("Person Id: " + tourDetails.getPersonId());
                System.out.println("Origin: " + tourDetails.getOrigin());
                System.out.println("Destination: " + tourDetails.getDestination());
                System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
                System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
                System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
                tourCountOnLocation++;
                System.out.println("*******************************************");
                System.out.println("\n");
            }
        }
        if (tourCountOnLocation == 0) {
            System.out.println("No trips is based on the type of location given");
        }
    }
}
