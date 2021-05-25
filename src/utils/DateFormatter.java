package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	public Date dateFormatter(String dateVal) throws ParseException {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateVal);
			return date;
		} catch (Exception e) {
			System.out.println("Wrong date format!!");
			// TODO: handle exception

		}
		return null;
	}
}