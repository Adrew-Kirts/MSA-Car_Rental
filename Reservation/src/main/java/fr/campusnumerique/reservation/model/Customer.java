package fr.campusnumerique.reservation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class Customer {
    int id;
    String firstName;
    String lastName;
    LocalDate birthdate;
    String licenseId;
    LocalDate licenseDate;

}
