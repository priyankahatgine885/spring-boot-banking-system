package com.cognologix.springboot.service;

import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerListResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerResponse;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.exception.NameAlreadyExistException;

/**
 * The interface Customer service.
 */
public interface CustomerService {
    /**
     * Add customer customer response.
     *
     * @param customer the customer
     * @return the customer response
     * @throws NameAlreadyExistException the name already exist exception
     */
    CustomerResponse addCustomer(CustomerDTO customer) throws NameAlreadyExistException;

    /**
     * Gets customer by id.
     *
     * @param id the id
     * @return the customer by id
     * @throws AccountNotFoundException the account not found exception
     */
    Customer getCustomerById(int id) throws AccountNotFoundException;

    /**
     * Gets customers.
     *
     * @return the customers
     * @throws EmptyListException the empty list exception
     */
    CustomerListResponse getCustomers() throws EmptyListException;

    /**
     * Update customer customer response.
     *
     * @param id       the id
     * @param customer the customer
     * @return the customer response
     */
    CustomerResponse updateCustomer(int id, Customer customer);

    /**
     * Delete customer.
     *
     * @param id the id
     */
    void deleteCustomer(int id);
}
