package com.cognologix.springboot.dao;

import com.cognologix.springboot.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer dao.
 */
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    /**
     * Find customer by id customer.
     *
     * @param id the id
     * @return the customer
     */
    Customer findCustomerById(int id);
}
