package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.model.Vehicle;

public class PriceController {


//    Price calculation for a vehicle type car
    public static double carPrice(Vehicle vehicle, int dayCount, int mileageEstimate) {
        return (vehicle.getReservationPrice()*dayCount)+vehicle.getCleaningCost()+(vehicle.getMileageCost()*mileageEstimate);
    }

//    Price calculation for a vehicle type motorcycle
    public static double motorcyclePrice(Vehicle vehicle, int dayCount, int mileageEstimate){
        return (vehicle.getReservationPrice()*dayCount)+vehicle.getCleaningCost()+(vehicle.getDisplacement()*0.001*vehicle.getMileageCost()*mileageEstimate);
    }

//    Price calculation for a vehicle type utility
    public static double utilityPrice(Vehicle vehicle, int dayCount, int mileageEstimate){
        return (vehicle.getReservationPrice()*dayCount)+vehicle.getCleaningCost()+(vehicle.getLoadVolume()*0.05*vehicle.getMileageCost()*mileageEstimate);
    }

    public double calculatePrice (Vehicle vehicle, int dayCount, int mileageEstimate){
        switch (vehicle.getType()){
            case "car":
                return carPrice(vehicle,dayCount,mileageEstimate);
            case "motorcycle":
                return motorcyclePrice(vehicle,dayCount,mileageEstimate);
            case "utility":
                return utilityPrice(vehicle,dayCount,mileageEstimate);
            default:
                return 0;
        }
    }
}
