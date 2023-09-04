package fr.campusnumerique.customer.controller;


import fr.campusnumerique.customer.dao.CustomerRepository;
import fr.campusnumerique.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @GetMapping
    public @ResponseBody Iterable<Customer> getAllUsers(){
        return customerRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public @

}
