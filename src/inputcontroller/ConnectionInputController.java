package inputcontroller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import classes.Person;
import controller.InputValueCheck;
import controller.PrintDetails;
import utils.*;
import classes.Connection;

public class ConnectionInputController {
	Scanner sc = new Scanner(System.in);

	public Connection connections(String tourId, String tourCode, String personId, List<Person> personList,
			List<Connection> allConnectionsList) throws ParseException {
		Connection connection = new Connection();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		CodeGenerator codeGenerator = new CodeGenerator();
		UUIDGenerator id = new UUIDGenerator();
		PrintDetails printDetails = new PrintDetails();
		String personid = null;

		printDetails.printPersonDetails(personList);
		// System.out.println("Please Enter the tour id");
		if (tourId != null && tourCode != null) {
			connection.setTourId(tourId);
			connection.setTourCode(tourCode);
		} else {
			connection.setTourId(null);
			connection.setTourCode(null);
		}

		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);

		if (personId != null) {
			connection.setPersonId(personId);
		} else {
			System.out.println("Person id:");
			List<String> personCodeAndId = valueCheck.doesPersonExists(personList);
			personid = personCodeAndId.get(1);
			connection.setPersonId(personid);
		}

		String connectionCode = codeGenerator.getCode();
		connection.setConnectionCode(connectionCode);

		System.out.println("Connected to person id:");
		// connection.setConnectedToPersonId(valueCheck.uuidCheck());
		String connectedToPersonId = valueCheck.isConnectionOk(personId, personList);
		connection.setConnectedToPersonId(connectedToPersonId);

		System.out.println("Behaviour:");
		connection.setBehaviour(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Notes:");
		connection.setNotes(validateString.inputStringValidation(sc.nextLine()));

		System.out.println(
				"Intermediate friends ID --- Please press enter if none ,else enter comma separated id for more than 1 intermediate friends");

		if (personId != null) {
			List<String> intermediateFriends = valueCheck.intermediateUuidCheck(personList, personId,
					connectedToPersonId, allConnectionsList);
			if (intermediateFriends.size() == 1) {
				connection.setIntermediateFriends(intermediateFriends.get(0));
			} else {
				connection.setIntermediateFriendsCode(intermediateFriends.get(0));
				connection.setIntermediateFriends(intermediateFriends.get(1));
			}

		} else {
			List<String> intermediateFriends = valueCheck.intermediateUuidCheck(personList, personid,
					connectedToPersonId, allConnectionsList);
			if (intermediateFriends.size() == 1) {
				connection.setIntermediateFriends(intermediateFriends.get(0));
			} else {
				connection.setIntermediateFriendsCode(intermediateFriends.get(0));
				connection.setIntermediateFriends(intermediateFriends.get(1));
			}
		}
		System.out.println("**********************************************");
		return connection;

	}
}
