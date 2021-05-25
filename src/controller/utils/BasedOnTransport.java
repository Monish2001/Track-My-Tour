package controller.utils;

import java.util.ArrayList;
import java.util.List;

import entities.*;

public class BasedOnTransport {
    PrintDetails printDetails = new PrintDetails();

    public List<TourEntity> tourBasedOnTransport(List<TourEntity> tourList, String modeOfTransport) {
        List<TourEntity> tourBasedOnTransportList = new ArrayList<TourEntity>();

        int tourBasedOnTransportCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourEntity = tourList.get(tourVariable);

            for (int journey = 0; journey < tourEntity.getJourneyDetails().size(); journey++) {
                JourneyDetailsEntity journeyDetails = tourEntity.getJourneyDetails().get(journey);

                if (modeOfTransport.equals(journeyDetails.getModeOfTransport())) {
                    tourBasedOnTransportCount++;
                    tourBasedOnTransportList.add(tourEntity);
                }
            }
        }
        if (tourBasedOnTransportCount == 0) {
            System.out.println("No journey details found based on the given mode of transport");
        }
        return tourBasedOnTransportList;
    }
}
