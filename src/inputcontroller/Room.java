package inputcontroller;

import java.text.ParseException;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.InputValidation;
import utils.UUIDGenerator;

public class Room {
	Scanner sc = new Scanner(System.in);

	public classes.Room roomDetails(String resortId) throws ParseException {
		classes.Room roomData = new classes.Room();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		// System.out.println("Please Enter the resort id");
		roomData.setResortId(resortId);

		UUIDGenerator id = new UUIDGenerator();
		String roomId = id.uuid();
		roomData.setRoomId(roomId);

		System.out.println("Room Type:");
		roomData.setRoomType(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Cost Per Day:");
		roomData.setCostPerDay(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("No of Nights");
		roomData.setNoOfNights(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("Room No:");
		roomData.setRoomNo(validateString.inputStringValidation(sc.nextLine()));

		Integer totalCost = roomData.getCostPerDay() * roomData.getNoOfNights();
		roomData.setTotalCost(totalCost);

		System.out.println("*****************************************************************");

		return roomData;
	}

}
