package utils;

import java.util.Date;

public class DateDifference {
    public String findDifferenceInDates(Date startDate, Date endDate) {

        long difference_In_Time = endDate.getTime() - startDate.getTime();

        long difference_In_Seconds = (difference_In_Time / 1000) % 60;

        long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

        long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        String differenceString = difference_In_Years + " years, " + difference_In_Days + " days, "
                + difference_In_Hours + " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds
                + " seconds";

        return differenceString;
    }
}