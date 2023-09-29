package fr.campusnumerique.vehicle.controller;

import fr.campusnumerique.vehicle.dao.VehicleRepository;
import fr.campusnumerique.vehicle.model.Vehicle;
import fr.campusnumerique.vehicle.model.MaintenanceTicket;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
        System.out.println(vehicle.getOdometer());
        if(timingBeltMaintenanceOld >= 100000){
            System.out.println("yo");
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

    public static List<MaintenanceTicket> motorcycleMaintenanceControl(Vehicle vehicle){
        List<MaintenanceTicket> maintenanceTicketList = new ArrayList<>();
        if (motorcycleBrakeFluidMaintenanceNeeded(vehicle)){
            maintenanceTicketList.add(new MaintenanceTicket("changement de liquide de frein",1));
        }
        if (motorcycleChainMaintenanceNeeded(vehicle)){
            maintenanceTicketList.add(new MaintenanceTicket("retendre la chaîne",1));
        }
        return maintenanceTicketList;
    }

    public static List<MaintenanceTicket> vehicleMaintenanceControl(Vehicle vehicle){
        List<MaintenanceTicket> maintenanceTicketsList = new ArrayList<>();
        if(vehicleTimingBeltMaintenanceNeeded(vehicle)){
            maintenanceTicketsList.add(new MaintenanceTicket("changer la courroie de distribution",3));
            System.out.println(maintenanceTicketsList);
        }
        if(vehicleTireMaintenanceNeeded(vehicle)){
            maintenanceTicketsList.add(new MaintenanceTicket("changer les pneus",1));
        }
        return maintenanceTicketsList;
    }

    public static MaintenanceTicket utilityMaintenanceControl(Vehicle vehicle){
        MaintenanceTicket maintenanceTicket = null;
        if(utilitySuspensionMaintenanceNeeded(vehicle)){
            maintenanceTicket = new MaintenanceTicket("changer les suspensions",2);
        }
        return maintenanceTicket;
    }

// return a list of maintenance ticket from vehicle.
    public static List<MaintenanceTicket> vehicleControl(Vehicle vehicle){
        List<MaintenanceTicket> maintenanceTicketsList = new ArrayList<>();
        if(vehicle.getType().equals("motorcycle")){
            maintenanceTicketsList = motorcycleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("car")){
            maintenanceTicketsList = vehicleMaintenanceControl(vehicle);
        }
        if(vehicle.getType().equals("utility")){
            maintenanceTicketsList = vehicleMaintenanceControl(vehicle);
            maintenanceTicketsList.add(utilityMaintenanceControl(vehicle));
        }
        System.out.println(vehicle.getMaintenanceTicket());
        return maintenanceTicketsList;
    }
}
