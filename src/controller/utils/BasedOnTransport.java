package controller.utils;

import java.util.List;

import entities.*;
import java.util.Scanner;

public class BasedOnTransport {
    Scanner sc = new Scanner(System.in);

    public void tourBasedOnTransport(List<TourEntity> tourList) {
        System.out.println("List trips based on transport");
        System.out.println("Please enter the type of transport");
        String modeOfTransport = sc.nextLine().toLowerCase();

        int tourBasedOnTransportCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourDetails = tourList.get(tourVariable);
            for (int journey = 0; journey < tourDetails.getJourneyDetails().size(); journey++) {
                JourneyDetailsEntity journeyDetails = tourDetails.getJourneyDetails().get(journey);
                if (modeOfTransport.equals(journeyDetails.getModeOfTransport())) {
                    System.out.println("Tour ID: " + tourDetails.getTourId());
                    System.out.println("Person Id: " + tourDetails.getPersonId());
                    System.out.println("Origin: " + tourDetails.getOrigin());
                    System.out.println("Destination: " + tourDetails.getDestination());
                    System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
                    System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
                    System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
                    tourBasedOnTransportCount++;
                    System.out.println("\n");
                }
            }
        }
        if (tourBasedOnTransportCount == 0) {
            System.out.println("No journey details found based on the given mode of transport");
        }
    }
}
