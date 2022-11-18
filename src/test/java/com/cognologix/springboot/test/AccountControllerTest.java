package com.cognologix.springboot.test;

import com.cognologix.springboot.controller.AccountController;
import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.AccountType;
import com.cognologix.springboot.exception.EmptyListException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {
    @Autowired
    private AccountController accountController;
    @Autowired
    private AccountDao accountDao;

    @Test
    @Order(1)
    public void addAccount_success() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBalance(1500.0);
        accountDTO.setAccountType(AccountType.SAVING);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Pratik");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9988776655");
        accountDTO.setCustomerInfo(customerDTO);
        ResponseEntity<AccountResponse> response = accountController.addAccount(accountDTO);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertNotNull(response.getBody().getAccount());
    }


    @Test
    public void getListAccounts_getListAccountsEmptyListException() {
        ResponseEntity<AccountListResponse> response = accountController.getAccounts();
        if (response.getBody().getSize() != 0) {
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
            Assert.assertEquals(response.getBody().getSuccess(), true);
            Assert.assertNotNull(response.getBody().getAccountList());
        } else {
            throw new EmptyListException("List is empty");
        }
    }

//    @Test
//    public void updateEmployee_updateNewEmployee_success() {
//        Employee employee = new Employee();
//        employee.setName("Priyanka Hatgine");
//        employee.setSalary(20000);
//        ResponseEntity<EmployeeResponse> response = employeeController.updateEmployee(2, employee);
//        if(response.getStatusCode() == HttpStatus.OK) {
//            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
//            Assert.assertEquals(response.getBody().getSuccess(), true);
//            Assert.assertEquals(response.getBody().getEmployee().getName(), employee.getName());
//        }else {
//            Assert.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
//            Assert.assertEquals(response.getBody().getSuccess(), false);
//        }
//    }

    @Test
    public void deleteEmployee_success() {
        Account account = accountDao.findById(1).get();
        ResponseEntity<AccountResponse> response = accountController.deleteAccount(account.getId());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertFalse(response.getBody().getSuccess());
    }
}
