package fr.campusnumerique.customer.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String firstName;
    String lastName;
    LocalDate birthdate;
    String licenseId;
    LocalDate licenseDate;

}
