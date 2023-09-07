package fr.campusnumerique.reservation.dao;

import fr.campusnumerique.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {



}
