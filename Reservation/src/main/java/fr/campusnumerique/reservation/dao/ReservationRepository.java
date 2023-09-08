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

    @Query(value="SELECT * FROM reservation r WHERE r.vehicle_id = :vehicleID AND r.rental_start < :rentalStart < r.rental_end AND r.rental_start < :rentalStart < r.rental_end", nativeQuery = true)
    boolean isAvailable(@Param("vehicleId") int vehicleId, @Param("rentalStart")LocalDate rentalStart, @Param("rentalEnd")LocalDate rentalEnd);

    @Query(value="SELECT * FROM reservation r WHERE r.customer_id = :customerID AND r.rental_start < :rentalStart < r.rental_end AND r.rental_start < :rentalStart < r.rental_end", nativeQuery = true)
    boolean isDisengage(@Param("customerId") int customerId, @Param("rentalStart")LocalDate rentalStart, @Param("rentalEnd")LocalDate rentalEnd);

}
