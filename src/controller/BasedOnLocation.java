package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class BasedOnLocation {
    PrintDetails printDetails = new PrintDetails();

    public List<Tour> toursBasedOnLocation(List<Tour> tourList, String typeOfLocation) {
        int tourCountOnLocation = 0;
        List<Tour> tourBasedOnLocationList = new ArrayList<Tour>();

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tour = tourList.get(tourVariable);

            if (typeOfLocation.equals(tour.getTypeOfLocation())) {
                tourBasedOnLocationList.add(tour);
                tourCountOnLocation++;
            }
        }
        if (tourCountOnLocation == 0) {
            System.out.println("No trips is based on the type of location given");
        }
        return tourBasedOnLocationList;
    }
}
