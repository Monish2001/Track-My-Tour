package controller.utils;

import java.util.List;

import entities.*;

public class PersonNameFinder {
    /* THIS FUNCTION IS USED TO RETURN THE NAME TO CONNECTIONS MADE FUNCTION */
    public String getPersonName(String personId, List<PersonEntity> personList) {
        String personName = "None";
        for (int person = 0; person < personList.size(); person++) {
            PersonEntity personVar = personList.get(person);
            if (personId.equals(personVar.getPersonId())) {
                personName = personVar.getName();
                return personName;
            }
        }
        return personName;
    }
}
