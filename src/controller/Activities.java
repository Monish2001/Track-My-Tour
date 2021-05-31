package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class Activities {
    Tour tourObj = new Tour();

    public List<String> listOfActivities(List<Tour> tourList, String tourId) {
        List<String> tourActivities = new ArrayList<String>();
        int touridMatchCount = 0;
        if (tourList.size() == 0) {
            System.out.println("There is no tour entries yet");
            return tourActivities;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                touridMatchCount = 1;
                tourActivities = tourObj.listOfActivitiesOfTour(tourDetails);
            }
        }
        if (touridMatchCount <= 0) {
            System.out.println("TourId didn't match with our tourId list!! Please try again with proper tourId!!");
        }
        return tourActivities;
    }
}
