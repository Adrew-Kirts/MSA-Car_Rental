package fr.campusnumerique.vehicle.model;

import java.time.LocalDate;
import java.time.Period;

public class Maintenance {

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

    public int motorcycleMaintenanceControl(Vehicle vehicle){
        if (motorcycleBrakeFluidMaintenanceNeeded(vehicle) || motorcycleChainMaintenanceNeeded(vehicle)){
            return 1;
        }
        return 0;
    }

    public int vehicleMaintenanceControl(Vehicle vehicle){
        if(vehicleTimingBeltMaintenanceNeeded(vehicle)){
            return 3;
        }
        if(vehicleTireMaintenanceNeeded(vehicle)){
            return 1;
        }
        return 0;
    }

    public int utilityMaintenanceControl(Vehicle vehicle){
        if(utilitySuspensionMaintenanceNeeded(vehicle)){
            return 2;
        }
        return 0;
    }

    public int vehicleControl(Vehicle vehicle){
        if(vehicle.getType().equals("motorcycle")){
            return motorcycleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("car")){
            return vehicleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("utility")){
            return vehicleMaintenanceControl(vehicle) + utilityMaintenanceControl(vehicle);
        }
        return 0;
    }
}
