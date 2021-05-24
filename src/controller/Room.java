package controller;

import java.text.ParseException;
//import java.util.Date;
import java.util.Scanner;

import entities.RoomEntity;
//import utils.DateDifference;
//import utils.DateFormatter;
import utils.UUIDGenerator;

public class Room {
	Scanner sc = new Scanner(System.in);

	public RoomEntity roomDetails() throws ParseException {
		RoomEntity roomData = new RoomEntity();

		System.out.println("Please Enter the resort id");
		roomData.setResortId(sc.nextLine());

		UUIDGenerator id = new UUIDGenerator();
		String roomId = id.uuid();
		roomData.setRoomId(roomId);

		System.out.println("Room Type:");
		roomData.setRoomType(sc.nextLine().toLowerCase());

		System.out.println("Cost Per Day:");
		roomData.setCostPerDay(Integer.parseInt(sc.nextLine()));

		System.out.println("No of Nights");
		roomData.setNoOfNights(Integer.parseInt(sc.nextLine()));

		System.out.println("Room No:");
		roomData.setRoomNo(sc.nextLine().toLowerCase());

		Integer totalCost = roomData.getCostPerDay() * roomData.getNoOfNights();
		roomData.setTotalCost(totalCost);

		return roomData;
	}

}
