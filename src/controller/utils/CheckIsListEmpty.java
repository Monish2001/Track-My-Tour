package controller.utils;

import java.util.List;

import entities.PersonEntity;
import entities.TourEntity;

public class CheckIsListEmpty {
    public boolean checkIsTourListEmpty(List<TourEntity> tourList) {
        if (tourList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsPersonListEmpty(List<PersonEntity> personList) {
        if (personList.size() == 0) {

            return true;
        } else {
            return false;
        }
    }

}
