package fr.campusnumerique.vehicle.controller;

import fr.campusnumerique.vehicle.model.Vehicle;
import fr.campusnumerique.vehicle.model.MaintenanceTicket;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MaintenanceController {

    public static int lastMaintenanceOld(LocalDate lastMaintenanceDate){
        return Period.between(lastMaintenanceDate,LocalDate.now()).getDays();
    }

    public static boolean motorcycleChainMaintenanceNeeded(Vehicle vehicle){
        int chainMaintenanceOld = vehicle.getOdometer() - vehicle.getLastChainMaintenanceOdometer();
        if(lastMaintenanceOld(vehicle.getLastChainMaintenanceDate()) >= 365 || chainMaintenanceOld >= 1000){
            vehicle.setLastChainMaintenanceDate(LocalDate.now());
            vehicle.setLastChainMaintenanceOdometer(vehicle.getOdometer());
            return true;
        }
        return false;
    }

    public static boolean motorcycleBrakeFluidMaintenanceNeeded(Vehicle vehicle){
        if(lastMaintenanceOld(vehicle.getLastBrakeFluidMaintenanceDate()) >= 365 ){
            vehicle.setLastBrakeFluidMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public static boolean vehicleTimingBeltMaintenanceNeeded(Vehicle vehicle){
        int timingBeltMaintenanceOld = vehicle.getOdometer() - vehicle.getLastTimingBeltMaintenanceOdometer();
        if(timingBeltMaintenanceOld >= 100000){
            vehicle.setLastTimingBeltMaintenanceOdometer(vehicle.getOdometer());
            return true;
        }
        return false;
    }

    public static boolean vehicleTireMaintenanceNeeded(Vehicle vehicle){
        if(lastMaintenanceOld(vehicle.getLastTireMaintenanceDate()) >= 365){
            vehicle.setLastTireMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public static boolean utilitySuspensionMaintenanceNeeded(Vehicle vehicle){
        if (lastMaintenanceOld(vehicle.getLastSuspensionMaintenanceDate()) >= 730){
            vehicle.setLastSuspensionMaintenanceDate(LocalDate.now());
            return true;
        }
        return false;
    }

    public static void motorcycleMaintenanceControl(Vehicle vehicle){
        if (motorcycleBrakeFluidMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changement de liquide de frein",1));
        }
        if (motorcycleChainMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("retendre la chaîne",1));
        }
    }

    public static void vehicleMaintenanceControl(Vehicle vehicle){
        if(vehicleTimingBeltMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer la courroie de distribution",3));
        }
        if(vehicleTireMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer les pneus",1));
        }
    }

    public static void utilityMaintenanceControl(Vehicle vehicle){
        if(utilitySuspensionMaintenanceNeeded(vehicle)){
            vehicle.getMaintenanceTicket().add(new MaintenanceTicket("changer les suspensions",2));
        }
    }

// return a list of maintenance ticket from vehicle.
    public static List<MaintenanceTicket> vehicleControl(Vehicle vehicle){
        if(vehicle.getType().equals("motorcycle")){
            motorcycleMaintenanceControl(vehicle);
            return vehicle.getMaintenanceTicket();
        }
        if(vehicle.getType().equals("car")){
            vehicleMaintenanceControl(vehicle);
            return vehicle.getMaintenanceTicket();
        }
        if(vehicle.getType().equals("utility")){
            vehicleMaintenanceControl(vehicle);
            utilityMaintenanceControl(vehicle);
            return vehicle.getMaintenanceTicket();
        }
        return vehicle.getMaintenanceTicket();
    }
}
