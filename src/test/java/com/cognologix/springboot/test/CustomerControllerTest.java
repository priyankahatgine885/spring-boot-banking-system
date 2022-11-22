package com.cognologix.springboot.test;

import com.cognologix.springboot.controller.CustomerController;
import com.cognologix.springboot.dao.CustomerDao;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerListResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerResponse;
import com.cognologix.springboot.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The type Customer controller test.
 */
@RunWith(SpringRunner.class)
public class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerDao customerDao;

    /**
     * Add customer success.
     */
    @Test
    @Order(1)
    public void addCustomer_success() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Sachin");
        customerDTO.setMiddleName("Mahavir");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9634256167");
        customerDTO.setEmail("sachinP@gmail.com");
        customerDTO.setAadharNumber("1237896543");
        ResponseEntity<CustomerResponse> response = customerController.addCustomer(customerDTO);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertNotNull(response.getBody().getCustomer());
    }


    /**
     * Gets list customer success.
     */
    @Test
    public void getListCustomer_success() {
        ResponseEntity<CustomerListResponse> response = customerController.getCustomers();
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertNotNull(response.getBody().getCustomerList());
        Assert.assertTrue(response.getBody().getSize() > 0);
    }

    /**
     * Update customer success.
     */
    @Test
    public void updateCustomer_success() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Sagar");
        customerDTO.setMiddleName("Mahavir");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9634256167");
        customerDTO.setEmail("sachinP@gmail.com");
        customerDTO.setAadharNumber("1237896543");
        ResponseEntity<CustomerResponse> response = customerController.updateCustomer(2, customerDTO);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertEquals(response.getBody().getCustomer().getAadharNumber(), customerDTO.getAadharNumber());
    }


    /**
     * Delete customer success.
     */
    @Test
    public void deleteCustomer_success() {
        Customer customer = customerDao.findById(1).get();
        ResponseEntity<CustomerResponse> response = customerController.deleteCustomer(customer.getId());
        Assert.assertTrue(response.getBody().getSuccess());
    }

}
