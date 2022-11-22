package com.cognologix.springboot.service.impl;

import com.cognologix.springboot.dao.CustomerDao;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerListResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerResponse;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.CustomerNotFoundException;
import com.cognologix.springboot.exception.DuplicateCustomerDetailsNotAllowed;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Customer service.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public CustomerResponse addCustomer(CustomerDTO customer) throws DuplicateCustomerDetailsNotAllowed, CustomerNotFoundException {
        if (Objects.isNull(customer)) {
            throw new CustomerNotFoundException("Customer not found");
        }
        return new CustomerResponse(customerDao.save(new Customer(customer)));
    }

    @Override
    public Customer getCustomerById(int id) throws AccountNotFoundException {
        if ((id <= 0)) {
            throw new AccountNotFoundException("Customer Not Exist" + id);
        }
        return customerDao.findById(id).get();
    }

    @Override
    public CustomerListResponse getCustomers() throws EmptyListException {
        List<Customer> customerList = customerDao.findAll();
        if (customerList.isEmpty()) {
            throw new EmptyListException("Customer List is empty");
        }
        return new CustomerListResponse(customerList, customerList.size());
    }

    @Override
    public CustomerResponse updateCustomer(int id, CustomerDTO customer) {
        Customer customers = customerDao.findById(id).get();
        if (Objects.isNull(customers)) {
            throw new NullPointerException("Null Pointer Exception");
        }
        customers.setFirstName(customer.getFirstName());
        customers.setMiddleName((customer.getMiddleName()));
        customers.setLastName(customer.getLastName());
        customers.setPhone(customer.getPhone());
        customers.setEmail(customer.getEmail());
        customers.setAadharNumber(customer.getAadharNumber());
        customers.setCreatedDt(customer.getCreatedDt());
        customers.setModifiedDt(customer.getModifiedDt());
        return new CustomerResponse(customerDao.save(customers));
    }

    @Override
    public void deleteCustomer(int id) {
        Customer entity = customerDao.getOne(id);
        if (customerDao.existsById(id)) {
            customerDao.delete(entity);
        } else {
            System.out.println("Customer Not exist");
        }
    }
}
