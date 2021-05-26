package controller.utils;

import java.util.ArrayList;
import java.util.List;

import entities.*;

public class BasedOnLocation {
    PrintDetails printDetails = new PrintDetails();

    public List<TourEntity> toursBasedOnLocation(List<TourEntity> tourList, String typeOfLocation) {
        int tourCountOnLocation = 0;
        List<TourEntity> tourBasedOnLocationList = new ArrayList<TourEntity>();

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            TourEntity tourEntity = tourList.get(tourVariable);

            if (typeOfLocation.equals(tourEntity.getTypeOfLocation())) {
                tourBasedOnLocationList.add(tourEntity);
                tourCountOnLocation++;
            }
        }
        if (tourCountOnLocation == 0) {
            System.out.println("No trips is based on the type of location given");
        }
        return tourBasedOnLocationList;
    }
}
