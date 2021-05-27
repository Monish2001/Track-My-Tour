package controller;

import java.util.List;

import classes.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ToursOnDateRange {
    PrintDetails printDetails = new PrintDetails();

    public List<Tour> toursBasedOnDateRange(List<Tour> tourList, Date[] date) throws ParseException {

        Date startDateObj = date[0];
        Date endDateObj = date[1];
        List<Tour> toursOnDateRangeList = new ArrayList<Tour>();

        int tourCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() <= 0) {
                System.out.println("No journey detail entry is found!!");
                break;
            }
            Tour tour = tourList.get(tourVariable);
            Date tourStartDate = tour.getTourStartDate();
            Date tourEndDate = tour.getTourEndDate();
            if (tourStartDate != null && tourEndDate != null) {
                if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
                    tourCount++;
                    toursOnDateRangeList.add(tour);
                }
            }
        }
        if (tourCount == 0) {
            System.out.println("No such tour entries is found between the given date range");
        }
        return toursOnDateRangeList;
    }
}
