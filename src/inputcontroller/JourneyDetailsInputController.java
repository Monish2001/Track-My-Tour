package inputcontroller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.*;

public class JourneyDetailsInputController {
	Scanner sc = new Scanner(System.in);

	public classes.JourneyDetails journeyDetails(String tourId) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();

		classes.JourneyDetails journeyDetailsData = new classes.JourneyDetails();

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
		journeyDetailsData.setReachedTime(journeyReachedTime);

		System.out.println("Mode of transport: -- Please enter as car or bike");
		String modeOfTransport = valueCheck.modeOfTransportChecker();
		journeyDetailsData.setModeOfTransport(modeOfTransport);

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
		String typeOfJourney = valueCheck.journeyChecker();
		journeyDetailsData.setJourneyType(typeOfJourney);

		return journeyDetailsData;
	}
}
