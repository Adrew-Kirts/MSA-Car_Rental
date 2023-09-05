package fr.campusnumerique.vehicle.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
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
    int fiscalHp;
    Date datePickup;
    int odometerPickup;
    Date dateReturn;
    int odometerReturn;
    float cleaningCost;
    float mileageCost;
    String type;
    int displacement;
    int loadVolume;
    LocalDate lastBrakeFluidMaintenanceDate;
    LocalDate lastTireMaintenanceDate;
    int lastTimingBeltMaintenanceOdometer;
    int lastChainMaintenanceOdometer;
    LocalDate lastChainMaintenanceDate;
    LocalDate lastSuspensionMaintenanceDate;

}