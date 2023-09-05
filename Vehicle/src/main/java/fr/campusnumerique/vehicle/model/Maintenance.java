package fr.campusnumerique.vehicle.model;

import java.time.LocalDate;
import java.time.Period;

public class Maintenance {

    public int lastMaintenanceOld(LocalDate lastMaintenanceDate){
        return Period.between(lastMaintenanceDate,LocalDate.now()).getDays();
    }

    public boolean motorcycleChainMaintenanceNeeded(int odometer,int lastChainMaintenanceOdometer , LocalDate lastChainMaintenaceDate){
        int chainMaintenanceOld = odometer - lastChainMaintenanceOdometer;
        return lastMaintenanceOld(lastChainMaintenaceDate) >= 365 || chainMaintenanceOld >= 1000;
    }

    public boolean motorcycleBrakeFluidMaintenanceNeeded (LocalDate lastBrakeFluidMaintenanceDate){
        return lastMaintenanceOld(lastBrakeFluidMaintenanceDate) >= 365;
    }

    public boolean vehicleTimingBeltMaintenanceNeeded(int odometer, int lastTimingBeltMaintenanceOdometer){
        int timingBeltMaintenanceOld = odometer - lastTimingBeltMaintenanceOdometer;
        return timingBeltMaintenanceOld >= 100000;
    }

    public boolean vehicleTireMaintenanceNeeded(LocalDate lastTireMaintenanceDate){
        return lastMaintenanceOld(lastTireMaintenanceDate) >= 365;
    }

    public boolean utilitySuspensionMaintenanceNeeded(LocalDate lastSuspensionMaintenanceDate){
        return lastMaintenanceOld(lastSuspensionMaintenanceDate) >= 730;
    }

    public int motorcycleMaintenanceControl(Vehicle vehicle){
        if (motorcycleBrakeFluidMaintenanceNeeded(vehicle.getLastBrakeFluidMaintenanceDate()) || motorcycleChainMaintenanceNeeded(vehicle.getOdometerReturn(),vehicle.getLastChainMaintenanceOdometer(),vehicle.getLastChainMaintenanceDate())){
            return 1;
        }
        return 0;
    }

    public int vehicleMaintenanceControl(Vehicle vehicle){
        if(vehicleTimingBeltMaintenanceNeeded(vehicle.getOdometerReturn(),vehicle.getLastTimingBeltMaintenanceOdometer())){
            return 3;
        }
        if(vehicleTireMaintenanceNeeded(vehicle.getLastTireMaintenanceDate())){
            return 1;
        }
        return 0;
    }

    public int utilityMaintenanceControl(Vehicle vehicle){
        if(utilitySuspensionMaintenanceNeeded(vehicle.getLastSuspensionMaintenanceDate())){
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
