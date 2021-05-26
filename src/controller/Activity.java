package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import controller.utils.InputValueCheck;
import entities.*;
import utils.*;

public class Activity {
	Scanner sc = new Scanner(System.in);

	public ActivityEntity activities(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		ActivityEntity activity = new ActivityEntity();

		activity.setTourid(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		String validatedString = validateString.inputStringValidation(sc.nextLine());
		activity.setActivityName(validatedString);

		System.out.println("Activity start time in \"yyyy-MM-dd HH:mm:ss format:");
		Date activityStartTime = valueCheck.dateCheck();
		activity.setStartTime(activityStartTime);

		System.out.println("Activity end time in \"yyyy-MM-dd HH:mm:ss format:");
		Date activityEndTime = valueCheck.dateCheck();
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
