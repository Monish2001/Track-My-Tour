package controller.utils;

import java.util.List;

import entities.*;

public class CostFinder {

    public int costOfSingleTour(List<TourEntity> tourList, String tourId) {
        int totalCost = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourId.equals(tourEntity.getTourId())) {
                for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
                    ResortEntity resortEntity = tourEntity.getResort().get(resort);
                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        RoomEntity roomEntity = resortEntity.getRoom().get(room);
                        totalCost += roomEntity.getTotalCost();
                    }
                }
                for (int activities = 0; activities < tourEntity.getActivities().size(); activities++) {
                    ActivityEntity activityEntity = tourEntity.getActivities().get(activities);
                    totalCost += activityEntity.getCost();
                }
                break;
            }
        }
        return totalCost;
    }

    /* DISPLAYING THE TOTAL COST OF SINGLE TOUR STAY */
    public int costOfTourStay(List<TourEntity> tourList, String tourId) {

        int costForTripStay = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourId.equals(tourEntity.getTourId())) {
                for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
                    ResortEntity resortEntity = tourEntity.getResort().get(resort);
                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        RoomEntity roomEntity = resortEntity.getRoom().get(room);
                        costForTripStay += roomEntity.getTotalCost();
                    }
                }
                break;
            }
        }
        return costForTripStay;
    }

    public int costOfActivities(List<TourEntity> tourList, String tourId) {
        int totalActivityCost = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourId.equals(tourEntity.getTourId())) {
                for (int activities = 0; activities < tourEntity.getActivities().size(); activities++) {
                    ActivityEntity activity = tourEntity.getActivities().get(activities);
                    totalActivityCost += activity.getCost();
                }
                break;
            }
        }
        return totalActivityCost;
    }

}
