package inputcontroller;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.*;

public class ResortInputController {
	Scanner sc = new Scanner(System.in);

	public classes.Resort resortDetails(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		classes.Resort resortData = new classes.Resort();
		RoomInputController roomInputController = new RoomInputController();
		List<classes.Room> roomList = new ArrayList<classes.Room>();

		// System.out.println("Please Enter the tour id");
		resortData.setTourid(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String resortId = id.uuid();
		resortData.setResortId(resortId);

		Date[] dates = valueCheck.dateRangeCheck();
		Date resortFromDate = dates[0];
		Date resortToDate = dates[1];
		resortData.setFromDate(resortFromDate);
		resortData.setToDate(resortToDate);

		System.out.println("Resort Name:");
		resortData.setResortName(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Location:");
		resortData.setResortLocation(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("\n");
		System.out.println("Your resort id is: " + resortData.getResortId());
		System.out.println("\n");

		System.out.println("*****************PLEASE ENTER ROOM DETAILS***************");
		System.out.println("How many rooms do you need to add");
		int count = Integer.parseInt(valueCheck.intCheck());
		int index = 0;
		while (index < count) {
			roomList.add(roomInputController.roomDetails(resortId));
			index++;
		}
		resortData.setRoom(roomList);
		return resortData;
	}

}
