package controller;

import java.text.ParseException;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Connection {
	Scanner sc = new Scanner(System.in);

	public ConnectionEntity connections() throws ParseException {
		ConnectionEntity connection = new ConnectionEntity();
		InputValidation validateString = new InputValidation();

		System.out.println("Please Enter the tour id");
		connection.setTourId(validateString.trimString(sc.nextLine()));

		UUIDGenerator id = new UUIDGenerator();
		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);

		System.out.println("Person id:");
		connection.setPersonId(validateString.trimString(sc.nextLine()));

		System.out.println("Connected to person id:");
		connection.setConnectedToPersonId(validateString.trimString(sc.nextLine()));

		System.out.println("Behaviour:");
		connection.setBehaviour(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Notes:");
		connection.setNotes(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Intermediate friends ID --- Please enter 0 if none else enter comma separated id");
		connection.setIntermediateFriends(validateString.trimString(sc.nextLine()));

		return connection;

	}
}
