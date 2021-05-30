package inputcontroller;

import java.text.ParseException;
import java.util.Scanner;
import classes.*;

import controller.InputValueCheck;
import utils.CodeGenerator;
import utils.InputValidation;
import utils.UUIDGenerator;

public class RoomInputController {
	Scanner sc = new Scanner(System.in);
	Resort resortObj = new Resort();

	public classes.Room roomDetails(String resortId, String resortCode) throws ParseException {
		classes.Room roomData = new classes.Room();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		CodeGenerator codeGenerator = new CodeGenerator();
		UUIDGenerator id = new UUIDGenerator();

		// System.out.println("Please Enter the resort id");
		roomData.setResortId(resortId);
		roomData.setResortCode(resortCode);

		String roomId = id.uuid();
		roomData.setRoomId(roomId);

		String roomCode = codeGenerator.getCode();
		roomData.setRoomCode(roomCode);

		System.out.println("Room Type:");
		roomData.setRoomType(valueCheck.requiredStringFieldCheck());

		System.out.println("Cost Per Day:");
		roomData.setCostPerDay(Integer.parseInt(valueCheck.requiredIntFieldCheck()));

		System.out.println("No of Nights");
		roomData.setNoOfNights(Integer.parseInt(valueCheck.requiredIntFieldCheck()));

		System.out.println("Room No:");
		roomData.setRoomNo(validateString.inputStringValidation(sc.nextLine()));

		Integer totalCost = resortObj.totalCostOfRoom(roomData);
		roomData.setTotalCost(totalCost);

		System.out.println("*****************************************************************");

		return roomData;
	}

}
