package controller.utils;

import java.util.List;

import entities.*;
import java.util.Scanner;

public class CostFinder {

    Scanner sc = new Scanner(System.in);
    PrintTourId printId = new PrintTourId();

    /*
     * DISPLAYING THE TOTAL COST OF SINGLE TOUR WITH ROOM COST AND ACTIVITIES COST
     */
    public void costOfSingleTour(List<TourEntity> tourList) {

        System.out.println("Total cost of a single trip");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");

        printId.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourId = sc.nextLine();

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
        System.out.println("Total cost of a single trip: " + totalCost);
    }

    /* DISPLAYING THE TOTAL COST OF SINGLE TOUR STAY */
    public void costOfTourStay(List<TourEntity> tourList) {
        System.out.println("Cost for a single trip stay in hotel");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printId.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourIdForTripStay = sc.nextLine();
        int costForTripStay = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() == 0) {
                System.out.println("There is no tour entries yet");
                break;
            }

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourIdForTripStay.equals(tourEntity.getTourId())) {
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
        System.out.println("Total cost for a single trip in hotel is: " + costForTripStay);
    }
}
