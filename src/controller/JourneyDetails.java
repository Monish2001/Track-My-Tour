package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import utils.*;

public class JourneyDetails {
	Scanner sc = new Scanner(System.in);

	public JourneyDetailsEntity journeyDetails() throws ParseException {

		JourneyDetailsEntity journeyDetailsData = new JourneyDetailsEntity();
		InputValidation validateString = new InputValidation();
		InputValueCheck inputValueCheck = new InputValueCheck();

		System.out.println("Please Enter the tour id");
		journeyDetailsData.setTourId(validateString.trimValidation(sc.nextLine()));

		UUIDGenerator id = new UUIDGenerator();
		String journeyDetailsId = id.uuid();
		journeyDetailsData.setJourneyDetailsId(journeyDetailsId);

		System.out.println("Journey starting time in \"yyyy-MM-dd HH:mm:ss.SSSSSS format:");
		DateFormatter dateObj = new DateFormatter();
		Date journeyStartTime = dateObj.dateFormatter(validateString.trimValidation(sc.nextLine()));
		journeyDetailsData.setStartTime(journeyStartTime);

		System.out.println("Journey reached time in \"yyyy-MM-dd HH:mm:ss.SSSSSS format:");
		Date journeyReachedTime = dateObj.dateFormatter(validateString.trimValidation(sc.nextLine()));
		journeyDetailsData.setReachedTime(journeyReachedTime);

		System.out.println("Mode of transport: -- Please enter as car or bike");
		Boolean valueEntered = false;
		while (valueEntered.equals(false)) {
			String modeOfTransport = validateString.validation(sc.nextLine());
			boolean containsModeOfTransport = inputValueCheck.containsMot(modeOfTransport);
			if (containsModeOfTransport == true) {
				journeyDetailsData.setModeOfTransport(modeOfTransport);
				valueEntered = true;
			} else {
				System.out.println("Please enter mode of transport as car or bike");
			}
		}
		System.out.println("Drive Mode:");
		journeyDetailsData.setDriveMode(validateString.validation(sc.nextLine()));

		System.out.println("Weather:");
		journeyDetailsData.setWeather(validateString.validation(sc.nextLine()));

		System.out.println("Duration:");
		journeyDetailsData.setDuration(Integer.parseInt(validateString.trimValidation(sc.nextLine())));

		System.out.println("Journey Type: -- Please enter as onward or backward");
		Boolean inputValue = false;
		while (inputValue.equals(false)) {
			String typeOfJourney = validateString.validation(sc.nextLine());
			boolean containsTypeOfJourney = inputValueCheck.containsToj(typeOfJourney);
			if (containsTypeOfJourney == true) {
				journeyDetailsData.setJourneyType(typeOfJourney);
				inputValue = true;
			} else {
				System.out.println("Please enter journey type as onward or backward");
			}
		}
		return journeyDetailsData;
	}
}
