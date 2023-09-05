package fr.campusnumerique.customer.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String first_name;
    String last_name;
    Date birthdate;
    String license_id;
//    Date license_date;

}
