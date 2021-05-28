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
		DateOperations durationCalc = new DateOperations();

		Activity activity = new Activity();

		activity.setTourid(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		String activityName = validateString.inputStringValidation(sc.nextLine());
		activity.setActivityName(activityName);

		System.out.println("Start time in \"yyyy-MM-dd HH:mm:ss format:");
		Date activityStartTime = valueCheck.dateCheck();
		activity.setStartTime(activityStartTime);

		System.out.println("Duration:-- Please enter how many hours and minutes");
		System.out.println("Hours: ");
		Integer hours = Integer.parseInt(valueCheck.intCheck());
		System.out.println("Minutes: ");
		Integer minutes = Integer.parseInt(valueCheck.intCheck());
		Integer[] totalMins = { hours, minutes };
		Integer totalMinutes = durationCalc.convertToMins(totalMins);
		activity.setDuration(totalMinutes);

		Date activityEndDate = durationCalc.addDurationToDate(activityStartTime, totalMinutes);
		activity.setEndTime(activityEndDate);

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("Location:");
		activity.setLocation(validateString.inputStringValidation(sc.nextLine()));
		System.out.println("****************************************************");
		return activity;
	}
}
