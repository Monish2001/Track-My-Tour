package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.Person;
import classes.Tour;
import utils.DateFormatter;
import utils.DateOperations;
import utils.InputValidation;

public class InputValueCheck {
    InputValidation validateString = new InputValidation();
    Scanner sc = new Scanner(System.in);
    DateFormatter dateObj = new DateFormatter();
    ConstantValueCheck constantValCheck = new ConstantValueCheck();
    DateOperations durationCalc = new DateOperations();

    public Date dateCheck() throws ParseException {

        boolean isDateOk = false;
        while (isDateOk == false) {
            String dateCheckStr = validateString.trimString(sc.nextLine());
            Date finalDateVariable;
            finalDateVariable = dateObj.dateFormatter(dateCheckStr);
            if (finalDateVariable == null) {
                isDateOk = false;
                System.out.println("Invalid input format!! Please try again");
                System.out.println("Please enter time format in \"yyyy-MM-dd HH:mm:ss:");
            } else {
                isDateOk = true;
                return finalDateVariable;
            }
        }
        return null;
    }

    public String intCheck() {

        boolean isIntCheckOk = false;
        while (isIntCheckOk == false) {
            String returnStr = validateString.intValidator(sc.nextLine());
            if (returnStr.equals("0")) {
                return "0";
            }
            if (returnStr.equals("invalid input")) {
                isIntCheckOk = false;
                System.out.println("Invalid input !! Please enter input in numbers");

            } else {
                isIntCheckOk = true;
                return returnStr;
            }
        }
        return null;
    }

    public String requiredIntFieldCheck() {

        boolean isRequiredIntFieldCheckIsOk = false;
        InputValueCheck currentClassObj = new InputValueCheck();
        while (isRequiredIntFieldCheckIsOk == false) {
            String intValue = currentClassObj.intCheck();
            if (intValue.equals("0")) {
                isRequiredIntFieldCheckIsOk = false;
                System.out.println("Input field cannot be empty!!");
            } else {
                isRequiredIntFieldCheckIsOk = true;
                return intValue;
            }
        }
        return null;
    }

    public String requiredStringFieldCheck() {
        boolean isRequiredStringFieldCheckIsOk = false;
        while (isRequiredStringFieldCheckIsOk == false) {
            String returnStr = validateString.inputStringValidation(sc.nextLine());
            if (returnStr.equals("Null")) {
                isRequiredStringFieldCheckIsOk = false;
                System.out.println("Input field cannot be empty!!");
            } else {
                isRequiredStringFieldCheckIsOk = true;
                return returnStr;
            }
        }
        return null;
    }

    public String uuidCheck() {

        boolean isUuidOk = true;
        while (isUuidOk == true) {
            String returnStr = validateString.uuidValidator(sc.nextLine());
            if (returnStr.equals("invalid input") || returnStr.equals("Null")) {
                isUuidOk = true;
                System.out.println("Invalid input!! Please enter the correct uuid");
            } else {
                isUuidOk = false;
                return returnStr;
            }
        }
        // return returnStr;
        return null;
    }

    public String codeCheck() {
        boolean isCodeOk = false;
        while (isCodeOk == false) {
            String returnStr = validateString.codeValidator(sc.nextLine());
            if (returnStr.equals("invalid input") || returnStr.equals("Null")) {
                isCodeOk = false;
                System.out.println("Invalid input!! Please enter the correct uuid");
            } else {
                isCodeOk = true;
                return returnStr;
            }
        }
        return null;
    }

    public String intermediateUuidCheck() {

        boolean isIntermediateUuidOk = true;
        while (isIntermediateUuidOk == true) {
            String inputVal = sc.nextLine();
            if (inputVal.isEmpty() || inputVal.equals("0")) {
                return "0";
            }
            String[] arrOfuuidStr = inputVal.split(",", 0);
            int lengthOfArrUuid = arrOfuuidStr.length;
            int correctUuidCount = 0;

            for (String uuid : arrOfuuidStr) {
                String trimmedUuid = uuid.trim();
                String returnValue = validateString.uuidValidator(trimmedUuid);
                if (!trimmedUuid.equals(returnValue)) {
                    isIntermediateUuidOk = true;
                    System.out.println("Invalid uuid!! Please reenter the uuid");
                } else {
                    correctUuidCount++;
                }
            }
            if (correctUuidCount == lengthOfArrUuid) {
                return inputVal;
            }
        }
        return "0";
    }

    public String commonChecker(String inputString) {
        if (inputString.equals("Null")) {
            return "Null";
        }
        boolean isUuidOk = true;
        while (isUuidOk == true) {
            if (inputString.equals("invalid input")) {
                isUuidOk = true;
                System.out.println("Invalid input!! Please enter the correct uuid");
            } else {
                isUuidOk = false;
                return inputString;
            }
        }
        return inputString;
    }

    public String journeyChecker() {
        Boolean inputValue = false;
        while (inputValue.equals(false)) {
            String typeOfJourney = validateString.inputStringValidation(sc.nextLine());
            if (typeOfJourney.equals("Null")) {
                return "Null";
            }
            boolean containsTypeOfJourney = constantValCheck.containsToj(typeOfJourney);
            if (containsTypeOfJourney == true) {
                inputValue = true;
                return typeOfJourney;
            } else {
                System.out.println("Please enter journey type as onward or backward");
            }
        }
        return null;
    }

