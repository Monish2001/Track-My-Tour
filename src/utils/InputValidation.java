package utils;

import java.util.regex.*;

public class InputValidation {
    public String inputStringValidation(String inputString) {
        String validatedString = inputString.toLowerCase().trim();
        if (validatedString.isEmpty()) {
            return "Null";
        } else {
            return validatedString;
        }
    }

    public String trimString(String inputString) {
        String validatedString = inputString.trim();
        if (validatedString.isEmpty()) {
            return "Null";
        } else {
            return validatedString;
        }
    }

    public String intInputValidation(String inputString) {
        String validatedString = inputString.trim();
        if (validatedString.isEmpty()) {
            return "0";
        } else if (inputString.matches("[0-9]+")) {
            return validatedString;
        } else {
            String returnData = "Invalid input";
            return returnData;
        }
    }

    public String uuidValidation(String inputString) {
        String validatedString = inputString.trim().toLowerCase();
        if (validatedString.length() == 36) {
            return validatedString;
        } else {
            return "Invalid input";
        }
    }

}
