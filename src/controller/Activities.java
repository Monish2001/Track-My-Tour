package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class Activities {

    public List<String> ListOfActivities(List<Tour> tourList, String tourId) {
        List<String> tourActivities = new ArrayList<String>();
        int touridMatchCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                touridMatchCount = 1;
                if (tourDetails.getActivities().size() == 0) {
                    System.out.println("No activities in the given tour!!");
                    break;
                } else {
                    for (int actitvity = 0; actitvity < tourDetails.getActivities().size(); actitvity++) {
                        Activity activities = tourDetails.getActivities().get(actitvity);
                        tourActivities.add(activities.getActivityName());
                    }
                    break;
                }
            }
        }
        if (touridMatchCount <= 0) {
            System.out.println("TourId didn't match with our tourId list!! Please try again with proper tourId!!");
        }
        return tourActivities;
    }
}
