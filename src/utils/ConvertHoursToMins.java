package utils;

public class ConvertHoursToMins {
    public Integer convertToMins(String[] dateStr) {
        Integer hours = Integer.parseInt(dateStr[0]);
        Integer mins = Integer.parseInt(dateStr[1]);
        Integer durationInMin = hours * 60 + mins;
        return durationInMin;
    }
}
