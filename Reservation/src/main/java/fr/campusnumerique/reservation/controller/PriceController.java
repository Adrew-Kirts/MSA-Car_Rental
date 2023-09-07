package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.model.Reservation;
import fr.campusnumerique.reservation.model.Vehicle;

import java.time.Period;

public class PriceController {

    public static double carMileagePrice(float mileageCost,int mileage){
        return mileageCost*mileage;
    }
//    Price calculation for a vehicle type car
    public static double carPrice(Vehicle vehicle,Reservation reservation) {
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(carMileagePrice(vehicle.getMileageCost(),reservation.getMileageEstimation()));
    }

    public static double motorcycleMileagePrice(int displacement,float mileageCost,int mileage){
        return displacement*0.001*mileageCost*mileage;
    }
//    Price calculation for a vehicle type motorcycle
    public static double motorcyclePrice(Vehicle vehicle, Reservation reservation){
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(motorcycleMileagePrice(vehicle.getDisplacement(),vehicle.getMileageCost(),reservation.getMileageEstimation()));
    }

    public static double utilityMileagePrice(int loadVolume,float mileageCost,int mileage){
        return loadVolume*0.05*mileageCost*mileage;
    }
//    Price calculation for a vehicle type utility
    public static double utilityPrice(Vehicle vehicle, Reservation reservation){
        return (vehicle.getReservationPrice()*dayCount(reservation))+vehicle.getCleaningCost()+(utilityMileagePrice(vehicle.getLoadVolume(),vehicle.getMileageCost(),reservation.getMileageEstimation()));
    }

    public static int dayCount(Reservation reservation){
        int dayCount = Period.between(reservation.getRentalStart(),reservation.getRentalEnd()).getDays();
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
    public static double calculateMileagePrice (Vehicle vehicle, int mileage){
        switch (vehicle.getType()){
            case "car":
                return carMileagePrice(vehicle.getMileageCost(),mileage);
            case "motorcycle":
                return motorcycleMileagePrice(vehicle.getDisplacement(),vehicle.getMileageCost(),mileage);
            case "utility":
                return utilityMileagePrice(vehicle.getLoadVolume(),vehicle.getMileageCost(),mileage);
            default:
                return 0;
        }
    }

}
