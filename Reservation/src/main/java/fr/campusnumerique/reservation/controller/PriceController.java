package fr.campusnumerique.reservation.controller;

public class PriceController {


//    Price calculation for a vehicle type car
    public static double carPrice(int mileage_estimation, float pricePerKm) {
        return pricePerKm*mileage_estimation;
    }

//    Price calculation for a vehicle type motorcycle
    public static double motorcyclePrice(int mileage_estimation, int displacement, float pricePerKm){
        return displacement*0.001*pricePerKm*mileage_estimation;
    }

//    Price calculation for a vehicle type utility
    public static double utilityPrice(int load_volume, int mileage_estimation, float pricePerKm){
        return load_volume*0.05*pricePerKm*mileage_estimation;
    }

}
