package controller;

import java.util.List;

import classes.*;

public class PrintDetails {

    public void printTotalCostOfTour(Integer totalCostOfTour) {
        System.out.println("Total cost of a single tour: " + totalCostOfTour);
    }

    public void printCostOfTourStay(Integer costForStay) {
        System.out.println("Total cost of tour stay in hotel is: " + costForStay);
    }

    public void costOfActivities(Integer totalActivityCost) {
        System.out.println("Total activity cost in this trip is: " + totalActivityCost);
    }

    public void printActivities(List<String> activities) {
        System.out.println("******ACTIVITIES ARE*******");
        for (String activity : activities) {
            System.out.println(activity);
        }
    }

    public void printCommonTourListSOP() {
        System.out.println("There is no tour entries. Please add some tour entry!!");
        System.out.println("\n");
        System.out.println("If you want to perform any operation again please press no from 1 to 11");
    }

    public void printDirectConnections(List<String> directConnectionNameList) {
        if (directConnectionNameList.size() == 1) {
            System.out.println("No direct connections made in this trip!!");
            return;
        }
        System.out.println("DIRECT CONNECTIONS MADE IN A TOUR");
        String selfPersonName = directConnectionNameList.get(0);
        System.out.println(selfPersonName + " " + "made direct connections with ");
        for (int connection = 1; connection < directConnectionNameList.size(); connection++) {
            System.out.println(directConnectionNameList.get(connection));
        }
    }

    public void printIndirectConnections(List<String> indirectConnectionNameList) {
        if (indirectConnectionNameList.size() == 0) {
            System.out.println("No indirect connections made in this trip!!");
            return;
        }
        System.out.println("INDIRECT CONNECTIONS MADE IN A TOUR");
        String selfPersonName = indirectConnectionNameList.get(0);
        System.out.println(selfPersonName + " " + "made indirect connections with: ");
        for (int connection = 1; connection < indirectConnectionNameList.size(); connection++) {
            System.out.println(indirectConnectionNameList.get(connection));
        }
    }

    public void printTourId(List<Tour> tourList) {
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tour = tourList.get(tourVariable);
            System.out.println("**********************PLEASE REFER FOR TOUR ID*************************");
            // System.out.println(CommonStrings.TOUR_ID + ": " + tour.getTourId());
            System.out.println(CommonStrings.TOUR_ID + ": " + tour.getTourCode());
            System.out.println(CommonStrings.TOUR_ORIGIN + ": " + tour.getOrigin());
            System.out.println(CommonStrings.TOUR_DESTINATION + ": " + tour.getDestination());
            System.out.println("**********************************************************");
            System.out.println("\n");
        }
    }

    public void printPersonDetails(List<Person> personList) {
        System.out.println("**********************PLEASE REFER FOR PERSON ID*************************");
        for (Person person : personList) {
            System.out.println("*******************************************************");
            System.out.println("Person Id: " + person.getPersonCode());
            System.out.println("Person name: " + person.getName());
            System.out.println("*******************************************************");
        }
    }

    public void printTourDetails(Tour tour) {
        System.out.println("**********************TOUR DETAILS*************************");
        System.out.println(CommonStrings.TOUR_ID + ": " + tour.getTourCode());
        System.out.println(CommonStrings.PERSON_ID + ": " + tour.getPersonCode());
        System.out.println(CommonStrings.TOUR_ORIGIN + ": " + tour.getOrigin());
        System.out.println(CommonStrings.TOUR_DESTINATION + ": " + tour.getDestination());
        System.out.println(CommonStrings.TOUR_START_DATE + ": " + tour.getTourStartDate());
        System.out.println(CommonStrings.TOUR_END_DATE + ": " + tour.getTourEndDate());
        System.out.println(CommonStrings.TYPE_OF_LOCATION + ": " + tour.getTypeOfLocation());
        System.out.println("**********************************************************");
        System.out.println("\n");
    }

    public void printJourneyDetails(JourneyDetails journeyDetails) {
        System.out.println("**********************JOURNEY DETAILS*************************");
        System.out.println("Journey Details ID: " + journeyDetails.getJourneyDetailsCode());
        System.out.println(CommonStrings.TOUR_ID + " " + journeyDetails.getTourCode());
        System.out.println("Journey Start Time: " + journeyDetails.getStartTime());
        System.out.println("Journey Reached Time:" + journeyDetails.getReachedTime());
        System.out.println("Mode of Transport: " + journeyDetails.getModeOfTransport());
        System.out.println("Drive Mode: " + journeyDetails.getDriveMode());
        System.out.println("Weather: " + journeyDetails.getWeather());
        System.out.println("Duration in minutes: " + journeyDetails.getDuration());
        System.out.println("Journey Type: " + journeyDetails.getJourneyType());
        System.out.println("**********************************************************");
        System.out.println("\n");
    }

    public void printResortDetails(Resort resort) {
        System.out.println("**********************RESORT DETAILS*************************");
        System.out.println("Resort ID: " + resort.getResortCode());
        System.out.println(CommonStrings.TOUR_ID + ": " + resort.getTourCode());
        System.out.println("Resort From Date: " + resort.getFromDate());
        System.out.println("Resort To Date: " + resort.getToDate());
        System.out.println("Resort Name: " + resort.getResortName());
        System.out.println("Location: " + resort.getResortLocation());
        System.out.println("\n");
    }

    public void printRoomDetails(Room room) {
        System.out.println("Room ID: " + room.getRoomCode());
        System.out.println("Resort ID: " + room.getResortCode());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Room Cost Per Day: " + room.getCostPerDay());
        System.out.println("No Of Nights: " + room.getNoOfNights());
        System.out.println("Room No: " + room.getRoomNo());
        System.out.println("\n");
    }

    public void printActivity(Activity activity) {
        System.out.println("**********************ACTIVITIES*************************");
        System.out.println("Activity ID: " + activity.getActivityId());
        System.out.println(CommonStrings.TOUR_ID + ": " + activity.getTourCode());
        System.out.println("Activity Name: " + activity.getActivityName());
        System.out.println("Activity Start Time: " + activity.getStartTime());
        System.out.println("Activity End Time: " + activity.getEndTime());
        System.out.println("Activity Duration in minutes: " + activity.getDuration());
        System.out.println("Activity Cost: " + activity.getCost());
        System.out.println("Location: " + activity.getLocation());
        System.out.println("\n");
    }

    public void printConnectionDetails(Connection connection, List<Person> personList) {
        PersonNameFinder personNameFinder = new PersonNameFinder();
        System.out.println("**********************CONNECTIONS*************************");
        // System.out.println("Connection ID: " + connection.getConnectionCode());
        System.out.println("Person name: " + personNameFinder.getPersonName(connection.getPersonId(), personList));
        System.out.println("Connected to person name: "
                + personNameFinder.getPersonName(connection.getConnectedToPersonId(), personList));
        // System.out.println(CommonStrings.TOUR_ID + ": " + connection.getTourCode());
        System.out.println("Behaviour: " + connection.getBehaviour());
        System.out.println("Intermediate Friends ID: " + connection.getIntermediateFriendsCode());
        System.out.println("Notes: " + connection.getNotes());
        System.out.println("\n");
    }
}
