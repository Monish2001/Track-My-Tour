package controller;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class Connections {
    PersonNameFinder personNameFinder = new PersonNameFinder();

    public List<String> directConnections(List<Tour> tourList, List<Person> personList, String tourId) {
        int touridMatchCount = 0;
        List<String> connectionNameList = new ArrayList<String>();

        if (tourList.size() == 0) {
            System.out.println(
                    "There is no tour entries yet!!Please add tour entries to find direct connections in a tour ");
            System.out.println("\n");
            System.out.println("If you want to perform any operation again please press no from 0 to 12");
            System.out.println("\n");
            return connectionNameList;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tour = tourList.get(tourVariable);
            if (tourId.equals(tour.getTourId())) {
                touridMatchCount = 1;
                if (tour.getConnections().size() == 0) {
                    System.out.println("No direct friends in this tour!!");
                    break;
                } else {
                    String personId = tour.getConnections().get(0).getPersonId();
                    String personName = personNameFinder.getPersonName(personId, personList);
                    connectionNameList.add(personName);

                    for (int connection = 0; connection < tour.getConnections().size(); connection++) {
                        Connection connectionVar = tour.getConnections().get(connection);

                        if (connectionVar.getIntermediateFriends().equals("0")) {
                            String connectedWithPersonId = connectionVar.getConnectedToPersonId();
                            String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId,
                                    personList);
                            connectionNameList.add(connectedPersonName);
                        }
                    }
                    break;
                }
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
            System.out.println("\n");
            System.out.println("If you want to perform any operation again please press no from 0 to 12");
            System.out.println("\n");
            return connectionNameList;
        }

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tour = tourList.get(tourVariable);
            if (tourIdForIndirectConnections.equals(tour.getTourId())) {
                touridMatchCount = 1;
                if (tour.getConnections().size() == 0) {
                    System.out.println("No friends of friends in this tour!!");
                    break;
                } else {
                    String personId = tour.getConnections().get(0).getPersonId();
                    String personName = personNameFinder.getPersonName(personId, personList);
                    connectionNameList.add(personName);

                    for (int connection = 0; connection < tour.getConnections().size(); connection++) {
                        Connection connectionVar = tour.getConnections().get(connection);

                        if (!connectionVar.getIntermediateFriends().equals("0")) {
                            String connectedWithPersonId = connectionVar.getConnectedToPersonId();
                            String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId,
                                    personList);
                            connectionNameList.add(connectedPersonName);
                        }

                    }
                    break;
                }
            }
        }
        if (touridMatchCount <= 0) {
            System.out.println("TourId didn't match with our tourId list!! Please try again with proper tourId!!");
        }
        return connectionNameList;
    }
}