    public Object[] activityDateInputCheck(Date[] tourFromToDates) throws ParseException {
        Boolean isActivityInputIsOk = false;
        InputValueCheck currentClassObj = new InputValueCheck();

        while (isActivityInputIsOk == false) {
            System.out.println("Start time in \"yyyy-MM-dd HH:mm:ss format:");
            Date activityStartTime = currentClassObj.dateCheck();

            System.out.println("Duration:-- Please enter how many hours and minutes");
            System.out.println("Hours: ");
            Integer hours = Integer.parseInt(currentClassObj.intCheck());
            System.out.println("Minutes: ");
            Integer minutes = Integer.parseInt(currentClassObj.intCheck());
            Integer[] totalMins = { hours, minutes };
            Integer totalMinutes = durationCalc.convertToMins(totalMins);

            Date activityEndTime = durationCalc.addDurationToDate(activityStartTime, totalMinutes);

            Date[] activityDates = { activityStartTime, activityEndTime };

            boolean dateRangeCheckVal = currentClassObj.activityDateRangeCheck(tourFromToDates, activityDates);

            if (dateRangeCheckVal == true) {
                Object[] returnValue = new Object[] { activityStartTime, activityEndTime, totalMinutes };
                isActivityInputIsOk = true;
                return returnValue;
            } else {
                isActivityInputIsOk = false;
            }
        }
        return null;
    }

    public boolean activityDateRangeCheck(Date[] tourFromToDates, Date[] activityDates) {
        Date tourFromDate = tourFromToDates[0];
        Date tourToDate = tourFromToDates[1];

        Date activityStartDate = activityDates[0];
        Date activityEndDate = activityDates[1];

        if (activityStartDate.compareTo(activityEndDate) <= 0 && activityEndDate.compareTo(activityStartDate) >= 0) {
            if (activityStartDate.compareTo(tourFromDate) >= 0 && activityEndDate.compareTo(tourToDate) <= 0) {
                return true;
            } else {
                System.out.println("Date range is not within the tour date range!!");
                return false;
            }
        } else {
            System.out.println("Please enter correct date range");
            return false;
        }

    }

    public String modeOfTransportChecker() {
        Boolean valueEntered = false;
        while (valueEntered.equals(false)) {
            String modeOfTransport = validateString.inputStringValidation(sc.nextLine());
            if (modeOfTransport.equals("Null")) {
                return "Null";
            }
            boolean containsModeOfTransport = constantValCheck.containsMot(modeOfTransport);
            if (containsModeOfTransport == true) {
                valueEntered = true;
                return modeOfTransport;
            } else {
                System.out.println("Please enter mode of transport as car or bike");
            }
        }
        return null;
    }

    public String doesPersonExists(List<Person> personList) {
        InputValueCheck presentClassobj = new InputValueCheck();
        Boolean inputValue = false;
        while (inputValue.equals(false)) {

            String code = presentClassobj.codeCheck();
            String personId = presentClassobj.getPersonId(personList, code);
            if (personId != null) {
                return personId;
            }
            // for (int person = 0; person < personList.size(); person++) {
            // Person personEntity = personList.get(person);
            // if (personEntity.getPersonId().equals(personId)) {
            // return personId;
            // }
            // }
            else {
                System.out.println("Person does not exists!! Please enter correct person id");
                inputValue = false;
            }
        }
        return null;
    }

    public String isConnectionOk(String ownerId, List<Person> personList) {
        Boolean inputValue = false;
        InputValueCheck currentClassObj = new InputValueCheck();
        while (inputValue.equals(false)) {
            String connectedPersonId = currentClassObj.doesPersonExists(personList);
            if (!connectedPersonId.equals(ownerId)) {
                return connectedPersonId;
            }
            System.out.println("Cannot connect to yourself");
            inputValue = false;
        }
        return null;
    }

    public Date[] dateRangeCheck() throws ParseException {
        Boolean inputValue = false;
        InputValueCheck currentClassObj = new InputValueCheck();
        while (inputValue.equals(false)) {
            System.out.println("Please enter the start date in \"yyyy-MM-dd HH:mm:ss format: ");
            Date startDate = currentClassObj.dateCheck();
            System.out.println("Please enter the end date in \"yyyy-MM-dd HH:mm:ss format: ");
            Date endDate = currentClassObj.dateCheck();
            if (startDate == null || endDate == null) {
                Date[] dates = { startDate, endDate };
                return dates;
            } else if (startDate.compareTo(endDate) <= 0 && endDate.compareTo(startDate) >= 0) {
                Date[] dates = { startDate, endDate };
                return dates;
            } else {
                System.out.println("Please enter the correct date range");
                inputValue = false;
            }
        }
        return null;
    }

    public Date[] tourDateRangeCheck(Date[] tourFromToDates) throws ParseException {
        Boolean inputValue = false;
        InputValueCheck currentClassObj = new InputValueCheck();

        Date tourFromDate = tourFromToDates[0];
        Date tourToDate = tourFromToDates[1];

        while (inputValue.equals(false)) {
            Date[] dateRange = currentClassObj.dateRangeCheck();
            Date startDate = dateRange[0];
            Date endDate = dateRange[1];
            if (startDate == null || endDate == null) {
                Date[] dates = { startDate, endDate };
                return dates;
            } else if (startDate.compareTo(tourFromDate) >= 0 && endDate.compareTo(tourToDate) <= 0) {
                Date[] dates = { startDate, endDate };
                return dates;
            } else {
                System.out.println("Date range is not within the tour date range!!");
                inputValue = false;
            }
        }
        return null;
    }

    public String getTourId(List<Tour> tourList, String code) {
        for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

            Tour tour = tourList.get(tourVariable);
            if (tour.getTourCode().equals(code)) {
                String tourId = tour.getTourId();
                return tourId;
            }
        }
        return null;
    }

    public String getPersonId(List<Person> personList, String code) {
        for (int personVariable = 0; personVariable < personList.size(); personVariable++) {
            Person person = personList.get(personVariable);
            if (person.getPersonCode().equals(code)) {
                String personId = person.getPersonId();
                return personId;
            }
        }
        return null;
    }
}