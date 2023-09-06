package fr.campusnumerique.vehicle.controller;

import fr.campusnumerique.vehicle.model.Vehicle;
import fr.campusnumerique.vehicle.model.MaintenanceTicket;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MaintenanceController {

    public int lastMaintenanceOld(LocalDate lastMaintenanceDate){
        return Period.between(lastMaintenanceDate,LocalDate.now()).getDays();
    }

    public boolean motorcycleChainMaintenanceNeeded(Vehicle vehicle){
        int chainMaintenanceOld = vehicle.getOdometerReturn() - vehicle.getLastChainMaintenanceOdometer();
        if(lastMaintenanceOld(vehicle.getLastChainMaintenanceDate()) >= 365 || chainMaintenanceOld >= 1000){
            vehicle.setLastChainMaintenanceDate(LocalDate.now());
            vehicle.setLastChainMaintenanceOdometer(vehicle.getOdometerReturn());
            return true;
        }
        return false;
    }

    public boolean motorcycleBrakeFluidMaintenanceNeeded(Vehicle vehicle){
        if(lastMaintenanceOld(vehicle.getLastBrakeFluidMaintenanceDate()) >= 365 ){
            vehicle.setLastBrakeFluidMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public boolean vehicleTimingBeltMaintenanceNeeded(Vehicle vehicle){
        int timingBeltMaintenanceOld = vehicle.getOdometerReturn() - vehicle.getLastTimingBeltMaintenanceOdometer();
        if(timingBeltMaintenanceOld >= 100000){
            vehicle.setLastTimingBeltMaintenanceOdometer(vehicle.getOdometerReturn());
            return true;
        }
        return false;
    }

    public boolean vehicleTireMaintenanceNeeded(Vehicle vehicle){
        if(lastMaintenanceOld(vehicle.getLastTireMaintenanceDate()) >= 365){
            vehicle.setLastTireMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public boolean utilitySuspensionMaintenanceNeeded(Vehicle vehicle){
        if (lastMaintenanceOld(vehicle.getLastSuspensionMaintenanceDate()) >= 730){
            vehicle.setLastSuspensionMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public void motorcycleMaintenanceControl(Vehicle vehicle){
        if (motorcycleBrakeFluidMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changement de liquide de frein",1));
        }
        if (motorcycleChainMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("retendre la chaîne",1));
        }
    }

    public void vehicleMaintenanceControl(Vehicle vehicle){
        if(vehicleTimingBeltMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer la courroie de distribution",3));
        }
        if(vehicleTireMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer les pneus",1));
        }
    }

    public void utilityMaintenanceControl(Vehicle vehicle){
        if(utilitySuspensionMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer les suspensions",2));
        }
    }

// return a list of maintenance ticket from vehicle.
    public List<MaintenanceTicket> vehicleControl(Vehicle vehicle){
        if(vehicle.getType().equals("motorcycle")){
            motorcycleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("car")){
            vehicleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("utility")){
            vehicleMaintenanceControl(vehicle);
            utilityMaintenanceControl(vehicle);
        }
        return vehicle.getMaintenanceTicket();
    }
}
