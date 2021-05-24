package controller.utils;

import java.util.List;

import entities.*;

public class BasedOnTransport {
    PrintDetails printDetails = new PrintDetails();

    public void tourBasedOnTransport(List<TourEntity> tourList, String modeOfTransport) {

        int tourBasedOnTransportCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourEntity = tourList.get(tourVariable);

            for (int journey = 0; journey < tourEntity.getJourneyDetails().size(); journey++) {
                JourneyDetailsEntity journeyDetails = tourEntity.getJourneyDetails().get(journey);

                if (modeOfTransport.equals(journeyDetails.getModeOfTransport())) {
                    printDetails.printTourDetails(tourEntity);
                    tourBasedOnTransportCount++;
                }
            }
        }
        if (tourBasedOnTransportCount == 0) {
            System.out.println("No journey details found based on the given mode of transport");
        }
    }
}
