package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.dao.ReservationRepository;
import fr.campusnumerique.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id) {
        return reservationRepository.findById(id);
    }

    @PostMapping
    public Optional<Reservation> addReservations(@RequestBody Reservation reservation) {
        RestTemplate customerRestTemplate = new RestTemplate();
        Customer customer = customerRestTemplate.getForObject("http://192.168.1.239:8085/Customers/" + reservation.getCustomerId(), Customer.class);
        RestTemplate vehicleRestTemplate = new RestTemplate();
        Vehicle vehicle = vehicleRestTemplate.getForObject("http://192.168.1.239:8086/vehicles/" + reservation.getVehicleId(), Vehicle.class);
        if (Validator.calculateAge(customer.getBirthdate()) < 21 && vehicle.getFiscalHp() > 8) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too young!!!");

        } else if (Validator.calculateAge(customer.getBirthdate()) < 25 && vehicle.getFiscalHp() > 13) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "too much power!!!");

        }
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

}
