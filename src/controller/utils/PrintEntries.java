package controller.utils;

import java.util.List;

import entities.*;

public class PrintEntries {
    PrintDetails printDetails = new PrintDetails();

    public void printTourEntries(List<TourEntity> tourList) {
        if (tourList.size() == 0) {
            System.out.println("There is no tour entries. Please add some tour entry!!");
        } else {
            System.out.println("**********************PRINT ENTRIES*************************");
            for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

                TourEntity tourEntity = tourList.get(tourVariable);
                printDetails.printTourDetails(tourEntity);

                for (int journey = 0; journey < tourEntity.getJourneyDetails().size(); journey++) {
                    JourneyDetailsEntity journeyDetailsEntity = tourEntity.getJourneyDetails().get(journey);
                    printDetails.printJourneyDetails(journeyDetailsEntity);
                }

                for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
                    ResortEntity resortEntity = tourEntity.getResort().get(resort);
                    printDetails.printResortDetails(resortEntity);
                    System.out.println("**********************ROOM DETAILS*************************");

                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        RoomEntity roomEntity = resortEntity.getRoom().get(room);
                        printDetails.printRoomDetails(roomEntity);
                    }
                }

                for (int activity = 0; activity < tourEntity.getActivities().size(); activity++) {
                    ActivityEntity activityEntity = tourEntity.getActivities().get(activity);
                    printDetails.printActivity(activityEntity);
                }

                for (int connection = 0; connection < tourEntity.getConnections().size(); connection++) {
                    ConnectionEntity connectionEntity = tourEntity.getConnections().get(connection);
                    printDetails.printConnectionDetails(connectionEntity);
                }
            }
        }
    }
}
