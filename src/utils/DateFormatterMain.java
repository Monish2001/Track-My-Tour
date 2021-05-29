package utils;

import java.text.ParseException;
import java.util.Date;

public class DateFormatterMain {

    public static void main(String[] args) throws ParseException {
        utils.DateFormatter obj = new utils.DateFormatter();
        Date id = obj.dateFormatter(" ");
        System.out.println(id);
    }

}