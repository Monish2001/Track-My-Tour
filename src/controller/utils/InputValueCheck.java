package controller.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import utils.DateFormatter;
import utils.InputValidation;

public class InputValueCheck {
    InputValidation validateString = new InputValidation();
    Scanner sc = new Scanner(System.in);
    DateFormatter dateObj = new DateFormatter();
    // InputValueCheck valueCheck = new InputValueCheck();

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
            if (returnStr.equals("Null")) {
                return "Null";
            }
            if (returnStr.equals("invalid input")) {
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
            if (inputVal.isEmpty()) {
                return "0";
            }
            String[] arrOfuuidStr = inputVal.split(",", 0);
            int lengthOfArrUuid = arrOfuuidStr.length;
            int correctUuidCount = 0;

            for (String uuid : arrOfuuidStr) {
                // String returnStr = validateString.uuidValidator(sc.nextLine());
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
}
