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

    /**
     * Find customer by first name customer.
     *
     * @param firstName the first name
     * @return the customer
     */
    Customer findCustomerByFirstName(String firstName);

    /**
     * Find customer by middle name customer.
     *
     * @param middleName the middle name
     * @return the customer
     */
    Customer findCustomerByMiddleName(String middleName);

    /**
     * Find customer by last name customer.
     *
     * @param lastName the last name
     * @return the customer
     */
    Customer findCustomerByLastName(String lastName);
}
