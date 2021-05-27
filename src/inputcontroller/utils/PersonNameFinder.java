package inputcontroller.utils;

import java.util.List;

import classes.*;

public class PersonNameFinder {
    /* THIS FUNCTION IS USED TO RETURN THE NAME TO CONNECTIONS MADE FUNCTION */
    public String getPersonName(String personId, List<Person> personList) {
        String personName = "None";
        for (int person = 0; person < personList.size(); person++) {
            Person personVar = personList.get(person);
            if (personId.equals(personVar.getPersonId())) {
                personName = personVar.getName();
                return personName;
            }
        }
        return personName;
    }
}
