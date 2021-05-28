package controller;

import java.util.List;

import classes.*;

public class CostFinder {
    Tour tourObj = new Tour();

    public Integer costOfSingleTour(List<Tour> tourList, String tourId) {
        Integer totalCost = 0;
        if (tourList.size() == 0) {
            // System.out.println("There is no tour entries yet");
            return null;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                totalCost += tourObj.totalCostOfTour(tourDetails);
                break;
            }
        }
        return totalCost;
    }

    /* DISPLAYING THE TOTAL COST OF SINGLE TOUR STAY */
    public Integer costOfATourStay(List<Tour> tourList, String tourId) {
        Integer costForTripStay = 0;
        if (tourList.size() == 0) {
            return null;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                costForTripStay += tourObj.costOfTourStay(tourDetails);
                break;
            }
        }
        return costForTripStay;
    }

    public Integer costOfActivities(List<Tour> tourList, String tourId) {
        Integer totalActivityCost = 0;
        if (tourList.size() == 0) {
            // System.out.println("There is no tour entries yet");
            return null;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                totalActivityCost += tourObj.costOfTourActivities(tourDetails);
                break;
            }
        }
        return totalActivityCost;
    }

}
