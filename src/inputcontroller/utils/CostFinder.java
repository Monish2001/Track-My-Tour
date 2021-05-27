package inputcontroller.utils;

import java.util.List;

import classes.*;

public class CostFinder {

    public int costOfSingleTour(List<Tour> tourList, String tourId) {
        int totalCost = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            Tour tour = tourList.get(tourVariable);
            if (tourId.equals(tour.getTourId())) {
                for (int resort = 0; resort < tour.getResort().size(); resort++) {
                    Resort resortEntity = tour.getResort().get(resort);
                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        Room roomEntity = resortEntity.getRoom().get(room);
                        totalCost += roomEntity.getTotalCost();
                    }
                }
                for (int activities = 0; activities < tour.getActivities().size(); activities++) {
                    Activity activity = tour.getActivities().get(activities);
                    totalCost += activity.getCost();
                }
                break;
            }
        }
        return totalCost;
    }

    /* DISPLAYING THE TOTAL COST OF SINGLE TOUR STAY */
    public int costOfTourStay(List<Tour> tourList, String tourId) {

        int costForTripStay = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            Tour tour = tourList.get(tourVariable);
            if (tourId.equals(tour.getTourId())) {
                for (int resort = 0; resort < tour.getResort().size(); resort++) {
                    Resort resortEntity = tour.getResort().get(resort);
                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        Room roomEntity = resortEntity.getRoom().get(room);
                        costForTripStay += roomEntity.getTotalCost();
                    }
                }
                break;
            }
        }
        return costForTripStay;
    }

    public int costOfActivities(List<Tour> tourList, String tourId) {
        int totalActivityCost = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            Tour tour = tourList.get(tourVariable);
            if (tourId.equals(tour.getTourId())) {
                for (int activities = 0; activities < tour.getActivities().size(); activities++) {
                    Activity activity = tour.getActivities().get(activities);
                    totalActivityCost += activity.getCost();
                }
                break;
            }
        }
        return totalActivityCost;
    }

}
