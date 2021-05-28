package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	public Date dateFormatter(String dateVal) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateVal);
			return date;
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}
}