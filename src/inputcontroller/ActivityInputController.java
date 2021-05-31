package inputcontroller;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import controller.InputValueCheck;
import utils.*;
import classes.*;

public class ActivityInputController {
	Scanner sc = new Scanner(System.in);

	public Activity activities(String tourId, String tourCode, Date[] tourFromToDates) throws ParseException {
		InputValidation validateString = new InputValidation();
		InputValueCheck valueCheck = new InputValueCheck();
		CodeGenerator codeGenerator = new CodeGenerator();
		UUIDGenerator id = new UUIDGenerator();

		Activity activity = new Activity();

		activity.setTourid(tourId);
		activity.setTourCode(tourCode);

		String activityId = id.uuid();
		activity.setActivityId(activityId);

		String activityCode = codeGenerator.getCode();
		activity.setActivityCode(activityCode);

		System.out.println("Activity Name:");
		String activityName = valueCheck.requiredStringFieldCheck();
		activity.setActivityName(activityName);

		Object[] activityDateValues = valueCheck.activityDateInputCheck(tourFromToDates);

		Date activityStartTime = (Date) activityDateValues[0];
		Date activityEndTime = (Date) activityDateValues[1];
		Integer totalMinutes = (Integer) activityDateValues[2];

		activity.setStartTime(activityStartTime);
		activity.setEndTime(activityEndTime);
		activity.setDuration(totalMinutes);

		System.out.println("Cost:");
		activity.setCost(Integer.parseInt(valueCheck.intCheck()));

		System.out.println("Location:");
		activity.setLocation(validateString.inputStringValidation(sc.nextLine()));
		System.out.println("****************************************************");
		return activity;
	}
}
