package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.dao.ReservationRepository;
import fr.campusnumerique.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
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

    @PostMapping
    public Optional<Reservation> addReservations(@RequestBody Reservation reservation) {
        RestTemplate customerRestTemplate = new RestTemplate();
        Customer customer = customerRestTemplate.getForObject("http://192.168.1.239:8085/customers/" + reservation.getCustomerId(), Customer.class);
        RestTemplate vehicleRestTemplate = new RestTemplate();
        Vehicle vehicle = vehicleRestTemplate.getForObject("http://192.168.1.239:8086/vehicles/" + reservation.getVehicleId(), Vehicle.class);
        if (Validator.calculateAge(customer.getBirthdate()) < 21 && vehicle.getFiscalHp() > 8) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too young!!!");

        } else if (Validator.calculateAge(customer.getBirthdate()) < 25 && vehicle.getFiscalHp() > 13) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too much power!!!");
        }
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
            if(i==allReservations.size()){
                setMaintenanceReservation(allReservations.get(i).getRentalEnd(),maintenanceNeeded.getDowntime(),vehicleId);
            }
        }
    }
    @PutMapping
    public void vehicleReturn(Reservation reservation, int odometerReturn){
        //ajuster le tarif / calculer le prix differenciel
        RestTemplate vehicleRestTemplate = new RestTemplate();
        Vehicle vehicle = vehicleRestTemplate.getForObject("http://192.168.1.239:8086/vehicles/" + reservation.getVehicleId(), Vehicle.class);
        double mileageBonus = PriceController.calculateMileagePrice(vehicle,odometerReturn-vehicle.getOdometer()-reservation.getMileageEstimation());
        if(mileageBonus>0){
            reservation.setPriceSurplus(mileageBonus);
        }
        vehicle.setOdometer(odometerReturn);
        RestTemplate maintenanceTemplate = new RestTemplate();
        List<MaintenanceTicket> maintenanceTicket = maintenanceTemplate.getForObject("http://192.168.1.239:8086/vehicles/cm/" + vehicle.getId(), List.class);
        if(!maintenanceTicket.isEmpty()){
            maintenanceTicket.forEach(maintenanceNeeded->findMaintenanceReservationDate(maintenanceNeeded,vehicle.getId()));
        }
    }
}
