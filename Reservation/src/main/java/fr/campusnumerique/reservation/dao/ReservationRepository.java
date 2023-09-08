package fr.campusnumerique.reservation.dao;

import fr.campusnumerique.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value="SELECT * FROM reservation r WHERE r.vehicle_id = :vehicleId AND rental_start > LOCALTIME", nativeQuery = true)
    List<Reservation> findReservationPlanning(@Param("vehicleId") int VehicleId);

}
