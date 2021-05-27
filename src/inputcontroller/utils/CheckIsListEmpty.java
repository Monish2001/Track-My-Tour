package inputcontroller.utils;

import java.util.List;

import classes.Person;
import classes.Tour;

public class CheckIsListEmpty {
    public boolean checkIsTourListEmpty(List<Tour> tourList) {
        if (tourList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsPersonListEmpty(List<Person> personList) {
        if (personList.size() == 0) {

            return true;
        } else {
            return false;
        }
    }

}
