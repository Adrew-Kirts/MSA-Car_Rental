package fr.campusnumerique.reservation.dao;

import fr.campusnumerique.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value="SELECT * FROM reservation r WHERE r.vehicle_id = :vehicleId AND r.rental_start > LOCALTIME", nativeQuery = true)
    List<Reservation> findReservationPlanning(@Param("vehicleId") int VehicleId);

    @Query(value="SELECT * FROM reservation r WHERE r.vehicle_id = :vehicleId AND (r.rental_start between :rentalStart and :rentalEnd) AND (r.rental_end between :rentalStart and :rentalEnd)", nativeQuery = true)
    List<Reservation> isBooked(@Param("vehicleId") int vehicleId, @Param("rentalStart")LocalDate rentalStart, @Param("rentalEnd")LocalDate rentalEnd);

    @Query(value="SELECT * FROM reservation r WHERE r.customer_id = :customerId AND (r.rental_start between :rentalStart and :rentalEnd) AND (r.rental_end between :rentalStart and :rentalEnd)", nativeQuery = true)
    List<Reservation> isEngage(@Param("customerId") int customerId, @Param("rentalStart")LocalDate rentalStart, @Param("rentalEnd")LocalDate rentalEnd);

}
