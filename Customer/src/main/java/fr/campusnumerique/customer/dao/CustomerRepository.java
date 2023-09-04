package fr.campusnumerique.customer.dao;

import fr.campusnumerique.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
