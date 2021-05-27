package inputcontroller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.*;
import classes.*;

public class ActivityInputController {
	Scanner sc = new Scanner(System.in);

	public Activity activities(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		Activity activity = new Activity();

		activity.setTourid(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		String activityName = validateString.inputStringValidation(sc.nextLine());
		activity.setActivityName(activityName);

		Date[] dates = valueCheck.dateRangeCheck();
		Date activityStartTime = dates[0];
		Date activityEndTime = dates[1];
		activity.setStartTime(activityStartTime);
		activity.setEndTime(activityEndTime);

		System.out.println("Duration:-- Please enter how many hours and minutes");
		System.out.println("Hours: ");
		Integer hours = Integer.parseInt(valueCheck.intCheck());
		System.out.println("Minutes: ");
		Integer minutes = Integer.parseInt(valueCheck.intCheck());
		Integer totalMinutes = (hours * 60) + minutes;
		activity.setDuration(totalMinutes);

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("Location:");
		activity.setLocation(validateString.inputStringValidation(sc.nextLine()));
		System.out.println("****************************************************");
		return activity;
	}
}
