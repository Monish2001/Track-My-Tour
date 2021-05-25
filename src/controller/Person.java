package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Person {
	Scanner sc = new Scanner(System.in);

	public PersonEntity personDetails() {
		PersonEntity personData = new PersonEntity();
		List<String> phoneNumber = new ArrayList<String>();

		InputValidation validateString = new InputValidation();

		System.out.println("******PLEASE ENTER THE PERSON DETAILS**********");

		UUIDGenerator id = new UUIDGenerator();
		String personId = id.uuid();
		personData.setPersonId(personId);

		System.out.println("Name:");
		personData.setName(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Age:");
		personData.setAge(Integer.parseInt(validateString.intInputValidation(sc.nextLine())));

		System.out.println("Passion:");
		personData.setPassion(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Occupation:");
		personData.setOccupation(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("How many phone numbers do you want to add");
		int totalPhoneNoCount = Integer.parseInt(validateString.intInputValidation(sc.nextLine()));
		int addedPhoneNoCount = 0;

		while (addedPhoneNoCount < totalPhoneNoCount) {
			phoneNumber.add(validateString.inputStringValidation(sc.nextLine()));
			addedPhoneNoCount++;
		}

		personData.setPhoneNum(phoneNumber);

		System.out.println("For your information Person id is: " + personId);
		return personData;
	}
}