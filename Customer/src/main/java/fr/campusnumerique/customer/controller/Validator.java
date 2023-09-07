package fr.campusnumerique.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;

public class Validator {

    public static int calculateAge(LocalDate birthdate){
        LocalDate currentDate = LocalDate.now();

        int currentAge = Period.between(birthdate, currentDate).getYears();

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
