package fr.campusnumerique.reservation.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    LocalDate rentalStart;
    LocalDate rentalEnd;
    int mileageEstimation;
    int vehicleId;
    int customerId;
    double price;

}
