package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.model.Reservation;
import fr.campusnumerique.reservation.model.Vehicle;

import java.time.Period;

public class PriceController {


//    Price calculation for a vehicle type car
    public static double carPrice(Vehicle vehicle,Reservation reservation) {
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(vehicle.getMileageCost()*reservation.getMileageEstimation());
    }

//    Price calculation for a vehicle type motorcycle
    public static double motorcyclePrice(Vehicle vehicle, Reservation reservation){
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(vehicle.getDisplacement()*0.001*vehicle.getMileageCost()*reservation.getMileageEstimation());
    }

//    Price calculation for a vehicle type utility
    public static double utilityPrice(Vehicle vehicle, Reservation reservation){
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(vehicle.getLoadVolume()*0.05*vehicle.getMileageCost()*reservation.getMileageEstimation());
    }

    public static int dayCount(Reservation reservation){
        int dayCount = Period.between(reservation.getRentalEnd(),reservation.getRentalStart()).getDays();
        return dayCount;
    }

    public static double calculatePrice (Vehicle vehicle, Reservation reservation){
        switch (vehicle.getType()){
            case "car":
                return carPrice(vehicle,reservation);
            case "motorcycle":
                return motorcyclePrice(vehicle,reservation);
            case "utility":
                return utilityPrice(vehicle,reservation);
            default:
                return 0;
        }
    }
}
