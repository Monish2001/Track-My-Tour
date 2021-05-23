package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Activity {
	Scanner sc = new Scanner(System.in);

	public ActivityEntity activities() throws ParseException {
		ActivityEntity activity = new ActivityEntity();
		System.out.println("Please Enter the tour id");
		activity.setTourid(sc.nextLine());

		UUIDGenerator id = new UUIDGenerator();
		String activityId = id.uuid();
		activity.setActivityId(activityId);

		System.out.println("Activity Name:");
		activity.setActivityName(sc.nextLine().toLowerCase());

		System.out.println("Activity start time in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date activityStartTime = dateObj.dateFormatter(sc.nextLine());
		activity.setStartTime(activityStartTime);

		System.out.println("Activity end time in \"yyyy-MM-dd HH:mm:ss format:");
		Date resortEndTime = dateObj.dateFormatter(sc.nextLine());
		activity.setEndTime(resortEndTime);

		System.out.println("Duration:");
		activity.setDuration(Integer.parseInt(sc.nextLine()));

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(sc.nextLine()));

		System.out.println("Location:");
		activity.setLocation(sc.nextLine().toLowerCase());
		return activity;
	}
}
