package com.cognologix.springboot.test;

import com.cognologix.springboot.dao.CustomerDao;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerResponse;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.exception.CustomerNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * The type Customer service test.
 */
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    /**
     * The Customer dao.
     */
    @Autowired
    CustomerDao customerDao;

    /**
     * Add customer add new customer success.
     *
     * @throws CustomerNotFoundException the customer not found exception
     */
    @Test
    @Order(1)
    public void addCustomer_addNewCustomer_success() throws CustomerNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Sachin");
        customerDTO.setMiddleName("Mahavir");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9634256167");
        customerDTO.setEmail("sachinP@gmail.com");
        customerDTO.setAadharNumber("1237896543");
        CustomerResponse customerResponse = customerService.addCustomer(customerDTO);
        Assert.assertNotNull(customerResponse);

    }

    /**
     * Add account customer not found exception.
     */
    @Test
    public void addAccount_customerNotFoundException() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Mrunali");
        customerDTO.setMiddleName("Prakash");
        customerDTO.setLastName("Nikam");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("mrunaliP@gmail.com");
        customerDTO.setAadharNumber("1237896543");
        Exception exception = Assert.assertThrows(CustomerNotFoundException.class, () -> {
            customerService.addCustomer(customerDTO);
        });
        assertEquals("Customer not found ", exception.getMessage());
    }

    /**
     * Gets list customers empty list exception.
     */
    @Test
    public void getListCustomers_emptyListException() {
        Exception exception = Assert.assertThrows(EmptyListException.class, () -> {
            customerService.getCustomers();
        });
        assertEquals("Customer List is empty", exception.getMessage());

    }

    /**
     * Delete customer success.
     */
    @Test
    public void deleteCustomer_success() {
        Customer customer = customerDao.findById(1).get();
        customerService.deleteCustomer(customer.getId());
    }
}
