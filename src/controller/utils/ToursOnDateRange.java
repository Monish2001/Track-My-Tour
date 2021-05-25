package controller.utils;

import java.util.List;

import entities.*;
import utils.DateFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ToursOnDateRange {
    PrintDetails printDetails = new PrintDetails();

    public List<TourEntity> toursBasedOnDateRange(List<TourEntity> tourList, String[] date) throws ParseException {

        String startDate = date[0];
        String endDate = date[1];
        DateFormatter dateObj = new DateFormatter();
        Date startDateObj = dateObj.dateFormatter(startDate);
        Date endDateObj = dateObj.dateFormatter(endDate);
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
            if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
                tourCount++;
                toursOnDateRangeList.add(tourEntity);
            }
        }
        if (tourCount == 0) {
            System.out.println("No such tour entries is found between the given date range");
        }
        return toursOnDateRangeList;
    }
}
