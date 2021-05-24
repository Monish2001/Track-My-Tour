package controller.utils;

import java.util.ArrayList;
import java.util.List;

import entities.*;

public class Activities {

    public List<String> ListOfActivities(List<TourEntity> tourList, String tourId) {
        List<String> tourActivities = new ArrayList<String>();
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            TourEntity tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                for (int actitvity = 0; actitvity < tourDetails.getActivities().size(); actitvity++) {
                    ActivityEntity activities = tourDetails.getActivities().get(actitvity);
                    tourActivities.add(activities.getActivityName());
                }
                break;
            }
        }
        return tourActivities;
    }
}