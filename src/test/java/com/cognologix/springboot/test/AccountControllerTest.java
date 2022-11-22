package com.cognologix.springboot.test;

import com.cognologix.springboot.controller.AccountController;
import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.AccountType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The type Account controller test.
 */
@RunWith(SpringRunner.class)
public class AccountControllerTest extends BaseInitializer {

    @Autowired
    private AccountController accountController;
    @Autowired
    private AccountDao accountDao;

    /**
     * Add account success.
     */
    @Test
    public void addAccount_success() {
        AccountDTO accountDTO = new AccountDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Pratik");
        customerDTO.setMiddleName("Subhash");
        customerDTO.setLastName("Patil");
        customerDTO.setPhone("9988776655");
        customerDTO.setEmail("priyankaP");
        customerDTO.setAadharNumber("1234567892");
        accountDTO.setCustomerInfo(customerDTO);
        accountDTO.setBalance(1500.0);
        accountDTO.setAccountType(AccountType.SAVING);
        ResponseEntity<AccountResponse> response = accountController.addAccount(accountDTO);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertNotNull(response.getBody().getAccount());
        Assert.assertEquals("Pratik", response.getBody().getAccount().getCustomerInfo().getFirstName());
    }

    /**
     * Gets list accounts success.
     */
    @Test
    public void getListAccounts_success() {
        ResponseEntity<AccountListResponse> response = accountController.getAccounts();
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertNotNull(response.getBody().getAccountList());
        Assert.assertTrue(response.getBody().getSize() > 0);
    }

    /**
     * Withdraw amount success.
     */
    @Test
    public void withdrawAmount_success() {
        ResponseEntity<Account> acc = accountController.getAccountById(1);
        final Double withdrawAmount = 700.0;
        Double existingBalance = acc.getBody().getBalance();
        Double balanceAfterWithdraw = existingBalance - withdrawAmount;
        ResponseEntity<AccountResponse> response = accountController.
                withdrawAmount(acc.getBody().getAccountNumber(), withdrawAmount);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertEquals(balanceAfterWithdraw, response.getBody().getAccount().getBalance(), 100);

    }

    /**
     * Deposit amount success.
     */
    @Test
    public void depositAmount_success() {
        final Double depositAmount = 500.0;
        ResponseEntity<Account> acc = accountController.getAccountById(1);
        Double existingBalance = acc.getBody().getBalance();
        Double balanceAfterDeposit = existingBalance + depositAmount;
        ResponseEntity<AccountResponse> response = accountController.depositAmount(acc.getBody().getAccountNumber(), 500);
        Assert.assertTrue(response.getBody().getSuccess());
        Assert.assertEquals(balanceAfterDeposit, response.getBody().getAccount().getBalance(), 100);

    }


//    @Test
//    @Order(5)
//    public void transferAmount_success() {
//        ResponseEntity<Account> accountFirst = accountController.getAccountById(1);
//        ResponseEntity<Account> accountSecond = accountController.getAccountById(2);
////       // ResponseEntity<AccountResponse> response = accountController.depositAmount(acc.getBody().getAccountNumber(), 500);
////        Assert.assertTrue(response.getBody().getSuccess());
////        Assert.assertEquals(1000.0, response.getBody().getAccount().getBalance(), 2000.0);
//
//    }

//    @Test
//    public void deleteAccount_success() {
//        Account account = accountDao.findById(1).get();
//        ResponseEntity<AccountResponse> response = accountController.deleteAccount(account.getId());
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assert.assertTrue(response.getBody().getSuccess());
//    }

}
