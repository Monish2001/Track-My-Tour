package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import controller.utils.InputValueCheck;
import controller.utils.ConstantValueCheck;
import entities.*;
import utils.*;

public class JourneyDetails {
	Scanner sc = new Scanner(System.in);

	public JourneyDetailsEntity journeyDetails(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		ConstantValueCheck inputValueCheck = new ConstantValueCheck();

		JourneyDetailsEntity journeyDetailsData = new JourneyDetailsEntity();

		// System.out.println("Please Enter the tour id");
		journeyDetailsData.setTourId(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String journeyDetailsId = id.uuid();
		journeyDetailsData.setJourneyDetailsId(journeyDetailsId);

		System.out.println("Journey starting time in \"yyyy-MM-dd HH:mm:ss format:");
		Date journeyStartTime = valueCheck.dateCheck();
		journeyDetailsData.setStartTime(journeyStartTime);

		System.out.println("Journey reached time in \"yyyy-MM-dd HH:mm:ss format:");
		Date journeyReachedTime = valueCheck.dateCheck();
		;
		journeyDetailsData.setReachedTime(journeyReachedTime);

		System.out.println("Mode of transport: -- Please enter as car or bike");
		Boolean valueEntered = false;
		while (valueEntered.equals(false)) {
			String modeOfTransport = validateString.inputStringValidation(sc.nextLine());
			boolean containsModeOfTransport = inputValueCheck.containsMot(modeOfTransport);
			if (containsModeOfTransport == true) {
				journeyDetailsData.setModeOfTransport(modeOfTransport);
				valueEntered = true;
			} else {
				System.out.println("Please enter mode of transport as car or bike");
			}
		}

		System.out.println("Drive Mode:");
		journeyDetailsData.setDriveMode(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Weather:");
		journeyDetailsData.setWeather(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Duration:-- Please enter how many hours and minutes");
		System.out.println("Hours: ");
		Integer hours = Integer.parseInt(valueCheck.intCheck());
		System.out.println("Minutes: ");
		Integer minutes = Integer.parseInt(valueCheck.intCheck());
		Integer totalMinutes = (hours * 60) + minutes;
		journeyDetailsData.setDuration(totalMinutes);

		System.out.println("Journey Type: -- Please enter as onward or backward");
		Boolean inputValue = false;
		while (inputValue.equals(false)) {
			String typeOfJourney = validateString.inputStringValidation(sc.nextLine());
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
