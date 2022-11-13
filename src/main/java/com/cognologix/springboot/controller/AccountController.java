package com.cognologix.springboot.controller;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.DepositWithdrawAmount;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody AccountDTO account) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
           response = this.accountService.addAccount(account);
            response.setMessage("Account created successfully");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id){
        Account account = null;
        try {
            account = accountService.getAccountById(id);
        } catch (Exception ex) {
            System.out.println();
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("/account")
    public ResponseEntity<AccountListResponse> getAccounts() {
        AccountListResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = this.accountService.getAccounts();
            response.setMessage("'GET method' received request ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        }catch(RuntimeException ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @PutMapping("/account/withdraw")
    public ResponseEntity<AccountResponse> withdrawAmount(@RequestBody DepositWithdrawAmount withdrawAmount) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try{
            response = this.accountService.withdrawAmount(withdrawAmount);
            response.setMessage("Withdrawn successfully ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @PutMapping("/account/deposit")
    public ResponseEntity<AccountResponse> depositAmount(@RequestBody DepositWithdrawAmount depositAmount) {
        AccountResponse response = null;
        HttpStatus statusCode = null;
        try {
            response = this.accountService.depositAmount(depositAmount);
            response.setMessage("Deposited successfully  ");
            statusCode = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @DeleteMapping("/account/{id}")
    public ResponseEntity<AccountResponse> deleteAccount(@PathVariable int id) {
        AccountResponse bankAccountResponse = null;
        HttpStatus statusCode = null;
        try {
            this.accountService.deleteAccount(id);
            bankAccountResponse = new AccountResponse(true);
            bankAccountResponse.setMessage("Account delete successfully");
            statusCode = bankAccountResponse.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        } catch (Exception ex) {
            ex.getCause();
        }
        return new ResponseEntity<>(bankAccountResponse, statusCode);
    }

}
