package inputcontroller.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.Person;
import utils.DateFormatter;
import utils.InputValidation;

public class InputValueCheck {
    InputValidation validateString = new InputValidation();
    Scanner sc = new Scanner(System.in);
    DateFormatter dateObj = new DateFormatter();
    ConstantValueCheck constantValCheck = new ConstantValueCheck();

    public Date dateCheck() throws ParseException {

        boolean isDateOk = true;
        while (isDateOk == true) {
            String dateCheckStr = validateString.trimString(sc.nextLine());
            Date finalDateVariable;
            if (dateCheckStr.equals("Null")) {
                return null;
            }
            finalDateVariable = dateObj.dateFormatter(dateCheckStr);
            if (finalDateVariable == null) {
                isDateOk = true;
                System.out.println("Invalid input format!! Please try again");
                System.out.println("Please enter time format in \"yyyy-MM-dd HH:mm:ss:");
            } else {
                isDateOk = false;
                return finalDateVariable;
            }
        }
        return null;
    }

    public String intCheck() {

        boolean isIntCheckOk = true;
        while (isIntCheckOk == true) {
            String returnStr = validateString.intValidator(sc.nextLine());
            if (returnStr.equals("0")) {
                return "0";
            }
            if (returnStr.equals("invalid input")) {
                isIntCheckOk = true;
                System.out.println("Invalid input !! Please enter input in numbers");

            } else {
                isIntCheckOk = false;
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

            String personId = presentClassobj.uuidCheck();
            for (int person = 0; person < personList.size(); person++) {
                Person personEntity = personList.get(person);
                if (personEntity.getPersonId().equals(personId)) {
                    return personId;
                }
            }
            System.out.println("Person does not exists!! Please enter correct person id");
            inputValue = false;
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
}
