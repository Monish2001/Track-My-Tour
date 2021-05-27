package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class BasedOnTransport {
    PrintDetails printDetails = new PrintDetails();

    public List<Tour> tourBasedOnTransport(List<Tour> tourList, String modeOfTransport) {
        List<Tour> tourBasedOnTransportList = new ArrayList<Tour>();

        int tourBasedOnTransportCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tour = tourList.get(tourVariable);

            for (int journey = 0; journey < tour.getJourneyDetails().size(); journey++) {
                JourneyDetails journeyDetails = tour.getJourneyDetails().get(journey);

                if (modeOfTransport.equals(journeyDetails.getModeOfTransport())) {
                    tourBasedOnTransportList.add(tour);
                    tourBasedOnTransportCount++;
                }
            }
        }
        if (tourBasedOnTransportCount == 0) {
            System.out.println("No journey details found based on the given mode of transport");
        }
        return tourBasedOnTransportList;
    }
}
