package utils;

public class InputValidation {
    public String validation(String inpuString) {
        String validatedString = inpuString.toLowerCase().trim();
        return validatedString;
    }

    public String trimValidation(String inpuString) {
        String validatedString = inpuString.trim();
        return validatedString;
    }
}
