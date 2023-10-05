package fr.campusnumerique.vehicle.controller;

import com.sun.istack.NotNull;
import fr.campusnumerique.vehicle.dao.VehicleRepository;
import fr.campusnumerique.vehicle.model.MaintenanceTicket;
import fr.campusnumerique.vehicle.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) { this.vehicleRepository = vehicleRepository; }

    //List all vehicles
    @GetMapping
    public @ResponseBody Iterable<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    //List car by id
    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable int id){
        return vehicleRepository.findById(id); }

    //Get maintenance state of vehicle
    @GetMapping("/cm/{id}")
    public List<MaintenanceTicket> getMaintenanceState(@PathVariable int id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        List<MaintenanceTicket> maintenanceTicketList = MaintenanceController.vehicleControl(vehicle);
        vehicle.setMaintenanceTicket(maintenanceTicketList);
        vehicleRepository.save(vehicle);
        return maintenanceTicketList;
    }

//    @GetMapping("/")
//    public @ResponseBody Iterable<Vehicle> getAllVehiclesByAttribute(@RequestParam(required = false,value = "brand") String brand,
//                                                                     @RequestParam(required = false,value = "color") String color,
//                                                                     @RequestParam(required = false,value = "model") String model,
//                                                                     @RequestParam(required = false,value = "type") String type,
//                                                                     @RequestParam(required = false,value = "loadVolume") int loadVolume,
//                                                                     @RequestParam(required = false,value = "displacement") int displacement){
//
//        return vehicleRepository.findAllByAttribute(brand,color,model,type,loadVolume,displacement);
//    }

    @PostMapping
    public Optional<Vehicle> addVehicles(@RequestBody Vehicle vehicle){
        Vehicle vehicleAdded = vehicleRepository.save(vehicle);
        return Optional.of(vehicleAdded);
    }

    @PutMapping
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        //maintenace?
        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping(value="/{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleRepository.deleteById(id);
    }

    @GetMapping(value="available")
    public Collection<Vehicle> isAvailable(@RequestParam("type") String type, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return vehicleRepository.findAvailability(type,startDate,endDate);
    }

    //Possibility to search for multiple attributes
    //URL to use: http://localhost:8086/vehicles/?brand=Honda&type=car
    //add to url with &fiscalHp=13&color=red etc

    @GetMapping("/")
    public Collection<Vehicle> findByAttributes(
            @RequestParam(name = "brand", required = false) String brand,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "fiscalHp", required = false) Integer fiscalHp) {

        // Initializes a list to store vehicle to return
        List<Vehicle> filteredVehicles = new ArrayList<>();

        // Check each filter and add vehicles that match specified criteria
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            boolean matchesAllCriteria = true;

            if (brand != null && !brand.equals(vehicle.getBrand())) {
                matchesAllCriteria = false;
            }
            if (type != null && !type.equals(vehicle.getType())) {
                matchesAllCriteria = false;
            }
            if (color != null && !color.equals(vehicle.getColor())) {
                matchesAllCriteria = false;
            }
            if (fiscalHp != null && fiscalHp != vehicle.getFiscalHp()) {
                matchesAllCriteria = false;
            }
            if (matchesAllCriteria) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }




}
