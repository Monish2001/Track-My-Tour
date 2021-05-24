package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Activity {
	Scanner sc = new Scanner(System.in);

	public ActivityEntity activities() throws ParseException {
		InputValidation validateString = new InputValidation();

		ActivityEntity activity = new ActivityEntity();
		System.out.println("Please Enter the tour id");
		activity.setTourid(validateString.trimString(sc.nextLine()));

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		activity.setActivityName(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Activity start time in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date activityStartTime = dateObj.dateFormatter(validateString.trimString(sc.nextLine()));
		activity.setStartTime(activityStartTime);

		System.out.println("Activity end time in \"yyyy-MM-dd HH:mm:ss format:");
		Date resortEndTime = dateObj.dateFormatter(validateString.trimString(sc.nextLine()));
		activity.setEndTime(resortEndTime);

		System.out.println("Duration:-- Please enter in HH:mm format");
		String dateStr = validateString.inputStringValidation(sc.nextLine());
		String[] splittedDate = dateStr.split(":", 2);
		ConvertHoursToMins convertHoursToMins = new ConvertHoursToMins();
		Integer mins = convertHoursToMins.convertToMins(splittedDate);
		activity.setDuration(mins);

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(validateString.trimString(sc.nextLine()));

		System.out.println("Location:");
		activity.setLocation(validateString.inputStringValidation(sc.nextLine()));
		return activity;
	}
}
