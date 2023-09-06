package fr.campusnumerique.vehicle.dao;

import fr.campusnumerique.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

    @Query(value = "SELECT * FROM vehicle v WHERE v.id NOT IN (SELECT vehicle_id FROM reservation)", nativeQuery = true)
    Collection<Vehicle> findAvailability();

//    @Query(value = "SELECT * FROM vehicle", nativeQuery = true)
//    Collection<Vehicle> findAvailability();

}


