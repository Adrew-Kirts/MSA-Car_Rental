package fr.campusnumerique.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Validator {

    public static int calculateAge(Date birthdate){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.from(birthdate.toInstant());

        int currentAge = Period.between(dateOfBirth, currentDate).getYears();

        if (currentAge < 18){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "You need to be over 18 years old to reserve a vehicle");
        }

        return currentAge;
    }

    public static void licenseValidator(String license_id){
        RestTemplate restTemplate = new RestTemplate();

        if (!restTemplate.getForObject("http://localhost:8088/licenses/"+license_id, Boolean.class)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "License number not found"
            );
        }
    }


}
