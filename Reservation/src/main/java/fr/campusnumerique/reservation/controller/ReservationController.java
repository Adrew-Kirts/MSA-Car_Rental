package fr.campusnumerique.reservation.controller;

import fr.campusnumerique.reservation.dao.ReservationRepository;
import fr.campusnumerique.reservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }

    @GetMapping
    public @ResponseBody Iterable<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id){ return reservationRepository.findById(id); }

    @PostMapping
    public Optional<Reservation> addReservations(@RequestBody Reservation reservation){
        Reservation reservationAdded = reservationRepository.save(reservation);
        return Optional.of(reservationAdded);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationRepository.save(reservation);
    }

    @DeleteMapping(value="/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationRepository.deleteById(id);
    }



}
