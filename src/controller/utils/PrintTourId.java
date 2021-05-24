package controller.utils;

import java.util.List;
import entities.*;

public class PrintTourId {
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
}
