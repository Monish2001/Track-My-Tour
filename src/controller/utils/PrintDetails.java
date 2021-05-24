package controller.utils;

import java.util.List;

import entities.*;

public class PrintDetails {

    public void printTotalCostOfTour(int totalCostOfTour) {
        System.out.println("Total cost of a single tour: " + totalCostOfTour);
    }

    public void printCostOfTourStay(int costForStay) {
        System.out.println("Total cost of tour stay in hotel is: " + costForStay);
    }

    public void costOfActivities(int totalActivityCost) {
        System.out.println("Total activity cost in this trip is: " + totalActivityCost);
    }

    public void printActivities(List<String> activities) {
        System.out.println("******ACTIVITIES ARE*******");
        for (String activity : activities) {
            System.out.println(activity);
        }
    }

    public void printTourId(List<TourEntity> tourList) {
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            TourEntity tourEntity = tourList.get(tourVariable);
            System.out.println("**********************PLEASE REFER FOR TOUR ID*************************");
            System.out.println("Tour ID: " + tourEntity.getTourId());
            System.out.println("Tour Origin: " + tourEntity.getOrigin());
            System.out.println("Tour Destination: " + tourEntity.getDestination());
            System.out.println("**********************************************************");
            System.out.println("\n");
        }
    }

    public void printTourDetails(TourEntity tourEntity) {
        System.out.println("**********************TOUR DETAILS*************************");
        System.out.println("Tour ID: " + tourEntity.getTourId());
        System.out.println("Person Id: " + tourEntity.getPersonId());
        System.out.println("Tour Origin: " + tourEntity.getOrigin());
        System.out.println("Tour Destination: " + tourEntity.getDestination());
        System.out.println("Tour Start Date: " + tourEntity.getTourStartDate());
        System.out.println("Tour End Date: " + tourEntity.getTourEndDate());
        System.out.println("Type of location: " + tourEntity.getTypeOfLocation());
        System.out.println("**********************************************************");
        System.out.println("\n");
    }

    public void printJourneyDetails(JourneyDetailsEntity journeyDetailsEntity) {
        System.out.println("**********************JOURNEY DETAILS*************************");
        System.out.println("Journey Details ID: " + journeyDetailsEntity.getJourneyDetailsId());
        System.out.println("Tour ID: " + journeyDetailsEntity.getTourId());
        System.out.println("Journey Start Time: " + journeyDetailsEntity.getStartTime());
        System.out.println("Journey Reached Time:" + journeyDetailsEntity.getReachedTime());
        System.out.println("Mode of Transport: " + journeyDetailsEntity.getModeOfTransport());
        System.out.println("Drive Mode: " + journeyDetailsEntity.getDriveMode());
        System.out.println("Weather: " + journeyDetailsEntity.getWeather());
        System.out.println("Duration in minutes: " + journeyDetailsEntity.getDuration());
        System.out.println("Journey Type: " + journeyDetailsEntity.getJourneyType());
        System.out.println("**********************************************************");
        System.out.println("\n");
    }

    public void printResortDetails(ResortEntity resortEntity) {
        System.out.println("**********************RESORT DETAILS*************************");
        System.out.println("Resort ID: " + resortEntity.getResortId());
        System.out.println("Tour ID: " + resortEntity.getTourid());
        System.out.println("Resort From Date: " + resortEntity.getFromDate());
        System.out.println("Resort To Date: " + resortEntity.getToDate());
        System.out.println("Resort Name: " + resortEntity.getResortName());
        System.out.println("Location: " + resortEntity.getResortLocation());
        System.out.println("\n");
    }

    public void printRoomDetails(RoomEntity roomEntity) {
        System.out.println("Room ID: " + roomEntity.getRoomId());
        System.out.println("Resort ID: " + roomEntity.getResortId());
        System.out.println("Room Type: " + roomEntity.getRoomType());
        System.out.println("Room Cost Per Day: " + roomEntity.getCostPerDay());
        System.out.println("Room No: " + roomEntity.getRoomNo());
        System.out.println("\n");
    }

    public void printActivity(ActivityEntity activityEntity) {
        System.out.println("**********************ACTIVITIES*************************");
        System.out.println("Activity ID: " + activityEntity.getActivityId());
        System.out.println("Tour ID: " + activityEntity.getTourid());
        System.out.println("Activity Name: " + activityEntity.getActivityName());
        System.out.println("Activity Start Time: " + activityEntity.getStartTime());
        System.out.println("Activity End Time: " + activityEntity.getEndTime());
        System.out.println("Activity Duration in minutes: " + activityEntity.getDuration());
        System.out.println("Activity Cost: " + activityEntity.getCost());
        System.out.println("Location: " + activityEntity.getLocation());
        System.out.println("\n");
    }

    public void printConnectionDetails(ConnectionEntity connectionEntity) {
        System.out.println("**********************CONNECTIONS*************************");
        System.out.println("Connection ID: " + connectionEntity.getConnectionId());
        System.out.println("Person ID: " + connectionEntity.getPersonId());
        System.out.println("Connected to Person ID: " + connectionEntity.getConnectedToPersonId());
        System.out.println("Tour ID: " + connectionEntity.getTourId());
        System.out.println("Behaviour: " + connectionEntity.getBehaviour());
        System.out.println("Intermediate Friends ID: " + connectionEntity.getIntermediateFriends());
        System.out.println("Notes: " + connectionEntity.getNotes());
        System.out.println("\n");
    }
}
