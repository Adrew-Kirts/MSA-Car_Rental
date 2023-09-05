package fr.campusnumerique.reservation.model;

public class Prices {

//    Global price per km
    static double pricePerKm = 0.15;

//    Price calculation for a vehicle type car
    public static double carPrice(int mileage_estimation) {
        return pricePerKm*mileage_estimation;
    }

//    Price calculation for a vehicle type motorcycle
    public static double motorcyclePrice(int mileage_estimation, int displacement){
        return displacement*0.001*pricePerKm*mileage_estimation;
    }

//    Price calculation for a vehicle type utility
    public static double utilityPrice(int load_volume, int mileage_estimation){
        return load_volume*0.05*pricePerKm*mileage_estimation;
    }

}
