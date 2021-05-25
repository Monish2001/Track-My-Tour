package controller;

import java.text.ParseException;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Connection {
	Scanner sc = new Scanner(System.in);
	InputValidation validateString = new InputValidation();

	public ConnectionEntity connections(String tourId, String personId) throws ParseException {
		ConnectionEntity connection = new ConnectionEntity();

		// System.out.println("Please Enter the tour id");
		connection.setTourId(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);

		// System.out.println("Person id:");
		connection.setPersonId(personId);

		System.out.println("Connected to person id:");
		connection.setConnectedToPersonId(validateString.trimString(sc.nextLine()));

		System.out.println("Behaviour:");
		connection.setBehaviour(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Notes:");
		connection.setNotes(validateString.inputStringValidation(sc.nextLine()));

		System.out.println(
				"Intermediate friends ID --- Please enter 0 if none else enter comma separated id for more than 1 intermediate friends");
		connection.setIntermediateFriends(validateString.trimString(sc.nextLine()));

		return connection;

	}
}
