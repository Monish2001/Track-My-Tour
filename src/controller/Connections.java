package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class Connections {
    PersonNameFinder personNameFinder = new PersonNameFinder();
    Tour tour = new Tour();

    public List<String> directConnectionsInATour(List<Tour> tourList, List<Person> personList, String tourId) {
        int touridMatchCount = 0;
        List<String> connectionNameList = new ArrayList<String>();

        if (tourList.size() == 0) {
            System.out.println(
                    "There is no tour entries yet!!Please add tour entries to find direct connections in a tour ");
            return connectionNameList;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tourDetails = tourList.get(tourVariable);
            if (tourId.equals(tourDetails.getTourId())) {
                touridMatchCount = 1;
                List<String> directConnections = tour.directConnectionOfTour(tourDetails, personList);
                return directConnections;
            }
        }
        if (touridMatchCount <= 0) {
            System.out.println("TourId didn't match with our tourId list!! Please try again with proper tourId!!");
        }
        return connectionNameList;
    }

    public List<String> indirectConnections(List<Tour> tourList, List<Person> personList,
            String tourIdForIndirectConnections) {

        int touridMatchCount = 0;
        List<String> connectionNameList = new ArrayList<String>();
        if (tourList.size() == 0) {
            System.out.println(
                    "There is no tour entries yet!! Please add tour entries to find friends of friends in a tour");
            return connectionNameList;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tourDetails = tourList.get(tourVariable);
            if (tourIdForIndirectConnections.equals(tourDetails.getTourId())) {
                touridMatchCount = 1;
                List<String> indirectConnections = tour.indirectConnectionsOfTour(tourDetails, personList);
                return indirectConnections;
            }
        }
        if (touridMatchCount <= 0) {
            System.out.println("TourId didn't match with our tourId list!! Please try again with proper tourId!!");
        }
        return connectionNameList;
    }
}
