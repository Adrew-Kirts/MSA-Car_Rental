package fr.campusnumerique.vehicle.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Maintenance {

    private String maintenanceMessage;
    private int downtime;

    public Maintenance(String maintenanceMessage, int downtime) {
    }
}
