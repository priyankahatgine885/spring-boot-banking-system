package com.cognologix.springboot.controller;

import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.TransferAmountDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Account controller.
 */
@RestController
@RequestMapping
@Log4j2
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * Add account response entity.
     *
     * @param account the account
     * @return the response entity
     */
    @PostMapping("/account")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody AccountDTO account) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
            log.info("Adding Account");
            response = accountService.addAccount(account);
            response.setMessage("Account created successfully");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(new AccountResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return the account by id
     */
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Account account = null;
        try {
            account = accountService.getAccountById(id);
        } catch (Exception ex) {
            System.out.println();
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /**
     * Gets accounts.
     *
     * @return the accounts
     */
    @GetMapping("/account")
    public ResponseEntity<AccountListResponse> getAccounts() {
        AccountListResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = accountService.getAccounts();
            response.setMessage("Get account successfully");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        } catch (RuntimeException ex) {
            ex.getMessage();
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Withdraw amount response entity.
     *
     * @param accountNo the account no
     * @param amount    the amount
     * @return the response entity
     */
    @PutMapping("/account/withdraw")
    public ResponseEntity<AccountResponse> withdrawAmount(@RequestParam(value = "accountNumber") String accountNo,
                                                          @RequestParam(value = "amount") double amount) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = accountService.withdrawAmount(accountNo, amount);
            response.setMessage("Withdrawn successfully ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(new AccountResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Deposit amount response entity.
     *
     * @param accountNo the account no
     * @param amount    the amount
     * @return the response entity
     */
    @PutMapping("/account/deposit")
    public ResponseEntity<AccountResponse> depositAmount(@RequestParam(value = "accountNumber") String accountNo,
                                                         @RequestParam(value = "amount") double amount) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = accountService.depositAmount(accountNo, amount);
            response.setMessage("Deposited successfully  ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(new AccountResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Transfer amount response entity.
     *
     * @param transferAmountDTO the amount
     * @return the response entity
     */
    @PutMapping("/account/transfer")
    public ResponseEntity<AccountResponse> transferAmount(@RequestBody TransferAmountDTO transferAmountDTO) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
            accountService.transferAmount(transferAmountDTO);
            response = new AccountResponse(true);
            response.setMessage("Transaction Successful");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(new AccountResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Delete account response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/account/{id}")
    public ResponseEntity<AccountResponse> deleteAccount(@PathVariable int id) {
        AccountResponse bankAccountResponse = null;
        HttpStatus statusCode = null;
        try {
            accountService.deleteAccount(id);
            bankAccountResponse = new AccountResponse(true);
            bankAccountResponse.setMessage("Account delete successfully");
            statusCode = bankAccountResponse.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(new AccountResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bankAccountResponse, statusCode);
    }

}
