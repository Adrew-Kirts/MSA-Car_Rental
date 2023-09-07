package fr.campusnumerique.customer.dao;

import fr.campusnumerique.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    //Find reserved vehicle ID's for a specific client
    @Query(value = "SELECT vehicle_id FROM reservation WHERE customer_id = :customerId", nativeQuery = true)
    List findReservedVehicles(@Param("customerId") int customerId);
}



