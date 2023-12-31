package fr.campusnumerique.customer.controller;


import fr.campusnumerique.customer.dao.CustomerRepository;
import fr.campusnumerique.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @GetMapping
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomersById(@PathVariable int id){ return customerRepository.findById(id); }

    @PostMapping
    public Optional<Customer> addCustomers(@RequestBody Customer customer){
        Validator.licenseValidator(customer.getLicenseId());
        if(!Validator.isMature(customer.getBirthdate())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "You need to be over 18 years old to reserve a vehicle");
        }
        Customer customerAdded = customerRepository.save(customer);
        return Optional.of(customerAdded);
    }

    @PutMapping
    public Customer updateCustomers(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @DeleteMapping(value="/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
    }

    //Get reserved vehicle ID's for a specific customer
    @GetMapping(value="/getReservations/{id}")
    public List getReservations(@PathVariable int id){
        return customerRepository.findReservedVehicles(id);
    }


}
