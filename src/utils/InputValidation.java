package utils;

public class InputValidation {
    public String inputStringValidation(String inpuString) {
        String validatedString = inpuString.toLowerCase().trim();
        return validatedString;
    }

    public String trimString(String inpuString) {
        String validatedString = inpuString.trim();
        return validatedString;
    }
}
