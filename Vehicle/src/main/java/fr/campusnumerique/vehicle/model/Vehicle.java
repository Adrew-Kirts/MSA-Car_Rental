package fr.campusnumerique.vehicle.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    LocalDate datePickup;
    int odometerPickup;
    LocalDate dateReturn;
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
    @OneToMany
    ArrayList<MaintenanceTicket> maintenanceTicket;
    public Vehicle() {
        maintenanceTicket = new ArrayList<>();
    }


}