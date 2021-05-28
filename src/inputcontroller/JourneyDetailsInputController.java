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
		DateDifference durationCalc = new DateDifference();

		classes.JourneyDetails journeyDetailsData = new classes.JourneyDetails();

		// System.out.println("Please Enter the tour id");
		journeyDetailsData.setTourId(tourId);

		UUIDGenerator id = new UUIDGenerator();
		String journeyDetailsId = id.uuid();
		journeyDetailsData.setJourneyDetailsId(journeyDetailsId);

		Date[] dates = valueCheck.dateRangeCheck();
		Date journeyStartTime = dates[0];
		Date journeyReachedTime = dates[1];
		journeyDetailsData.setStartTime(journeyStartTime);
		journeyDetailsData.setReachedTime(journeyReachedTime);

		System.out.println("Mode of transport: -- Please enter as car or bike");
		String modeOfTransport = valueCheck.modeOfTransportChecker();
		journeyDetailsData.setModeOfTransport(modeOfTransport);

		System.out.println("Drive Mode:");
		journeyDetailsData.setDriveMode(validateString.inputStringValidation(sc.nextLine()));

		System.out.println("Weather:");
		journeyDetailsData.setWeather(validateString.inputStringValidation(sc.nextLine()));

		String diffString = durationCalc.findDifferenceInDates(journeyStartTime, journeyReachedTime);
		journeyDetailsData.setDuration(diffString);

		System.out.println("Journey Type: -- Please enter as onward or backward");
		String typeOfJourney = valueCheck.journeyChecker();
		journeyDetailsData.setJourneyType(typeOfJourney);

		return journeyDetailsData;
	}
}
