package utils;

public class InputValueCheck {
    enum ModeOfTransport {
        car, bike
    };

    public boolean containsMot(String inputString) {

        for (ModeOfTransport mot : ModeOfTransport.values()) {
            if (mot.name().equals(inputString)) {
                return true;
            }
        }

        return false;
    }

    enum TypeOfJourney {
        onward, backward
    };

    public boolean containsToj(String inputString) {

        for (TypeOfJourney toj : TypeOfJourney.values()) {
            if (toj.name().equals(inputString)) {
                return true;
            }
        }

        return false;
    }

}
