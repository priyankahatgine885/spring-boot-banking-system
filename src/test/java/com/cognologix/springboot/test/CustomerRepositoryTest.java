package com.cognologix.springboot.test;

import com.cognologix.springboot.dao.CustomerDao;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Customer repository test.
 */
public class CustomerRepositoryTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * Add customer add new customer success.
     */
    @Test
    @Order(1)
    public void addCustomer_addNewCustomer_success() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Akshay");
        customerDTO.setMiddleName("Subhash");
        customerDTO.setLastName("Mali");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("akshayM@gmail.com");
        customerDTO.setAadharNumber("4532768543");
        Customer customer = customerDao.save(new Customer(customerDTO));
        Assert.assertNotNull(customer);
        Assert.assertTrue(customer.getId() > 0);
    }
//
//    @Test
//    public void addAccount_customerNotFoundExceptionException() {
//        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setAccountNumber("23456789");
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setFirstName("Pratik");
//        customerDTO.setMiddleName("Subhash");
//        customerDTO.setLastName("Patil");
//        customerDTO.setPhone("9988776655");
//        customerDTO.setEmail("priyankaP");
//        accountDTO.setCustomerInfo(customerDTO);
//        accountDTO.setBalance(1500.0);
//        accountDTO.setAccountType(AccountType.SAVING);
////        Account account = accountDao.save(new Account(accountDTO));
////        Exception exception = Assert.assertThrows(DuplicateCustomerDetailsNotAllowed.class, () -> {
////            accountDao.save(new Account(accountDTO));
////        });
//        final String expectedMessage = "Account Name already exist";
//        String actualMessage = exception.getMessage();
//        Assert.assertTrue(actualMessage.contains(expectedMessage));
//    }
//
//    @Test
//    public void getListAccounts_getListAccounts_emptyListException() {
//        List<Account> accountList = accountDao.findAll();
//        if (accountList.size() != 0) {
//            Assert.assertNotNull(accountList);
//        } else {
//            throw new EmptyListException("List is empty");
//        }
//    }
//
//    @Test
//    public void deleteAccount_ResourceNotFoundException() throws AccountNotFoundException {
//        Account entity = accountDao.getOne(1);
//        if (accountDao.existsById(entity.getId())) {
//            accountDao.delete(entity);
//        } else {
//            throw new AccountNotFoundException("Employee not found for this id : ");
//        }
//    }
}
