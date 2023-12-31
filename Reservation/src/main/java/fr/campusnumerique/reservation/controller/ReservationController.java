package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.dao.ReservationRepository;
import fr.campusnumerique.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getAllReservationsForVehicle(int id){
        return reservationRepository.findReservationPlanning(id);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id) {
        return reservationRepository.findById(id);
    }

    public void isAgeHpOk(Customer customer, Vehicle vehicle){
        if (Validator.calculateAge(customer.getBirthdate()) < 21 && vehicle.getFiscalHp() > 8) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too young!!!");

        } else if (Validator.calculateAge(customer.getBirthdate()) < 25 && vehicle.getFiscalHp() > 13) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too much power!!!");
        }
    }
    public void isVehicleAvailable (Reservation reservation){
        if(!reservationRepository.isBooked(reservation.getVehicleId(), reservation.getRentalStart(), reservation.getRentalEnd()).isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "already reserved!!!");
        }
    }
    public void isCustomerNotAlreadyEngage (Reservation reservation){
        if(!reservationRepository.isEngage(reservation.getCustomerId(),reservation.getRentalStart(),reservation.getRentalEnd()).isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "already engaged!!!");
        }
    }
    @PostMapping
    public Optional<Reservation> addReservations(@RequestBody Reservation reservation) {
        Customer customer = restTemplate.getForObject("http://MSA-CUSTOMER/customers/" + reservation.getCustomerId(), Customer.class);
        Vehicle vehicle = restTemplate.getForObject("http://MSA-VEHICLE/vehicles/" + reservation.getVehicleId(), Vehicle.class);

        isAgeHpOk(customer,vehicle);
        isVehicleAvailable(reservation);
        isCustomerNotAlreadyEngage(reservation);

        reservation.setPrice(PriceController.calculatePrice(vehicle,reservation));
        Reservation reservationAdded = reservationRepository.save(reservation);
        return Optional.of(reservationAdded);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationRepository.deleteById(id);
    }

    public void setMaintenanceReservation(LocalDate lastEnd,int maintenanceDowntime,int vehicleId){
        Reservation nextMaintenanceReservation = new Reservation();
        nextMaintenanceReservation.setCustomerId(1);
        nextMaintenanceReservation.setRentalStart(lastEnd);
        nextMaintenanceReservation.setRentalEnd(lastEnd.plusDays(maintenanceDowntime));
        nextMaintenanceReservation.setVehicleId(vehicleId);
        System.out.println(nextMaintenanceReservation);
    }
    public void findMaintenanceReservationDate(MaintenanceTicket maintenanceNeeded,int vehicleId){
        List<Reservation> allReservations = getAllReservationsForVehicle(vehicleId);
        for(int i=0;i<allReservations.size();i++){
            LocalDate lastEnd;
            if (i == 0) {
                lastEnd = LocalDate.now();
            }else {
                lastEnd = allReservations.get(i-1).getRentalEnd();
            }

            LocalDate nextStart = allReservations.get(i).getRentalStart();

            if (Period.between(lastEnd,nextStart).getDays()>=maintenanceNeeded.getDowntime()){
                setMaintenanceReservation(lastEnd,maintenanceNeeded.getDowntime(),vehicleId);
            }
            if(i==allReservations.size()-1){
                setMaintenanceReservation(allReservations.get(i).getRentalEnd(),maintenanceNeeded.getDowntime(),vehicleId);
            }
        }
    }
    @PutMapping("/return/{odometerReturn}")
    public void vehicleReturn(@RequestBody Reservation reservation,@PathVariable int odometerReturn){
        //ajuster le tarif / calculer le prix differenciel
        Vehicle vehicle = restTemplate.getForObject("http://MSA-VEHICLE/vehicles/" + reservation.getVehicleId(), Vehicle.class);
        double mileageBonus = PriceController.calculateMileagePrice(vehicle,odometerReturn-vehicle.getOdometer()-reservation.getMileageEstimation());
        System.out.println(mileageBonus);
        System.out.println(vehicle);
        if(mileageBonus>0){
            reservation.setPriceSurplus(mileageBonus);
        }
        vehicle.setOdometer(odometerReturn);
        restTemplate.put("http://MSA-VEHICLE/vehicles/", vehicle, Vehicle.class);
        List<MaintenanceTicket> maintenanceTicket = restTemplate.getForObject("http://MSA-VEHICLE/vehicles/cm/" + vehicle.getId(), List.class);
        System.out.println(maintenanceTicket);
        if(!maintenanceTicket.isEmpty()){
            maintenanceTicket.forEach(maintenanceNeeded->findMaintenanceReservationDate(maintenanceNeeded,vehicle.getId()));
        }
    }
}
