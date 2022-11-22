package com.cognologix.springboot.test;

import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.AccountType;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.DuplicateCustomerDetailsNotAllowed;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * The type Account repository test.
 */
@RunWith(SpringRunner.class)
public class AccountRepositoryTest extends BaseInitializer {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountServiceImpl accountService;

    /**
     * Add account add new account success.
     */
    @Test
    @Order(1)
    public void addAccount_addNewAccount_success() {
        AccountDTO accountDTO = new AccountDTO();
        accountService = new AccountServiceImpl();
        //AccountServiceImpl.generateAccountNumber();
        accountDTO.setAccountNumber("45678943");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Akshay");
        customerDTO.setMiddleName("Subhash");
        customerDTO.setLastName("Mali");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("akshayM@gmail.com");
        accountDTO.setCustomerInfo(customerDTO);
        accountDTO.setBalance(10000.0);
        accountDTO.setAccountType(AccountType.SAVING);
        Account account = accountDao.save(new Account(accountDTO));
        Assert.assertNotNull(account);
        Assert.assertTrue(account.getId() > 0);
    }

    /**
     * Add account name already exist exception.
     */
    @Test
    public void addAccount_nameAlreadyExistException() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("23456789");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Pratik");
        customerDTO.setMiddleName("Subhash");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("priyankaP");
        accountDTO.setCustomerInfo(customerDTO);
        accountDTO.setBalance(1500.0);
        accountDTO.setAccountType(AccountType.SAVING);
        Account account = accountDao.save(new Account(accountDTO));
        Exception exception = Assert.assertThrows(DuplicateCustomerDetailsNotAllowed.class, () -> {
            accountDao.save(new Account(accountDTO));
        });
        final String expectedMessage = "Account Name already exist";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Gets list accounts get list accounts empty list exception.
     */
    @Test
    public void getListAccounts_getListAccounts_emptyListException() {
        List<Account> accountList = accountDao.findAll();
        if (accountList.size() != 0) {
            Assert.assertNotNull(accountList);
        } else {
            throw new EmptyListException("List is empty");
        }
    }

    /**
     * Delete account resource not found exception.
     *
     * @throws AccountNotFoundException the account not found exception
     */
    @Test
    public void deleteAccount_ResourceNotFoundException() throws AccountNotFoundException {
        Account entity = accountDao.getOne(1);
        if (accountDao.existsById(entity.getId())) {
            accountDao.delete(entity);
        } else {
            throw new AccountNotFoundException("Employee not found for this id : ");
        }
    }
}
