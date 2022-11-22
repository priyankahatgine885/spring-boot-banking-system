package com.cognologix.springboot.controller;

import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerListResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerResponse;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * Add customer response entity.
     *
     * @param customerDTO the customer dto
     * @return the response entity
     */
    @PostMapping("/customer")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = customerService.addCustomer(customerDTO);
            response.setMessage("Customer created successfully");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return the account by id
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getAccountById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = customerService.getCustomerById(id);
        } catch (Exception ex) {
            System.out.println();
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Gets customers.
     *
     * @return the customers
     */
    @GetMapping("/customer")
    public ResponseEntity<CustomerListResponse> getCustomers() {
        CustomerListResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = customerService.getCustomers();
            response.setMessage("'GET method' received request ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        } catch (RuntimeException ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Update customer response entity.
     *
     * @param id       the id
     * @param customer the customer
     * @return the response entity
     */
    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customer) {
        try {
            CustomerResponse response = customerService.updateCustomer(id, customer);
            response.setMessage("Customer updated successfully");
            HttpStatus statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response, statusCode);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete customer response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int id) {
        CustomerResponse response = null;
        HttpStatus statusCode = null;
        try {
            customerService.deleteCustomer(id);
            response = new CustomerResponse(true);
            response.setMessage("Account delete successfully");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }

}
