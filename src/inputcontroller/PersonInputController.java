package inputcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.*;

public class PersonInputController {
	Scanner sc = new Scanner(System.in);

	public classes.Person personDetails() {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		CodeGenerator codeGenerator = new CodeGenerator();
		UUIDGenerator id = new UUIDGenerator();

		classes.Person personData = new classes.Person();
		List<String> phoneNumber = new ArrayList<String>();

		System.out.println("******PLEASE ENTER THE PERSON DETAILS**********");

		String personId = id.uuid();
		personData.setPersonId(personId);

		String personCode = codeGenerator.getCode();
		personData.setPersonCode(personCode);

		System.out.println("Name:");
		personData.setName(valueCheck.requiredStringFieldCheck());

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

		System.out.println("For your information Person id is: " + personCode);
		return personData;
	}
}