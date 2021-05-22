package utils;

import java.text.ParseException;
import java.util.Date;

public class DateDifference {
    // Add mod value accordingly to calcuate total diff in yyyy mm dd MM:HH:SS
    public long findDifferenceInDays(Date startDate, Date endDate) throws ParseException {
        long differenceInTime = endDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24));
        return differenceInDays;
    }

    public long findDifferenceInHours(Date startDate, Date endDate) throws ParseException {
        long differenceInTime = endDate.getTime() - startDate.getTime();
        long differenceInHours = (differenceInTime / (1000 * 60 * 60));
        return differenceInHours;
    }

    public long findDifferenceInMinutes(Date startDate, Date endDate) throws ParseException {
        long differenceInTime = endDate.getTime() - startDate.getTime();
        long differenceInMinutes = (differenceInTime / (1000 * 60));
        return differenceInMinutes;
    }

    public long findDifferenceInSecond(Date startDate, Date endDate) throws ParseException {
        long differenceInTime = endDate.getTime() - startDate.getTime();
        long differenceInSeconds = (differenceInTime / 1000);
        return differenceInSeconds;
    }

    public static void main(String[] args) throws ParseException {
        DateDifference diff = new DateDifference();
        DateFormatter format = new DateFormatter();
        Date startDate = format.dateFormatter("2021-08-11 06:25:11");
        Date endDate = format.dateFormatter("2021-08-13 17:25:11");
        System.out.println(endDate);
        long daysValue = diff.findDifferenceInDays(startDate, endDate);
        System.out.println(daysValue);
        long hoursValue = diff.findDifferenceInHours(startDate, endDate);
        System.out.println(hoursValue);
    }

}
