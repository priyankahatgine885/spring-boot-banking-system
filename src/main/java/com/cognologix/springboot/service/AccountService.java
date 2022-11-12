package com.cognologix.springboot.service;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.InSufficientBalanceException;

public interface AccountService {
    BaseResponse addAccount(Account account);
    void displayAnAccount(String accountNumber) throws AccountNotFoundException;
    BaseResponse displayAllAccounts() throws AccountNotFoundException;
    void withdraw(String accountNumber) throws InSufficientBalanceException, AccountNotFoundException;
    void deposit(String accountNumber) throws AccountNotFoundException;
    boolean removeAnAccount(String accountNumber);
}
