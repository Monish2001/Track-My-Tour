package inputcontroller;

import classes.Tour;
import controller.InputValueCheck;
import controller.PrintDetails;
import utils.InputValidation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FunctionalityInputController {
    Scanner sc = new Scanner(System.in);
    PrintDetails printDetails = new PrintDetails();
    InputValidation validateString = new InputValidation();
    InputValueCheck valueCheck = new InputValueCheck();

    public String activities(List<Tour> tourList) {
        System.out.println("List of activities in a tour");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");

        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourCode = valueCheck.codeCheck();
        String tourId = valueCheck.getTourId(tourList, tourCode);
        // String tourId = valueCheck.uuidCheck();
        return tourId;
    }

    public String costOfSingleTour(List<Tour> tourList) {
        System.out.println("Total cost of a single trip");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourCode = valueCheck.codeCheck();
        String tourId = valueCheck.getTourId(tourList, tourCode);
        // String tourId = valueCheck.uuidCheck();
        return tourId;
    }

    public String costOfTourStay(List<Tour> tourList) {
        System.out.println("Cost for a single trip stay in hotel");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        String tourCode = valueCheck.codeCheck();
        String tourId = valueCheck.getTourId(tourList, tourCode);
        // String tourId = valueCheck.uuidCheck();
        return tourId;
    }

    public String toursBasedOnLocation() {
        System.out.println("Trips based on type of location");
        System.out.println("Please enter the type of location");
        String typeOfLocation = valueCheck.requiredStringFieldCheck();
        return typeOfLocation;
    }

    public String toursBasedOnTransport() {
        System.out.println("List trips based on transport");
        System.out.println("Please enter the type of transport");
        String modeOfTransport = valueCheck.requiredStringFieldCheck();
        return modeOfTransport;
    }

    public String directConnections(List<Tour> tourList) {
        System.out.println("DIRECT FRIEND IN A TRIP");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        // String tourIdForDirectFriends = valueCheck.uuidCheck();
        String tourCode = valueCheck.codeCheck();
        String tourIdForDirectFriends = valueCheck.getTourId(tourList, tourCode);
        return tourIdForDirectFriends;
    }

    public String inDirectConnections(List<Tour> tourList) {
        System.out.println("FRIENDS OF FRIENDS IN A TOUR");
        System.out.println("\n");
        System.out.println("Refer the tour id listed here");
        printDetails.printTourId(tourList);
        System.out.println("Please enter the tour id:");
        // String tourIdForIndirectConnections = valueCheck.uuidCheck();
        String tourCode = valueCheck.codeCheck();
        String tourIdForIndirectFriends = valueCheck.getTourId(tourList, tourCode);
        return tourIdForIndirectFriends;
    }

    public Date[] toursOnDateRange() throws ParseException {
        System.out.println("TRIPS WITH THE GIVEN DATE RANGE");
        System.out.println("Please enter the date range");
        System.out.println("Start Date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        Date startDate = valueCheck.dateCheck();
        System.out.println("End date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        Date endDate = valueCheck.dateCheck();
        Date[] date = { startDate, endDate };
        return date;
    }
}
