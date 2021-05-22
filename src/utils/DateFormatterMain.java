package utils;

import java.text.ParseException;
import java.util.Date;

public class DateFormatterMain {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		utils.DateFormatter obj = new utils.DateFormatter();
		Date id = obj.dateFormatter("2018-02-21 12:12:12.000000");
		System.out.println(id);
	}

}
