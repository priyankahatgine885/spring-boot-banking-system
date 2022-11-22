package com.cognologix.springboot.test;

import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.exception.CustomerNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.exception.InvalidAmountException;
import com.cognologix.springboot.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


/**
 * The type Account service test.
 */
@RunWith(SpringRunner.class)
public class AccountServiceTest extends BaseInitializer {
    @Autowired
    private AccountService accountService;
    /**
     * The Account dao.
     */
    @Autowired
    AccountDao accountDao;

    /**
     * Add account add new account success.
     *
     * @throws CustomerNotFoundException the customer not found exception
     */
    @Test
    @Order(1)
    public void addAccount_addNewAccount_success() throws CustomerNotFoundException {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("34567321");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Mrunali");
        customerDTO.setMiddleName("Prakash");
        customerDTO.setLastName("Nikam");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("mrunaliP@gmail.com");
        accountDTO.setCustomerInfo(customerDTO);
        accountDTO.setBalance(5000.0);
        //accountDTO.setAccountType(AccountType.SAVING);
        AccountResponse employee = accountService.addAccount(accountDTO);
        Assert.assertNotNull(employee);

    }

    /**
     * Add account customer not found exception.
     */
    @Test
    public void addAccount_customerNotFoundException() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("55442629423269");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Mrunali");
        customerDTO.setMiddleName("Prakash");
        customerDTO.setLastName("Nikam");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("mrunaliP@gmail.com");
        accountDTO.setCustomerInfo(customerDTO);
        accountDTO.setBalance(5000.0);
        //  accountDTO.setAccountType(AccountType.SAVING);
        Exception exception = Assert.assertThrows(CustomerNotFoundException.class, () -> {
            accountService.addAccount(accountDTO);
        });
        final String expectedMessage = "Invalid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Gets list accounts get list account empty list exception.
     */
    @Test
    public void getListAccounts_getListAccount_emptyListException() {
        Exception exception = Assert.assertThrows(EmptyListException.class, () -> {
            accountService.getAccounts();
        });
        final String expectedMessage = "Account List is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    /**
     * Test deposit when amount is negative.
     */
    @Test
    public void testDepositWhenAmountIsNegative() {
        Exception exception = Assert.assertThrows(InvalidAmountException.class, () -> {
            accountService.depositAmount("55442629423269", 500);
        });
        Assert.assertEquals("Amount should be positive number", exception.getMessage());
    }

//    @Test
//    public void deleteAccount_success() {
//        Account account = accountDao.findById(1).get();
//        accountService.deleteAccount(account.getId());
//    }
}
