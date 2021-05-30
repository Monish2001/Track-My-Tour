package inputcontroller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import classes.Person;
import controller.InputValueCheck;
import utils.*;
import classes.Connection;

public class ConnectionInputController {
	Scanner sc = new Scanner(System.in);

	public Connection connections(String tourId, String tourCode, String personId, List<Person> personList)
			throws ParseException {
		Connection connection = new Connection();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		CodeGenerator codeGenerator = new CodeGenerator();
		UUIDGenerator id = new UUIDGenerator();

		// System.out.println("Please Enter the tour id");
		connection.setTourId(tourId);
		connection.setTourCode(tourCode);

		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);

		// System.out.println("Person id:");
		connection.setPersonId(personId);

		String connectionCode = codeGenerator.getCode();
		connection.setConnectionCode(connectionCode);

		System.out.println("Connected to person id:");
		// connection.setConnectedToPersonId(valueCheck.uuidCheck());
		connection.setConnectedToPersonId(valueCheck.isConnectionOk(personId, personList));

		System.out.println("Behaviour:");
		connection.setBehaviour(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Notes:");
		connection.setNotes(validateString.inputStringValidation(sc.nextLine()));

		System.out.println(
				"Intermediate friends ID --- Please press enter if none ,else enter comma separated id for more than 1 intermediate friends");
		String intermediateFriends = valueCheck.intermediateUuidCheck();
		connection.setIntermediateFriends(intermediateFriends);

		System.out.println("**********************************************");
		return connection;

	}
}
