package fr.campusnumerique.customer.controller;


import fr.campusnumerique.customer.dao.CustomerRepository;
import fr.campusnumerique.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer){
        //License Validator
        //Age Validator(18)
        Customer customerAdded = customerRepository.save(customer);
        if (Objects.isNull(customerAdded)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public Customer updateCustomers(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @DeleteMapping(value="/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
    }



}
