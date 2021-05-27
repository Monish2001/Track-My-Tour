package inputcontroller.utils;

import java.util.List;

import classes.*;

public class PrintEntries {
    PrintDetails printDetails = new PrintDetails();

    public void printTourEntries(List<Tour> tourList) {
        if (tourList.size() == 0) {
            System.out.println("There is no tour entries. Please add some tour entry!!");
        } else {
            System.out.println("**********************PRINT ENTRIES*************************");
            for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

                Tour tour = tourList.get(tourVariable);
                printDetails.printTourDetails(tour);

                for (int journey = 0; journey < tour.getJourneyDetails().size(); journey++) {
                    JourneyDetails journeyDetails = tour.getJourneyDetails().get(journey);
                    printDetails.printJourneyDetails(journeyDetails);
                }

                for (int resort = 0; resort < tour.getResort().size(); resort++) {
                    Resort resortEntity = tour.getResort().get(resort);
                    printDetails.printResortDetails(resortEntity);
                    System.out.println("**********************ROOM DETAILS*************************");

                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        Room roomEntity = resortEntity.getRoom().get(room);
                        printDetails.printRoomDetails(roomEntity);
                    }
                }

                for (int activity = 0; activity < tour.getActivities().size(); activity++) {
                    Activity activityEntity = tour.getActivities().get(activity);
                    printDetails.printActivity(activityEntity);
                }

                for (int connection = 0; connection < tour.getConnections().size(); connection++) {
                    Connection connectionEntity = tour.getConnections().get(connection);
                    printDetails.printConnectionDetails(connectionEntity);
                }
            }
        }
    }
}
