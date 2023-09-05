package fr.campusnumerique.vehicle.dao;

import fr.campusnumerique.vehicle.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{
}
