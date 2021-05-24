package controller.utils;

import java.util.List;

import entities.*;

public class PrintEntries {
    public void printTourEntries(List<TourEntity> tourList) {
        if (tourList.size() == 0) {
            System.out.println("There is no tour entries. Please add some tour entry!!");
        } else {
            System.out.println("**********************PRINT ENTRIES*************************");
            for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

                TourEntity tourEntity = tourList.get(tourVariable);
                System.out.println("**********************TOUR DETAILS*************************");
                System.out.println("Person ID: " + tourEntity.getPersonId());
                System.out.println("Tour ID: " + tourEntity.getTourId());
                System.out.println("Tour Origin: " + tourEntity.getOrigin());
                System.out.println("Tour Destination: " + tourEntity.getDestination());
                System.out.println("Tour Start Date: " + tourEntity.getTourStartDate());
                System.out.println("Tour End Date: " + tourEntity.getTourEndDate());
                System.out.println("Type of location: " + tourEntity.getTypeOfLocation());
                System.out.println("**********************************************************");
                System.out.println("\n");

                for (int journey = 0; journey < tourEntity.getJourneyDetails().size(); journey++) {
                    System.out.println("**********************JOURNEY DETAILS*************************");
                    JourneyDetailsEntity journeyDetailsEntity = tourEntity.getJourneyDetails().get(journey);
                    System.out.println("Journey Details ID: " + journeyDetailsEntity.getJourneyDetailsId());
                    System.out.println("Tour ID: " + journeyDetailsEntity.getTourId());
                    System.out.println("Journey Start Time: " + journeyDetailsEntity.getStartTime());
                    System.out.println("Journey Reached Time:" + journeyDetailsEntity.getReachedTime());
                    System.out.println("Mode of Transport: " + journeyDetailsEntity.getModeOfTransport());
                    System.out.println("Drive Mode: " + journeyDetailsEntity.getDriveMode());
                    System.out.println("Weather: " + journeyDetailsEntity.getWeather());
                    System.out.println("Duration: " + journeyDetailsEntity.getDuration());
                    System.out.println("Journey Type: " + journeyDetailsEntity.getJourneyType());
                    System.out.println("**********************************************************");
                    System.out.println("\n");
                }

                for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
                    System.out.println("**********************RESORT DETAILS*************************");
                    ResortEntity resortEntity = tourEntity.getResort().get(resort);
                    System.out.println("Resort ID: " + resortEntity.getResortId());
                    System.out.println("Tour ID: " + resortEntity.getTourid());
                    System.out.println("Resort From Date: " + resortEntity.getFromDate());
                    System.out.println("Resort To Date: " + resortEntity.getToDate());
                    System.out.println("Resort Name: " + resortEntity.getResortName());
                    System.out.println("Location: " + resortEntity.getResortLocation());
                    System.out.println("\n");
                    System.out.println("**********************ROOM DETAILS*************************");

                    for (int room = 0; room < resortEntity.getRoom().size(); room++) {
                        RoomEntity roomEntity = resortEntity.getRoom().get(room);
                        System.out.println("Room ID: " + roomEntity.getRoomId());
                        System.out.println("Resort ID: " + roomEntity.getResortId());
                        System.out.println("Room Type: " + roomEntity.getRoomType());
                        System.out.println("Room Cost Per Day: " + roomEntity.getCostPerDay());
                        System.out.println("Room No: " + roomEntity.getRoomNo());
                        System.out.println("\n");
                    }
                }

                for (int activity = 0; activity < tourEntity.getActivities().size(); activity++) {
                    System.out.println("**********************ACTIVITIES*************************");
                    ActivityEntity activityEntity = tourEntity.getActivities().get(activity);
                    System.out.println("Activity ID: " + activityEntity.getActivityId());
                    System.out.println("Tour ID: " + activityEntity.getTourid());
                    System.out.println("Activity Name: " + activityEntity.getActivityName());
                    System.out.println("Activity Start Time: " + activityEntity.getStartTime());
                    System.out.println("Activity End Time: " + activityEntity.getEndTime());
                    System.out.println("Activity Duration: " + activityEntity.getDuration());
                    System.out.println("Activity Cost: " + activityEntity.getCost());
                    System.out.println("Location: " + activityEntity.getLocation());
                    System.out.println("\n");
                }

                for (int connection = 0; connection < tourEntity.getConnections().size(); connection++) {
                    System.out.println("**********************CONNECTIONS*************************");
                    ConnectionEntity connectionEntity = tourEntity.getConnections().get(connection);
                    System.out.println("Connection ID: " + connectionEntity.getConnectionId());
                    System.out.println("Person ID: " + connectionEntity.getPersonId());
                    System.out.println("Connected to Person ID: " + connectionEntity.getConnectedToPersonId());
                    System.out.println("Tour ID: " + connectionEntity.getTourId());
                    System.out.println("Behaviour: " + connectionEntity.getBehaviour());
                    System.out.println("Intermediate Friends: " + connectionEntity.getIntermediateFriends());
                    System.out.println("Notes: " + connectionEntity.getNotes());
                    System.out.println("\n");
                }
            }
        }
    }
}
