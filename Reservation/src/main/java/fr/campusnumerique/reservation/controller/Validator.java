package fr.campusnumerique.reservation.controller;

import java.time.LocalDate;
import java.time.Period;

public class Validator {

    public static int calculateAge(LocalDate birthdate){
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthdate, currentDate).getYears();
    }

}
