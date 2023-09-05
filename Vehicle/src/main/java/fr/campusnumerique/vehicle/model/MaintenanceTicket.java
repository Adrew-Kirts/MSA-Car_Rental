package fr.campusnumerique.vehicle.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MaintenanceTicket {
    @Id
    private Long id;
    private String maintenanceMessage;
    private int downtime;

    public MaintenanceTicket(String maintenanceMessage, int downtime) {
    }

    public MaintenanceTicket() {

    }

}
