package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.RoomEntity;
import utils.DateDifference;
import utils.DateFormatter;
import utils.UUIDGenerator;

public class Room {
	Scanner sc = new Scanner(System.in);

	public RoomEntity roomDetails() throws ParseException {
		RoomEntity roomData = new RoomEntity();

		System.out.println("******PLEASE ENTER THE ROOM DETAILS**********");

		System.out.println("Please Enter the resort id");
		roomData.setResortId(sc.nextLine());

		UUIDGenerator id = new UUIDGenerator();
		String roomId = id.uuid();
		roomData.setRoomId(roomId);

		System.out.println("Room fromDate in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date roomFromDate = dateObj.dateFormatter(sc.nextLine());
		roomData.setRoomFromDate(roomFromDate);

		System.out.println("Room toDate in \"yyyy-MM-dd HH:mm:ss format:");
		Date roomToDate = dateObj.dateFormatter(sc.nextLine());
		roomData.setRoomToDate(roomToDate);

		System.out.println("Room Type:");
		roomData.setRoomType(sc.nextLine());

		System.out.println("Cost Per Day:");
		roomData.setCostPerDay(Integer.parseInt(sc.nextLine()));

		// System.out.println("No of Nights");
		DateDifference daysDiff = new DateDifference();
		long noOfNights = daysDiff.findDifferenceInDays(roomFromDate, roomToDate);
		roomData.setNoOfNights(noOfNights);

		// System.out.println("Total Cost");
		if (roomData.getNoOfNights() <= 0) {
			long noOfHours = daysDiff.findDifferenceInHours(roomFromDate, roomToDate);
			long totalCost = noOfHours * roomData.getCostPerDay() / 24;
			roomData.setTotalCost(totalCost);
		} else {
			long totalCost = roomData.getNoOfNights() * roomData.getCostPerDay();
			roomData.setTotalCost(totalCost);
		}

		System.out.println("Room No:");
		roomData.setRoomNo(sc.nextLine());

		return roomData;
	}

}
