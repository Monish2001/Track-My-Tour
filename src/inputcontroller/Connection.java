package inputcontroller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import classes.Person;
import inputcontroller.utils.InputValueCheck;
import utils.*;

public class Connection {
	Scanner sc = new Scanner(System.in);

	public classes.Connection connections(String tourId, String personId, List<Person> personList)
			throws ParseException {
		classes.Connection connection = new classes.Connection();
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		// System.out.println("Please Enter the tour id");
		connection.setTourId(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);

		// System.out.println("Person id:");
		connection.setPersonId(personId);

		System.out.println("Connected to person id:");
		// connection.setConnectedToPersonId(valueCheck.uuidCheck());
		connection.setConnectedToPersonId(valueCheck.isConnectionOk(personId, personList));

		System.out.println("Behaviour:");
		connection.setBehaviour(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Notes:");
		connection.setNotes(validateString.inputStringValidation(sc.nextLine()));

		System.out.println(
				"Intermediate friends ID --- Please press enter if none ,else enter comma separated id for more than 1 intermediate friends");

		connection.setIntermediateFriends(valueCheck.intermediateUuidCheck());

		System.out.println("**********************************************");
		return connection;

	}
}