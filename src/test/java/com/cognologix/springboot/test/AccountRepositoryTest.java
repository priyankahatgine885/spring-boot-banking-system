/*
package com.cognologix.springboot.test;

import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.AccountType;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.exception.NameAlreadyExistException;
import com.cognologix.springboot.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountService accountService;

    @Test
    public void addAccount_addNewAccount_success() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("23456789");
        //accountDTO.setCustomerInfo();
        accountDTO.setBalance(1500.0);
        accountDTO.setAccountType(AccountType.SAVING);
        Account account = accountDao.save(new Account(accountDTO));
        Assert.assertNotNull(account);
        Assert.assertTrue(account.getId() > 0);
    }

    @Test
    public void addAccount_addDuplicateAccount_nameAlreadyExistException() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("23456789");
        //accountDTO.setCustomerInfo();
        accountDTO.setBalance(1500.0);
        accountDTO.setAccountType(AccountType.SAVING);
        Account account = accountDao.save(new Account(accountDTO));
        Exception exception = Assert.assertThrows(NameAlreadyExistException.class, () -> {
            accountDao.save(new Account(accountDTO));
        });
        final String expectedMessage = "Account Name already exist";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getListAccounts_getListAccounts_emptyListException() {
        List<Account> accountList = accountDao.findAll();
        if (accountList.size() != 0) {
            Assert.assertNotNull(accountList);
        } else {
            throw new EmptyListException("List is empty");
        }
    }

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
*/
