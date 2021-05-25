package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Activity {
	Scanner sc = new Scanner(System.in);

	public ActivityEntity activities(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();

		ActivityEntity activity = new ActivityEntity();
		// System.out.println("Please Enter the tour id");
		activity.setTourid(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		activity.setActivityName(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Activity start time in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date activityStartTime = dateObj.dateFormatter(validateString.trimString(sc.nextLine()));
		activity.setStartTime(activityStartTime);

		// System.out.println("Activity end time in \"yyyy-MM-dd HH:mm:ss format:");
		// Date resortEndTime =
		// dateObj.dateFormatter(validateString.trimString(sc.nextLine()));
		// activity.setEndTime(resortEndTime);

		System.out.println("Duration:-- Please enter how many hours and minutes");
		System.out.println("Hours: ");
		Integer hours = Integer.parseInt(validateString.intInputValidation(sc.nextLine()));
		System.out.println("Minutes: ");
		Integer minutes = Integer.parseInt(validateString.intInputValidation(sc.nextLine()));
		Integer totalMinutes = (hours * 60) + minutes;
		activity.setDuration(totalMinutes);

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(validateString.intInputValidation(sc.nextLine())));

		System.out.println("Location:");
		activity.setLocation(validateString.inputStringValidation(sc.nextLine()));
		return activity;
	}
}
