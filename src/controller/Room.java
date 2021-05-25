package controller;

import java.text.ParseException;
import java.util.Scanner;

import entities.RoomEntity;
import utils.InputValidation;
import utils.UUIDGenerator;

public class Room {
	Scanner sc = new Scanner(System.in);

	public RoomEntity roomDetails(String resortId) throws ParseException {
		RoomEntity roomData = new RoomEntity();
		InputValidation validateString = new InputValidation();

		// System.out.println("Please Enter the resort id");
		roomData.setResortId(resortId);

		UUIDGenerator id = new UUIDGenerator();
		String roomId = id.uuid();
		roomData.setRoomId(roomId);

		System.out.println("Room Type:");
		roomData.setRoomType(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Cost Per Day:");
		roomData.setCostPerDay(Integer.parseInt(validateString.trimString(sc.nextLine())));

		System.out.println("No of Nights");
		roomData.setNoOfNights(Integer.parseInt(validateString.trimString(sc.nextLine())));

		System.out.println("Room No:");
		roomData.setRoomNo(validateString.inputStringValidation(sc.nextLine()));

		Integer totalCost = roomData.getCostPerDay() * roomData.getNoOfNights();
		roomData.setTotalCost(totalCost);

		System.out.println("*****************************************************************");

		return roomData;
	}

}
