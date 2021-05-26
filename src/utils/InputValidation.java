package utils;

import java.util.regex.*;

public class InputValidation {
    // InputValidation validatorObj = new InputValidation();

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

    public String uuidValidator(String inputString) {
        InputValidation validatorObj = new InputValidation();
        String validatedString = validatorObj.trimString(inputString);
        if (validatedString.isEmpty() || validatedString.equals("Null")) {
            return "Null";
        } else if (validatedString.length() == 36) {
            return validatedString;
        } else {
            return "invalid input";
        }
    }

    public String intValidator(String inputString) {
        InputValidation validatorObj = new InputValidation();
        String validatedString = validatorObj.trimString(inputString);
        if (validatedString.isEmpty() || validatedString.equals("Null")) {
            return "0";
        } else if (!validatedString.isEmpty()) {
            String regex = "[0-9]+";

            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher(validatedString);

            if (m.matches() == true) {
                return validatedString;
            }
        } else {
            return "invalid input";
        }
        return "invalid input";
    }
}
