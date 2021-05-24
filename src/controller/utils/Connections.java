package controller.utils;

import java.util.List;

import entities.*;
import java.util.Scanner;

public class Connections {
    Scanner sc = new Scanner(System.in);
    PrintTourId printId = new PrintTourId();
    PersonNameFinder personNameFinder = new PersonNameFinder();

    /*
     * DISPLAYS DIRECT FRIENDS MET IN A TOUR WITH THE GIVEN TOUR ID AND PERSONLIST
     * IS USED TO FETCH THE NAME OF CONNECTION. HERE IF NO INTERMEDIATE FRIENDS THEN
     * 0 IS THE VALUE
     */
    public void directConnections(List<TourEntity> tourList, List<PersonEntity> personList) {
        if (tourList.size() == 0) {
            System.out.println(
                    "There is no tour entries yet!!Please add tour entries to find direct connections in a tour ");
            System.out.println("\n");
            System.out.println("If you want to perform any operation again please press no from 0 to 12");
            System.out.println("\n");
            return;
        }
        System.out.println("DIRECT FRIEND IN A TRIP");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printId.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourIdForDirectFriends = sc.nextLine();

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourEntity.getConnections().size() != 0) {
                if (tourIdForDirectFriends.equals(tourEntity.getTourId())) {
                    int friendsCount = 0;
                    System.out.println("DIRECT CONNECTIONS MADE IN A TOUR");
                    String personId = tourEntity.getConnections().get(0).getPersonId();
                    String personName = personNameFinder.getPersonName(personId, personList);
                    System.out.println(personName + " " + "Made direct connections with ");
                    for (int connection = 0; connection < tourEntity.getConnections().size(); connection++) {
                        ConnectionEntity connectionVar = tourEntity.getConnections().get(connection);
                        if (connectionVar.getIntermediateFriends().equals("0")) {
                            String connectedWithPersonId = connectionVar.getConnectedToPersonId();
                            String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId,
                                    personList);
                            System.out.println("Connected Person Name" + ": " + connectedPersonName);
                            friendsCount++;
                        }
                    }
                    if (friendsCount == 0) {
                        System.out.println("No direct friends in the trip");
                    }
                    break;
                }
            }
        }
    }

    public void indirectConnections(List<TourEntity> tourList, List<PersonEntity> personList) {
        System.out.println("FRIENDS OF FRIENDS IN A TOUR");
        System.out.println("\n");
        if (tourList.size() == 0) {
            System.out.println(
                    "There is no tour entries yet!! Please add tour entries to find friends of friends in a tour");
            System.out.println("\n");
            System.out.println("If you want to perform any operation again please press no from 0 to 12");
            System.out.println("\n");
            return;
        }
        System.out.println("Refer the tour id listed here");
        printId.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourIdForFriendsOfFriends = sc.nextLine();

        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            TourEntity tourEntity = tourList.get(tourVariable);
            if (tourEntity.getConnections().size() != 0) {
                if (tourIdForFriendsOfFriends.equals(tourEntity.getTourId())) {
                    int inDirectFriendsCount = 0;
                    System.out.println("INDIRECT CONNECTIONS MADE IN A TOUR");
                    String personId = tourEntity.getConnections().get(0).getPersonId();
                    String personName = personNameFinder.getPersonName(personId, personList);
                    System.out.println(personName + "Made indirect connections with: ");
                    for (int connection = 0; connection < tourEntity.getConnections().size(); connection++) {
                        ConnectionEntity connectionVar = tourEntity.getConnections().get(connection);
                        if (!connectionVar.getIntermediateFriends().equals("0")) {
                            String connectedWithPersonId = connectionVar.getConnectedToPersonId();
                            String connectedPersonName = personNameFinder.getPersonName(connectedWithPersonId,
                                    personList);
                            System.out.println("Connected Person Name" + ": " + connectedPersonName);
                            inDirectFriendsCount++;
                        }
                    }
                    if (inDirectFriendsCount == 0) {
                        System.out.println("No direct friends in the trip");
                        break;
                    }
                }
            }
        }
    }
}
