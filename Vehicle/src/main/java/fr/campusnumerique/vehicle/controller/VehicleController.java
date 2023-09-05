package fr.campusnumerique.vehicle.controller;

import fr.campusnumerique.vehicle.dao.VehicleRepository;
import fr.campusnumerique.vehicle.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) { this.vehicleRepository = vehicleRepository; }

    @GetMapping
    public @ResponseBody Iterable<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable int id){ return vehicleRepository.findById(id); }

    @PostMapping
    public Optional<Vehicle> addVehicles(@RequestBody Vehicle vehicle){
        Vehicle vehicleAdded = vehicleRepository.save(vehicle);
        return Optional.of(vehicleAdded);
    }

    @PutMapping
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping(value="/{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleRepository.deleteById(id);
    }



}
