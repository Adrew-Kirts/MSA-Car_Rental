package fr.campusnumerique.vehicle.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String registration;
    String brand;
    String model;
    String color;
    int fiscal_hp;
    Date date_pickup;
    int odometer_pickup;
    Date date_return;
    int odometer_return;
    float cleaning_cost;
    float mileage_cost;
    String type;
    int displacement;
    int load_volume;


}