package fr.campusnumerique.reservation.dao;

import fr.campusnumerique.reservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}
