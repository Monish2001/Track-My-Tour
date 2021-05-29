package utils;

import java.util.Calendar;
import java.util.Date;

public class DateOperations {
    public Integer convertToMins(Integer[] dateStr) {
        Integer hours = dateStr[0];
        Integer mins = dateStr[1];
        Integer durationInMin = (hours * 60) + mins;
        return durationInMin;
    }

    public Date addDurationToDate(Date startTime, Integer minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        c.add(Calendar.MINUTE, minutes);
        Date activityEndDate = c.getTime();
        return activityEndDate;
    }
}
