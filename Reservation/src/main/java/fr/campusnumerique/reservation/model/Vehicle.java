package fr.campusnumerique.reservation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Vehicle {
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

//    @OneToMany
//    List<MaintenanceTicket> maintenanceTicket;
//    public Vehicle() {
//        maintenanceTicket = new ArrayList<>();
//    }


}