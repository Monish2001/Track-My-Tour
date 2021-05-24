package controller.utils;

import java.util.List;

import entities.*;

public class BasedOnLocation {
    PrintDetails printDetails = new PrintDetails();

    public void toursBasedOnLocation(List<TourEntity> tourList, String typeOfLocation) {
        int tourCountOnLocation = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourEntity = tourList.get(tourVariable);

            if (typeOfLocation.equals(tourEntity.getTypeOfLocation())) {
                tourCountOnLocation++;
                printDetails.printTourDetails(tourEntity);
            }
        }
        if (tourCountOnLocation == 0) {
            System.out.println("No trips is based on the type of location given");
        }
    }
}
