package controller.utils;

import java.util.List;

import entities.*;
import java.util.Scanner;
import utils.DateFormatter;

import java.text.ParseException;
import java.util.Date;

public class ToursOnDateRange {
    Scanner sc = new Scanner(System.in);

    public void toursBasedOnDateRange(List<TourEntity> tourList) throws ParseException {
        System.out.println("TRIPS WITH THE GIVEN DATE RANGE");
        System.out.println("Please enter the date range");
        System.out.println("Start Date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        String startDate = sc.nextLine();
        System.out.println("End date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
        String endDate = sc.nextLine();

        DateFormatter dateObj = new DateFormatter();
        Date startDateObj = dateObj.dateFormatter(startDate);
        Date endDateObj = dateObj.dateFormatter(endDate);

        int tourCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() <= 0) {
                System.out.println("No journey detail entry is found!!");
                break;
            }
            TourEntity tourDetails = tourList.get(tourVariable);
            Date tourStartDate = tourDetails.getTourStartDate();
            Date tourEndDate = tourDetails.getTourEndDate();
            if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
                System.out.println("*******************************************");
                System.out.println("Tour ID: " + tourDetails.getTourId());
                System.out.println("Person Id: " + tourDetails.getPersonId());
                System.out.println("Origin: " + tourDetails.getOrigin());
                System.out.println("Destination: " + tourDetails.getDestination());
                System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
                System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
                System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
                System.out.println("*******************************************");
                System.out.println("\n");
                tourCount++;
            }
        }
        if (tourCount == 0) {
            System.out.println("No such tour entries is found between the given date range");
        }
    }
}
