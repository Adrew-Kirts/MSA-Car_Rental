package fr.campusnumerique.vehicle.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    int odometer;
    LocalDate dateReturn;

    float reservationPrice;
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
    List<MaintenanceTicket> maintenanceTicket;
    public Vehicle() {
        maintenanceTicket = new ArrayList<>();
    }


}