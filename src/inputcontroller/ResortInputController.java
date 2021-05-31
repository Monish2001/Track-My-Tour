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

	public classes.Resort resortDetails(String tourId, String tourCode, Date[] tourFromToDates) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		UUIDGenerator id = new UUIDGenerator();
		CodeGenerator codeGenerator = new CodeGenerator();
		DateDifference dateDifference = new DateDifference();

		classes.Resort resortData = new classes.Resort();
		RoomInputController roomInputController = new RoomInputController();
		List<classes.Room> roomList = new ArrayList<classes.Room>();

		// System.out.println("Please Enter the tour id");
		resortData.setTourid(tourId);
		resortData.setTourCode(tourCode);

		String resortId = id.uuid();
		resortData.setResortId(resortId);

		String resortCode = codeGenerator.getCode();
		resortData.setResortCode(resortCode);

		Date[] dates = valueCheck.tourDateRangeCheck(tourFromToDates);
		Date resortFromDate = dates[0];
		Date resortToDate = dates[1];
		resortData.setFromDate(resortFromDate);
		resortData.setToDate(resortToDate);

		System.out.println("Resort Name:");
		resortData.setResortName(valueCheck.requiredStringFieldCheck());

		System.out.println("Location:");
		resortData.setResortLocation(validateString.inputStringValidation(sc.nextLine()));

		Integer resortDuration = dateDifference.findDifferenceInDays(resortFromDate, resortToDate);

		System.out.println("*****************PLEASE ENTER ROOM DETAILS***************");
		System.out.println("How many rooms do you need to add");
		int count = Integer.parseInt(valueCheck.intCheck());
		int index = 0;
		while (index < count) {
			roomList.add(roomInputController.roomDetails(resortId, resortCode, resortDuration));
			index++;
		}
		resortData.setRoom(roomList);
		return resortData;
	}

}
