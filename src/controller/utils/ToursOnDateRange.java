package controller.utils;

import java.util.List;

import entities.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ToursOnDateRange {
    PrintDetails printDetails = new PrintDetails();

    public List<TourEntity> toursBasedOnDateRange(List<TourEntity> tourList, Date[] date) throws ParseException {

        Date startDateObj = date[0];
        Date endDateObj = date[1];
        List<TourEntity> toursOnDateRangeList = new ArrayList<TourEntity>();

        int tourCount = 0;
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
            if (tourList.size() <= 0) {
                System.out.println("No journey detail entry is found!!");
                break;
            }
            TourEntity tourEntity = tourList.get(tourVariable);
            Date tourStartDate = tourEntity.getTourStartDate();
            Date tourEndDate = tourEntity.getTourEndDate();
            if (tourStartDate != null && tourEndDate != null) {
                if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
                    tourCount++;
                    toursOnDateRangeList.add(tourEntity);
                }
            }
        }
        if (tourCount == 0) {
            System.out.println("No such tour entries is found between the given date range");
        }
        return toursOnDateRangeList;
    }
}
