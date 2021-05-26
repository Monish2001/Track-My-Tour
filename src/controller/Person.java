package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.utils.InputValueCheck;
import entities.*;
import utils.*;

public class Person {
	Scanner sc = new Scanner(System.in);

	public PersonEntity personDetails() {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		PersonEntity personData = new PersonEntity();
		List<String> phoneNumber = new ArrayList<String>();

		System.out.println("******PLEASE ENTER THE PERSON DETAILS**********");

		UUIDGenerator id = new UUIDGenerator();
		String personId = id.uuid();
		personData.setPersonId(personId);

		System.out.println("Name:");
		personData.setName(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Age:");
		personData.setAge(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("Passion:");
		personData.setPassion(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Occupation:");
		personData.setOccupation(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("How many phone numbers do you want to add");
		int totalPhoneNoCount = Integer.parseInt(valueCheck.intCheck());
		int addedPhoneNoCount = 0;

		while (addedPhoneNoCount < totalPhoneNoCount) {
			phoneNumber.add(valueCheck.intCheck());
			addedPhoneNoCount++;
		}

		personData.setPhoneNum(phoneNumber);

		System.out.println("For your information Person id is: " + personId);
		return personData;
	}
}